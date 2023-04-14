package com.example.examples.repositories;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.examples.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
    UserEntity findById(long id);
    List<UserEntity> findByName(String name);
}
