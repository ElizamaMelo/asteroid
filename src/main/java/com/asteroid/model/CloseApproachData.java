package com.asteroid.model;

public class CloseApproachData {

    private String close_approach_date;
    private String orbiting_body;
    private RelativeVelocity relative_velocity;

    public String getClose_approach_date() {
        return close_approach_date;
    }

    public void setClose_approach_date(String close_approach_date) {
        this.close_approach_date = close_approach_date;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public void setOrbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }

    public RelativeVelocity getRelative_velocity() {
        return relative_velocity;
    }

    public void setRelative_velocity(RelativeVelocity relative_velocity) {
        this.relative_velocity = relative_velocity;
    }
}

