package com.example.examples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examples.entities.UserEntity;
import com.example.examples.repositories.UsersRepository;
import com.example.examples.requests.UserRequest;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Iterable<UserEntity> getUsers() {
        return this.usersRepository.findAll();
    }

    public UserEntity getUserById(long id) {
        return this.usersRepository.findById(id);
    }

    public UserEntity getUserByEmail(String email) {
        return this.usersRepository.findByEmail(email);
    }

    public Iterable<UserEntity> getUserByName(String name) {
        return this.usersRepository.findByName(name);
    }

    public UserEntity createUser(UserRequest user) {
        // check that email is unique and not null
        if (this.usersRepository.findByEmail(user.getEmail()) != null || user == null) {
            throw new RuntimeException("Email already exists");
        }
        return this.usersRepository.save(new UserEntity(user.getName(), user.getEmail()));
    }

    public UserEntity updateUser(UserEntity user) {
        // check that email is unique and not null
        if (this.usersRepository.findByEmail(user.getEmail()) != null) {
            return this.usersRepository.save(user);
        }
        throw new RuntimeException("user does not exist");
    }

    public void deleteUser(long id) {
        UserEntity user = this.usersRepository.findById(id);
        if (user != null) {
            this.usersRepository.delete(user);
        } else {
            throw new RuntimeException("user does not exist");
        }
    }

}
