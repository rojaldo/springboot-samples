package com.example.examples.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examples.entities.BeerEntity;
import com.example.examples.services.BeersService;

@RestController
@RequestMapping("/api/v1")
public class BeersRestController {

    @Autowired
    private BeersService beersService;

    @GetMapping("/beers")
    public ResponseEntity<Iterable<BeerEntity>> getBeers() {
        return ResponseEntity.status(200).body(this.beersService.getBeersFromApi());
    }
    
}
