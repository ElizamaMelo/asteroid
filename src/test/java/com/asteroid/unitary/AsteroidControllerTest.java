package com.asteroid.unitary;

import com.asteroid.model.Asteroid;
import com.asteroid.model.AsteroidResponse;
import com.asteroid.service.AsteroidService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.asteroid.factory.ModelFactory.asteroid;
import static com.asteroid.factory.ModelFactory.asteroidResponseList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AsteroidControllerTest {

    public static final String URL = "http://localhost:8080/asteroid/info/";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AsteroidService service;

    @Test
    @DisplayName("GIVEN an asteroid id WHEN trying to find an asteroidList by id THEN return 200")
    public void getTopThreeAsteroidsById_Return_200() throws Exception {

        Asteroid asteroid = asteroid();
        List<AsteroidResponse> asteroidResponseList = asteroidResponseList();

        given(service.getAsteroid(anyString())).willReturn(asteroid);
        given(service.getTopThreeAsteroids(anyString())).willReturn(asteroidResponseList);

        mvc.perform(get(URL + asteroid.getNeoReferenceId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(asteroidResponseList.get(0).getName())))
                .andExpect(jsonPath("$[0].planet", is(asteroidResponseList.get(0).getPlanet())))
                .andExpect(status().isOk());
        verify(service, times(1)).getTopThreeAsteroids(anyString());
    }

}
