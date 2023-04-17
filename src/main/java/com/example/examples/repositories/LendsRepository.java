package com.example.examples.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examples.entities.LendEntity;
import com.example.examples.entities.UserEntity;

public interface LendsRepository extends JpaRepository<LendEntity, Long> {
    List<LendEntity> findAll();
}
