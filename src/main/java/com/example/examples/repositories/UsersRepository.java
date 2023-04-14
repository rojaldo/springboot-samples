package com.example.examples.repositories;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.examples.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findByEmail(String email);
    UserEntity findByEmailAndName(String email, String name);
    UserEntity findById(long id);
    List<UserEntity> findByName(String name);
}
