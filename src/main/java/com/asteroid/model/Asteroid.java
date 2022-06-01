package com.asteroid.model;

import java.util.List;

public class Asteroid {

    private Boolean is_potentially_hazardous_asteroid;
    private Boolean is_sentry_object;
    private String neo_reference_id; //"close_approach_data:relative_velocity:kilometers_per_hour"
    private String name; //fecha: "close_approach_data:close_approach_date"
    private String name_limited; //"close_approach_date:orbiting_body"
    private String designation;
    private String nasa_jpl_url;
    private Diameter estimated_diameter;
    private List<CloseApproachData> close_approach_data;

    public Asteroid() {
    }

    public Boolean getIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public void setIs_potentially_hazardous_asteroid(Boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }

    public Boolean getIs_sentry_object() {
        return is_sentry_object;
    }

    public void setIs_sentry_object(Boolean is_sentry_object) {
        this.is_sentry_object = is_sentry_object;
    }

    public String getNeo_reference_id() {
        return neo_reference_id;
    }

    public void setNeo_reference_id(String neo_reference_id) {
        this.neo_reference_id = neo_reference_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_limited() {
        return name_limited;
    }

    public void setName_limited(String name_limited) {
        this.name_limited = name_limited;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNasa_jpl_url() {
        return nasa_jpl_url;
    }

    public void setNasa_jpl_url(String nasa_jpl_url) {
        this.nasa_jpl_url = nasa_jpl_url;
    }

    public Diameter getEstimated_diameter() {
        return estimated_diameter;
    }

    public void setEstimated_diameter(Diameter estimated_diameter) {
        this.estimated_diameter = estimated_diameter;
    }

    public List<CloseApproachData> getClose_approach_data() {
        return close_approach_data;
    }

    public void setClose_approach_data(List<CloseApproachData> close_approach_data) {
        this.close_approach_data = close_approach_data;
    }
}
