package com.asteroid.service;

import com.asteroid.model.Asteroid;
import com.asteroid.model.AsteroidResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.asteroid.Constants.API_KEY;
import static com.asteroid.Constants.URL_NASA;

@Slf4j
@Service
public class AsteroidService {

    public Asteroid getAsteroid(String asteroidId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = URL_NASA + asteroidId + API_KEY;

        try {
            log.info("Sending request to NeoWs Api");
            ResponseEntity<Asteroid> response = restTemplate.getForEntity(url, Asteroid.class);

            log.info("Returning Asteroid model");
            return response.getBody();
        } catch (HttpClientErrorException e) {
            HttpStatus httpStatus = e.getStatusCode();

            log.error("An error occurred when trying to request with NeoWs Api, HttpStatus is: " + httpStatus);
            throw new ResponseStatusException(httpStatus, e.getMessage());
        }
    }


    public List<AsteroidResponse> getATop3Asteroid(String asteroidId) throws ValidationException {
        log.info("Finding 3 largest asteroids with potential impact risk");

        Asteroid asteroid = getAsteroid(asteroidId);
        List<AsteroidResponse> asteroidList = new ArrayList<>();

        if (asteroid != null && !asteroid.getIsPotentiallyHazardousAsteroid()) {

            log.error("An error occurred, asteroid is not potentially hazardous.");
            throw new ValidationException("Asteroid is not potentially hazardous.");
        } else {
            BigDecimal medio = calculateDiametre(asteroid);
            asteroid.getCloseApproachData().forEach(a -> {

                AsteroidResponse response = new AsteroidResponse();
                response.setDiametre(medio);
                response.setName(asteroid.getName());
                response.setPlanet(a.getOrbitingBody());
                response.setDate(LocalDate.parse(a.getCloseApproachDate()));
                response.setSpeed(a.getRelativeVelocity().getKilometersPerHour());
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

        BigDecimal result = null;
        if (asteroid.getEstimatedDiameter() != null) {
            log.info("Calculating the average diameter of an asteroid");
            BigDecimal diameterMax = asteroid.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax();
            BigDecimal diameterMin = asteroid.getEstimatedDiameter().getKilometers().getEstimatedDiameterMin();
            result = diameterMax.add(diameterMin).divide(BigDecimal.valueOf(2));
        }
        return result;
    }
}
