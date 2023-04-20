package com.example.examples.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examples.dtos.CardDto;
import com.example.examples.entities.CardEntity;
import com.example.examples.services.TdbService;

@RestController
public class TdbRestController {

    @Autowired
    private TdbService tdbService;

    @GetMapping("/tdb/questions")
    public ResponseEntity<Iterable<CardDto>> getQuestions() {
        return ResponseEntity.status(200).body(this.tdbService.getQuestions());
    }
    
}
