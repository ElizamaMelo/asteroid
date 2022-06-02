package com.asteroid.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AsteroidResponse {

    private String name;
    private BigDecimal diametre;
    private Double speed;
    private LocalDate date;
    private String planet;

}
