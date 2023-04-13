package com.example.examples.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.examples.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
    UserEntity findById(long id);
    List<UserEntity> findByName(String name);
}
