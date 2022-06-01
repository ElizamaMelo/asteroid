package com.asteroid.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AsteroidResponse {

    private String name;
    private BigDecimal diametre;
    private Double speed;
    private LocalDate date;
    private String planet;

    public AsteroidResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDiametre() {
        return diametre;
    }

    public void setDiametre(BigDecimal diametre) {
        this.diametre = diametre;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }
}
