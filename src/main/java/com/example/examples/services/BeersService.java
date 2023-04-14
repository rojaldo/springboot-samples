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
    public Iterable<BeerEntity> getBeersFromApi() {
        List<BeerEntity> result = new ArrayList<BeerEntity>();
        BeerResponse[] beers = restTemplate.getForObject("https://api.punkapi.com/v2/beers", BeerResponse[].class);
        for (BeerResponse beer : beers) {
                this.beersRepository.save(new BeerEntity(beer));
                result.add(new BeerEntity(beer));
        }
        return result;
    }
    
}
