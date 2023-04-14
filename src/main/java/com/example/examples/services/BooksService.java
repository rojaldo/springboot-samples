package com.example.examples.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examples.entities.BookEntity;
import com.example.examples.repositories.BooksRepository;
import com.example.examples.requests.BookRequest;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public Iterable<BookEntity> getBooks() {
        return this.booksRepository.findAll();
    }

    public BookEntity creaBook(BookRequest book) {
        // check that isbn is unique and not null
        if (this.booksRepository.findByIsbn(book.getIsbn()) != null || book == null) {
            throw new RuntimeException("ISBN already exists");
        }
        return this.booksRepository.save(new BookEntity(book));
    }

    public BookEntity updateBook(BookEntity book) {
        // check that isbn is unique and not null
        if (this.booksRepository.findByIsbn(book.getIsbn()) != null) {
            return this.booksRepository.save(book);
        }
        throw new RuntimeException("book does not exist");
    }

    public BookEntity deleteBook(long id) {
        BookEntity book = this.booksRepository.findById(id);
        if (book != null) {
            this.booksRepository.delete(book);
            return book;
        }
        throw new RuntimeException("book does not exist");
    }

}
