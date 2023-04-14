package com.example.examples.requests;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class BeerRequest{

    @NotBlank
    private String name;
    @Size(min = 10, max = 100)
    private String tagline;

    @JsonProperty("first_brewed")
    private String firstBrewed;

    @NotEmpty
    private String description;

    @JsonProperty("image_url")
    @URL
    private String imageUrl;

    @PositiveOrZero
    @Max(100)
    private double abv;

    @PositiveOrZero
    private double ibu;

    @PositiveOrZero
    private double ebc;

    public BeerRequest() {
    }

    public String getName() {
        return name;
    }

    public String getTagline() {
        return tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getAbv() {
        return abv;
    }

    public double getIbu() {
        return ibu;
    }

    public double getEbc() {
        return ebc;
    }



}