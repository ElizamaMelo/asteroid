package com.asteroid.factory;

import com.asteroid.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AsteroidFactory {

    public static Asteroid domain() {
        return Asteroid.builder()
                .isPotentiallyHazardousAsteroid(true)
                .name("(2015 TB145)")
                //.estimatedDiameter()
               // .closeApproachData()
                .build();
    }

    public static Asteroid asteroid() {
        return Asteroid.builder()
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
        List<CloseApproachData> closeApproachData = new ArrayList<>();
        closeApproachData.add(closeApproachData());
        closeApproachData.add(closeApproachData());
        return closeApproachData;
    }
}
