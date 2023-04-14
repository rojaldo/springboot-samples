package com.example.examples.repositories;


import org.springframework.data.repository.CrudRepository;

import com.example.examples.entities.BeerEntity;


public interface BeersRepository extends CrudRepository<BeerEntity, Long> {
    BeerEntity findById(long id);
    BeerEntity findByName(String beerName);
    //List<BeerEntity> findByAbvLessThan(double abv);
    //List<BeerEntity> findByAbvGreaterThanAndLessThan(double less, double greater);
}
