package com.example.examples.entities;

import java.util.ArrayList;

import org.hibernate.validator.constraints.URL;

import com.example.examples.reponses.BeerResponse;
import com.example.examples.requests.BeerRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

@Entity
@Table(name = "beers")
public class BeerEntity{
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private long id;

    @Size(min = 1, max = 255)
    private String name;
    @Size(min = 1, max = 255)
    private String tagline;

    @JsonProperty("first_brewed")
    @Size(min = 1, max = 255)
    private String firstBrewed;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @JsonProperty("image_url")
    @Size(min = 1, max = 255)
    @URL
    private String imageUrl;
    @Min(0)
    @Max(100)
    private double abv;
    @Min(0)
    private double ibu;
    @Min(0)
    private double ebc;

    public BeerEntity() {
    }

    public BeerEntity(String name, String tagline, String firstBrewed, String description, String imageUrl,
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

    public BeerEntity(BeerRequest request) {
        this.name = request.getName();
        this.tagline = request.getTagline();
        this.firstBrewed = request.getFirstBrewed();
        this.description = request.getDescription();
        this.imageUrl = request.getImageUrl();
        this.abv = request.getAbv();
        this.ibu = request.getIbu();
        this.ebc = request.getEbc();
    }

    public BeerEntity(BeerResponse beer) {
        this.name = beer.getName();
        this.tagline = beer.getTagline();
        this.firstBrewed = beer.getFirstBrewed();
        this.description = beer.getDescription();
        this.imageUrl = beer.getImageUrl();
        this.abv = beer.getAbv();
        this.ibu = beer.getIbu();
        this.ebc = beer.getEbc();
    }

    @Override
    public String toString() {
        return "BeerEntity [abv=" + abv + ", description=" + description + ", firstBrewed=" + firstBrewed + ", id=" + id
                + ", imageUrl=" + imageUrl + ", name=" + name + ", tagline=" + tagline + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public double getIbu() {
        return ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public double getEbc() {
        return ebc;
    }

    public void setEbc(double ebc) {
        this.ebc = ebc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

}


