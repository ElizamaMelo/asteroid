package com.asteroid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CloseApproachData {

    @JsonProperty("close_approach_date")
    private String closeApproachDate;

    @JsonProperty("orbiting_body")
    private String orbitingBody;

    @JsonProperty("relative_velocity")
    private RelativeVelocity relativeVelocity;

}

