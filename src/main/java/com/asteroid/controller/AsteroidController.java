package com.asteroid.controller;

import com.asteroid.model.AsteroidResponse;
import com.asteroid.service.AsteroidService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation(value = "Finding the 3 closest asteroids to a planet")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping("/info/{asteroidId}")
    public ResponseEntity<List<AsteroidResponse>> getTopThreeAsteroidsById(@PathVariable @Validated String asteroidId) throws ValidationException {
        return new ResponseEntity<>(asteroidService.getTopThreeAsteroids(asteroidId), HttpStatus.OK);

    }

}
