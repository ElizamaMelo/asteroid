package com.asteroid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelativeVelocity {

    @JsonProperty("kilometers_per_hour")
    private Double kilometersPerHour;

}
