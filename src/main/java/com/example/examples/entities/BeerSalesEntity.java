package com.example.examples.entities;

import java.util.List;

import com.example.examples.requests.BeerSalesRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "beer_sales")
@Getter
public class BeerSalesEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JoinTable(name = "beer_sales_beers",
        joinColumns = @JoinColumn(name = "beer_sales_id"),
        inverseJoinColumns = @JoinColumn(name = "beer_id"))
    private List<BeerEntity> beers;

    double price;

    public BeerSalesEntity() {
    }

    public BeerSalesEntity(List<BeerEntity> beerSalesRequest, double price) {
        this.beers = beerSalesRequest;
        this.price = price;
    }

    public BeerSalesEntity(BeerSalesEntity beerSalesRequest) {
        this.beers = beerSalesRequest.beers;
        this.price = beerSalesRequest.price;
    }
    

}
