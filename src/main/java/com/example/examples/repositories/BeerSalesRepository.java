package com.example.examples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examples.entities.BeerSalesEntity;

public interface BeerSalesRepository extends JpaRepository<BeerSalesEntity, Long> {
    BeerSalesEntity findById(long id);
}
