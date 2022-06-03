package com.asteroid.integration;

import com.asteroid.model.Asteroid;
import com.asteroid.model.AsteroidResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.asteroid.factory.ModelFactory.asteroid;
import static com.asteroid.factory.ModelFactory.asteroidResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // lifecycle will be per class and not per method
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsteroidTest {

    public static final String URL = "/asteroid/info";

    @Autowired
    private TestRestTemplate template;

    Asteroid asteroid;
    AsteroidResponse asteroidResponse;

    @BeforeAll
    public void init() {
        asteroid = asteroid();
        asteroidResponse = asteroidResponse();
    }

    @Test
    @DisplayName("WHEN trying to find all heroes THEN return a list of heroes | integrated test")
    public void getTopThreeAsteroidsById_Return_asteroids() {

        ResponseEntity<Object> response = this.template
                .exchange(URL + "/" + asteroid.getNeoReferenceId(), HttpMethod.GET, null, Object.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());

    }
}

