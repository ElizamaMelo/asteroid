package com.asteroid.unitary;

import com.asteroid.model.Asteroid;
import com.asteroid.model.AsteroidResponse;
import com.asteroid.service.AsteroidService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.List;

import static com.asteroid.factory.ModelFactory.asteroid;
import static com.asteroid.factory.ModelFactory.asteroidResponseList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AsteroidServiceTest {

    @MockBean
    private AsteroidService service;

    @Test
    @DisplayName("GIVEN an id WHEN trying to get an asteroid by id THEN return an asteroid")
    public void getAsteroid_Return_asteroid() {

        Asteroid mokedAsteroid = asteroid();
        when(service.getAsteroid("3729835")).thenReturn(mokedAsteroid);

        Asteroid asteroid = service.getAsteroid("3729835");

        assertEquals(mokedAsteroid.getName(), asteroid.getName());
        assertEquals(mokedAsteroid.getNeoReferenceId(), asteroid.getNeoReferenceId());
    }

    @Test
    @DisplayName("GIVEN an id WHEN trying get top three asteroids THEN return an asteroidList")
    public void getTopThreeAsteroids_Return_asteroidList() throws ValidationException {

        List<AsteroidResponse> mokedAsteroidResponse = asteroidResponseList();
        when(service.getTopThreeAsteroids("3729835")).thenReturn(mokedAsteroidResponse);

        List<AsteroidResponse> asteroidResponseList = service.getTopThreeAsteroids("3729835");

        assertEquals(mokedAsteroidResponse.get(0).getName(), asteroidResponseList.get(0).getName());
        assertEquals(mokedAsteroidResponse.get(0).getPlanet(), asteroidResponseList.get(0).getPlanet());

    }

    @Test
    @DisplayName("GIVEN an asteroid WHEN trying calculate diametre THEN return a BigDecimal")
    public void calculateDiametre_Return_bigDecimal() {

        Asteroid mokedAsteroid = asteroid();
        BigDecimal averageDiameter = BigDecimal.valueOf(0.4222237094);
        when(service.calculateDiametre(mokedAsteroid)).thenReturn(averageDiameter);

        BigDecimal diameter = service.calculateDiametre(mokedAsteroid);
        assertThat(averageDiameter, Matchers.comparesEqualTo(diameter));
    }
}
