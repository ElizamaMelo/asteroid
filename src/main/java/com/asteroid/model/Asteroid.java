package com.asteroid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Asteroid {

    @JsonProperty("is_potentially_hazardous_asteroid")
    private Boolean isPotentiallyHazardousAsteroid;

    private String name;

    @JsonProperty("estimated_diameter")
    private Diameter estimatedDiameter;

    @JsonProperty("close_approach_data")
    private List<CloseApproachData> closeApproachData;

}
