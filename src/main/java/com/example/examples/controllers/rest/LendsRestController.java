package com.example.examples.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examples.entities.LendEntity;
import com.example.examples.requests.LendRequest;
import com.example.examples.services.LendsService;

@RestController
@RequestMapping("/api/v1")
public class LendsRestController {

    @Autowired
    private LendsService lendsService;

    @GetMapping("/lends")
    public ResponseEntity<Iterable<LendEntity>> getLends() {
        System.out.println(this.lendsService.getLends());
        return ResponseEntity.status(200).body(this.lendsService.getLends());
    }

    @PostMapping("/lends")
    public ResponseEntity<LendEntity> createLend(@RequestBody LendRequest lend ) {
        LendEntity lendEntity = this.lendsService.createLend(lend);
        System.out.println(lendEntity);
        return ResponseEntity.status(201).body(lendEntity);
    }

}

