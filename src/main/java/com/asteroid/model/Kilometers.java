package com.asteroid.model;

import java.math.BigDecimal;

public class Kilometers {

    private BigDecimal estimated_diameter_min;
    private BigDecimal estimated_diameter_max;

    public BigDecimal getEstimated_diameter_min() {
        return estimated_diameter_min;
    }

    public void setEstimated_diameter_min(BigDecimal estimated_diameter_min) {
        this.estimated_diameter_min = estimated_diameter_min;
    }

    public BigDecimal getEstimated_diameter_max() {
        return estimated_diameter_max;
    }

    public void setEstimated_diameter_max(BigDecimal estimated_diameter_max) {
        this.estimated_diameter_max = estimated_diameter_max;
    }
}
