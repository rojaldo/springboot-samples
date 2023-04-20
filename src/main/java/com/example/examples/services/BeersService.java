package com.example.examples.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.examples.entities.BeerEntity;
import com.example.examples.entities.BeerSalesEntity;
import com.example.examples.forms.BeerForm;
import com.example.examples.reponses.BeerResponse;
import com.example.examples.repositories.BeerSalesRepository;
import com.example.examples.repositories.BeersRepository;
import com.example.examples.requests.BeerSalesRequest;

@Service
public class BeersService {

    @Autowired
    private BeersRepository beersRepository;

    @Autowired
    private BeerSalesRepository beerSalesRepository;

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

    public BeerEntity createBeer(BeerForm beer) {
        return this.beersRepository.save(new BeerEntity(beer));
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

    // get beer sales
    public Iterable<BeerSalesEntity> getBeersSales() {
        return this.beerSalesRepository.findAll();
    }

    // get beer sales by id
    public BeerSalesEntity getBeerSaleById(long id){
        return this.beerSalesRepository.findById(id);
    }

    // create beer sale
    public BeerSalesEntity createBeerSale(BeerSalesRequest beerSale) {
        ArrayList<BeerEntity> beers = new ArrayList<BeerEntity>(); 
        for (Long beer : beerSale.beers) {
            Optional<BeerEntity> beerEntity = this.beersRepository.findById(beer);
            beers.add(beerEntity.get());
        }
        return this.beerSalesRepository.save(new BeerSalesEntity(beers, beerSale.price));
    }
    
}
