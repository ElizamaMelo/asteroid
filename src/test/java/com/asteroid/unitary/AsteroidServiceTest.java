package com.asteroid.unitary;

import com.asteroid.model.Asteroid;
import com.asteroid.service.AsteroidService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AsteroidServiceTest {


    @InjectMocks
    private AsteroidService service;

    @Test
    @DisplayName("GIVEN an id WHEN trying to find an asteroid by id THEN return an asteroid")
    public void findById_Return_asteroid() {

//        Astroid mockedHero = entity();
//        when(repository.findById(1)).thenReturn(Optional.of(mockedHero));
//
//        HeroDomain domain = service.findById(1);
//
//        assertEquals(mockedHero.getName(), domain.getName());
//        assertEquals(mockedHero.getCharacter(), domain.getCharacter());
    }
}
