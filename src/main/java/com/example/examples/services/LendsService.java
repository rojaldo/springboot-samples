package com.example.examples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examples.entities.BookEntity;
import com.example.examples.entities.LendEntity;
import com.example.examples.entities.UserEntity;
import com.example.examples.repositories.BooksRepository;
import com.example.examples.repositories.LendsRepository;
import com.example.examples.repositories.UsersRepository;
import com.example.examples.requests.LendRequest;

@Service
public class LendsService {

    @Autowired
    private LendsRepository lendsRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private BooksService booksService;



    public Iterable<LendEntity> getLends() {
        return this.lendsRepository.findAll();
    }

    public LendEntity createLend(LendRequest lend) {
        // find user and book
        UserEntity user = this.usersService.getUserById(lend.userID);

        BookEntity book = this.booksService.getBookById(lend.bookID);

        return this.lendsRepository.save(new LendEntity(book, user, lend));
    }
}