package com.asteroid.factory;

import com.asteroid.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelFactory {

    public static Asteroid asteroid() {
        return Asteroid.builder()
                .neoReferenceId("3729835")
                .isPotentiallyHazardousAsteroid(true)
                .name("(2015 TB145)")
                .estimatedDiameter(diameter())
                .closeApproachData(closeApproachDataList())
                .build();
    }

    public static Kilometers kilometers() {
        return Kilometers.builder()
                .estimatedDiameterMax(BigDecimal.valueOf(0.5834988155))
                .estimatedDiameterMin(BigDecimal.valueOf(0.2609486033))
                .build();
    }

    public static Diameter diameter() {
        return Diameter.builder()
                .kilometers(kilometers())
                .build();
    }

    public static CloseApproachData closeApproachData() {
        return CloseApproachData.builder()
               .closeApproachDate("1920-10-09")
                .orbitingBody("Earth")
                .relativeVelocity(relativeVelocity())
                .build();
    }

    public static RelativeVelocity relativeVelocity() {
        return RelativeVelocity.builder()
                .kilometersPerHour(Double.valueOf(146102.4923395975))
                .build();
    }

    public static List<CloseApproachData> closeApproachDataList() {
        List<CloseApproachData> closeApproachDataList = new ArrayList<>();
        closeApproachDataList.add(closeApproachData());
        closeApproachDataList.add(closeApproachData());
        return closeApproachDataList;
    }

    public static AsteroidResponse asteroidResponse() {
        return AsteroidResponse.builder()
                .name("(2015 TB145)")
                .diametre(BigDecimal.valueOf(0.4222237094))
                .speed(Double.valueOf( 146102.4923395975))
                .date(LocalDate.now())
                .planet("Earth")
                .build();
    }

    public static List<AsteroidResponse> asteroidResponseList() {
        List<AsteroidResponse> asteroidResponseList = new ArrayList<>();
        asteroidResponseList.add(asteroidResponse());
        asteroidResponseList.add(asteroidResponse());
        return asteroidResponseList;
    }

}
