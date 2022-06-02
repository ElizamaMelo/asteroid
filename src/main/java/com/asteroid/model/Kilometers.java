package com.asteroid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kilometers {

    @JsonProperty("estimated_diameter_min")
    private BigDecimal estimatedDiameterMin;

    @JsonProperty("estimated_diameter_max")
    private BigDecimal estimatedDiameterMax;

}
