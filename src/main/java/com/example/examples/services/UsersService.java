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
        UserEntity user = this.usersRepository.findById(id);
        if (user != null) {
            return user;
        }
        throw new Error404Exception(id);
    }

    public UserEntity getUserByEmail(String email) {
        UserEntity user = this.usersRepository.findByEmail(email);
        if (user != null) {
            return user;
        }
        throw new Error400EmailException(email);
    }

    public Iterable<UserEntity> getUserByName(String name) {
        // get all users with name
        Iterable<UserEntity> users = this.usersRepository.findByName(name);
        if (users != null) {
            return users;
        }
        throw new Error400NameException(name);
    }

    public UserEntity createUser(UserRequest user) {
        // check that email is unique and not null
        if (this.usersRepository.findByEmail(user.getEmail()) != null) {
            throw new Error409Exception("Email already exists");
        }
        return this.usersRepository.save(new UserEntity(user.getName(), user.getEmail()));
    }

    public UserEntity updateUser(UserEntity user) {
        // check that email is unique and not null
        if (this.usersRepository.findByEmail(user.getEmail()) == null) {
            throw new Error404Exception(user.getId());
        } else if (this.usersRepository.findByEmail(user.getEmail()).getId() != user.getId()) {
            throw new Error409Exception(user.getEmail(), user.getId());
        }
        return this.usersRepository.save(user);
    }

    public void deleteUser(long id) {
        UserEntity user = this.usersRepository.findById(id);
        if (user != null) {
            this.usersRepository.delete(user);
        } else {
            throw new Error404Exception(id);
        }
    }

}

class Error404Exception extends RuntimeException {
    public Error404Exception(long id) {
        super("User not found with id: " + id);
    }

    public Error404Exception(String email) {
        super("User not found with email: " + email);
    }
}

class Error400EmailException extends RuntimeException {
    public Error400EmailException(String email) {
        super("User not found with email: " + email);
    }
}

class Error400NameException extends RuntimeException {
    public Error400NameException(String name) {
        super("User not found with name: " + name);
    }
}

class Error409Exception extends RuntimeException {
    public Error409Exception(String email) {
        super("User already exists with email: " + email);
    }

    public Error409Exception(String email, long id) {
        super("User already exists with a different id: " + email + ": " + id);
    }
}
