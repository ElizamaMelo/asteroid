package com.asteroid.service;

import com.asteroid.model.Asteroid;
import com.asteroid.model.AsteroidResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.asteroid.Constants.API_KEY;
import static com.asteroid.Constants.URL_NASA;

@Service
public class AsteroidService {

    public Asteroid getAsteroid(String asteroidId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = URL_NASA + asteroidId + API_KEY;

        ResponseEntity<Asteroid> response = restTemplate.getForEntity(url, Asteroid.class);

        if (response.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Unauthorized");

        } else if (response.getStatusCode().equals(HttpStatus.FORBIDDEN)) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Forbidden");

        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");

        } else return response.getBody();
    }


    public List<AsteroidResponse> getATop3Asteroid(String asteroidId) throws ValidationException {

        Asteroid asteroid = getAsteroid(asteroidId);
        List<AsteroidResponse> asteroidList = new ArrayList<>();

        if (!asteroid.getIs_potentially_hazardous_asteroid()) {
            throw new ValidationException("Asteroidis is not potentially hazardous.");
        } else {
            BigDecimal medio = calculateDiametre(asteroid);
            asteroid.getClose_approach_data().forEach(a -> {

                AsteroidResponse response = new AsteroidResponse();
                response.setDiametre(medio);
                response.setName(asteroid.getName());
                response.setPlanet(a.getOrbiting_body());
                response.setDate(LocalDate.parse(a.getClose_approach_date()));
                response.setSpeed(a.getRelative_velocity().getKilometers_per_hour());
                asteroidList.add(response);
            });

        }

        //3 asteroids closest to the planet
        List<AsteroidResponse> top3 = asteroidList
                .stream()
                .sorted(Comparator.comparing(AsteroidResponse::getDate).reversed())
                .collect(Collectors.toList()).stream().limit(3).collect(Collectors.toList());

        return top3;
    }

    private BigDecimal calculateDiametre(Asteroid asteroid) {
        BigDecimal diameterMax = asteroid.getEstimated_diameter().getKilometers().getEstimated_diameter_max();
        BigDecimal diameterMin = asteroid.getEstimated_diameter().getKilometers().getEstimated_diameter_min();
        BigDecimal result = diameterMax.add(diameterMin).divide(BigDecimal.valueOf(2));
        return result;
    }

}
