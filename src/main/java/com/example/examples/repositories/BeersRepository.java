package com.example.examples.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.examples.entities.BeerEntity;


public interface BeersRepository extends JpaRepository<BeerEntity, Long> {
    BeerEntity findById(long id);
    BeerEntity findByName(String beerName);
    List<BeerEntity> findByAbvLessThan(double abv);
    List<BeerEntity> findByAbvGreaterThan(double abv);
    List<BeerEntity> findByAbvGreaterThanAndAbvLessThan(double less, double greater);
    List<BeerEntity> findByIbuLessThan(double ibu);
    List<BeerEntity> findByIbuGreaterThan(double ibu);
    List<BeerEntity> findByIbuGreaterThanAndIbuLessThan(double less, double greater);
    List<BeerEntity> findByEbcLessThan(double ebc);
    List<BeerEntity> findByEbcGreaterThan(double ebc);
    List<BeerEntity> findByEbcGreaterThanAndEbcLessThan(double less, double greater);
    List<BeerEntity> findByAbvGreaterThanAndAbvLessThanAndIbuGreaterThanAndIbuLessThanAndEbcGreaterThanAndEbcLessThan(double abvLess, double abvGreater, double ibuLess, double ibuGreater, double ebcLess, double ebcGreater);
    // @Query("SELECT b FROM beers b WHERE b.abv > :abvLess AND b.abv < :abvGreater AND b.ibu > :ibuLess AND b.ibu < :ibuGreater AND b.ebc > :ebcLess AND b.ebc < :ebcGreater")
    // List<BeerEntity> findByParameters(@Param("abvLess") double abvLess, @Param("abvGreater") double abvGreater, @Param("ibuLess") double ibuLess, @Param("ibuGreater") double ibuGreater, @Param("ebcLess") double ebcLess, @Param("ebcGreater") double ebcGreater);
}
