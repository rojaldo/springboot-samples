package com.example.examples.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.examples.entities.BeerEntity;
import com.example.examples.reponses.BeerResponse;
import com.example.examples.repositories.BeersRepository;

@Service
public class BeersService {

    @Autowired
    private BeersRepository beersRepository;

    @Autowired
    private RestTemplate restTemplate;

    // get all beers from rest api
    public void getBeersFromApi() {
        BeerResponse[] beers = restTemplate.getForObject("https://api.punkapi.com/v2/beers", BeerResponse[].class);
        for (BeerResponse beer : beers) {
                this.beersRepository.save(new BeerEntity(beer));
        }
    }

    
    // get all beers from database
    public Iterable<BeerEntity> getBeers() {
        return this.beersRepository.findAll();
    }

    // get filtered beers by abv, ibu, ebc
    public Iterable<BeerEntity> getFilteredBeers(double abv_gt, double abv_lt, double ibu_gt, double ibu_lt, double ebc_gt, double ebc_lt) {
        return this.beersRepository.findByAbvGreaterThanAndAbvLessThanAndIbuGreaterThanAndIbuLessThanAndEbcGreaterThanAndEbcLessThan(abv_gt, abv_lt, ibu_gt, ibu_lt, ebc_gt, ebc_lt);
    }

    // get beer by id
    public BeerEntity getBeerById(long id) {
        return this.beersRepository.findById(id);
    }

    // get beer by name
    public BeerEntity getBeerByName(String name) {
        return this.beersRepository.findByName(name);
    }
    
}
