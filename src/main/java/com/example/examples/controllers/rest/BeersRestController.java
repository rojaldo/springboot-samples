package com.example.examples.controllers.rest;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.examples.entities.BeerEntity;
import com.example.examples.entities.BeerSalesEntity;
import com.example.examples.requests.BeerSalesRequest;
import com.example.examples.services.BeersService;

@RestController
@RequestMapping("/api/v1")
public class BeersRestController {

    @Autowired
    private BeersService beersService;

    @GetMapping("/beers")
    public ResponseEntity<Iterable<BeerEntity>> getBeers(
        @RequestParam(name="abv_gt", required = false, defaultValue = "0") double abv_gt,
        @RequestParam(name="abv_lt", required = false, defaultValue = "100") double abv_lt,
        @RequestParam(name="ibu_gt", required = false, defaultValue = "0") double ibu_gt,
        @RequestParam(name="ibu_lt", required = false, defaultValue = "1000") double ibu_lt,
        @RequestParam(name="ebc_gt", required = false, defaultValue = "0") double ebc_gt,
        @RequestParam(name="ebc_lt", required = false, defaultValue = "1000") double ebc_lt
    ) {

        // filter valid values
        if (abv_gt < 0 || abv_gt > 100 || abv_lt < 0 || abv_lt > 100) {
            return ResponseEntity.status(400).body(null);
        }

        if (ibu_gt < 0 || ibu_gt > 1000 || ibu_lt < 0 || ibu_lt > 1000) {
            return ResponseEntity.status(400).body(null);
        }

        if (ebc_gt < 0 || ebc_gt > 1000 || ebc_lt < 0 || ebc_lt > 1000) {
            return ResponseEntity.status(400).body(null);
        }
        
        return ResponseEntity.status(200).body(this.beersService.getFilteredBeers(abv_gt, abv_lt, ibu_gt, ibu_lt, ebc_gt, ebc_lt));
    }

    @GetMapping("/beers/sales")
    public ResponseEntity<Iterable<BeerSalesEntity>> getBeersSales() {
        return ResponseEntity.status(200).body(this.beersService.getBeersSales());
    }

    @PostMapping("/beers/sales")
    public ResponseEntity<BeerSalesEntity> createBeerSales(@RequestBody BeerSalesRequest beerSalesRequest) {
        BeerSalesEntity beerSalesEntity = this.beersService.createBeerSale(beerSalesRequest);
        return ResponseEntity.status(201).body(beerSalesEntity);
    }
    
}
