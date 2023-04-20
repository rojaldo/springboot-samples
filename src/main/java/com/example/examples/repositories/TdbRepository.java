package com.example.examples.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.examples.entities.CardEntity;

public interface TdbRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findAll();
}

