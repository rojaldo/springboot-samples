package com.example.examples.reponses;


import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

public class BeerResponse{

    private long id;

    private String name;
    private String tagline;
    @JsonProperty("first_brewed")
    private String firstBrewed;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private double abv;
    private double ibu;
    private double ebc;

    public BeerResponse() {
    }

    public BeerResponse(int id, String name, String tagline, String firstBrewed, String description, String imageUrl,
            double abv, double ibu, double ebc) {
        this.name = name;
        this.tagline = tagline;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.abv = abv;
        this.ibu = ibu;
        this.ebc = ebc;
    }

    @Override
    public String toString() {
        return "BeerEntity [abv=" + abv + ", description=" + description + ", firstBrewed=" + firstBrewed + ", id=" + id
                + ", imageUrl=" + imageUrl + ", name=" + name + ", tagline=" + tagline + "]";
    }



    public String getName() {
        return name;
    }

    public String getTagline() {
        return tagline;
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

    public String getDescription() {
        return description;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }



}


