package com.example.examples.controllers.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.examples.entities.UserEntity;
import com.example.examples.requests.UserRequest;
import com.example.examples.services.UsersService;

import com.example.examples.reponses.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1")
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserEntity>> getUsers() {
        return ResponseEntity.status(200).body(this.usersService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequest user) {
        return ResponseEntity.status(201).body(this.usersService.createUser(user));
    }

    @PutMapping("/users")
    public ResponseEntity<IUserResponse> updateUser(@RequestBody UserEntity user) {
        // check that email is unique and not null
        if (this.usersService.getUserByEmail(user.getEmail()) != null
                && this.usersService.getUserByEmail(user.getEmail()).getId() == user.getId()) {
                    
            return ResponseEntity.status(200).body(new UserResponse(this.usersService.updateUser(user)));
        }
        return ResponseEntity.status(400).body(new UserError("400","email already exists"));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable long id) {
        // check that id is valid
        if (this.usersService.getUserById(id) != null) {
            this.usersService.deleteUser(id);
            return ResponseEntity.status(200).body(Map.of("message", "user deleted"));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "user not found"));
        }
    }

}
