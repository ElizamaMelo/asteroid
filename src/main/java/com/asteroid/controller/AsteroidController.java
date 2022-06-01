package com.asteroid.controller;

import com.asteroid.model.AsteroidResponse;
import com.asteroid.service.AsteroidService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.util.List;

@RequestMapping("/asteroid")
@RestController
public class AsteroidController {

    private final AsteroidService asteroidService;

    public AsteroidController(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @GetMapping("/info/{asteroidId}")
    public List<AsteroidResponse> getPlanetInfo(@PathVariable @Validated String asteroidId) throws ValidationException {
        return asteroidService.getATop3Asteroid(asteroidId);
    }

}
