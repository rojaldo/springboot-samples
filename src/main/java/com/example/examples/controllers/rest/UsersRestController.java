package com.example.examples.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examples.entities.UserEntity;
import com.example.examples.requests.UserRequest;
import com.example.examples.services.UsersService;

@RestController
@RequestMapping("/api/v1")
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public Iterable<UserEntity> getUsers() {
        return this.usersService.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequest user) {
        return ResponseEntity.status(201).body(this.usersService.createUser(user));
    }

    @PutMapping("/users")
    public UserEntity updateUser(@RequestBody UserEntity user) {
        // check that email is unique and not null
        if (this.usersService.getUserByEmail(user.getEmail()) != null && this.usersService.getUserByEmail(user.getEmail()).getId() == user.getId()) {
            return this.usersService.updateUser(user);
        }
        throw new RuntimeException("user does not exist");
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        // check that id is valid
        if (this.usersService.getUserById(id) != null) {
            this.usersService.deleteUser(id);
        }
        else {
            throw new RuntimeException("user does not exist");
        }
    }


    
}
