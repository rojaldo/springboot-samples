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

    public Iterable<BookEntity> getBooksByAuthor(String author) {
        return this.booksRepository.findByAuthor(author);
    }

    public BookEntity getBookById(long id){
        return this.booksRepository.findById(id);
    }

    public BookEntity creaBook(BookRequest book) {
        // check that isbn is unique and not null
        if (this.booksRepository.findByIsbn(book.getIsbn()) != null || book == null) {
            throw new Error400IsbnException(book.getIsbn());
        }
        return this.booksRepository.save(new BookEntity(book));
    }

    public BookEntity updateBook(BookEntity book) {
        // check that isbn is unique and not null
        if (this.booksRepository.findByIsbn(book.getIsbn()) != null) {
            return this.booksRepository.save(book);
        }
        throw new Error409Exception(book.getIsbn());
    }

    public BookEntity deleteBook(long id) {
        BookEntity book = this.booksRepository.findById(id);
        if (book != null) {
            this.booksRepository.delete(book);
            return book;
        }
        throw new Error404Exception(id);
    }

}

class Error404Exception extends RuntimeException {
    public Error404Exception(long id) {
        super("Book not found with id: " + id);
    }

    public Error404Exception(String email) {
        super("Book not found with email: " + email);
    }
}

class Error400EmailException extends RuntimeException {
    public Error400EmailException(String email) {
        super("Book not found with email: " + email);
    }
}

class Error400NameException extends RuntimeException {
    public Error400NameException(String name) {
        super("Book not found with name: " + name);
    }
}

class Error409Exception extends RuntimeException {
    public Error409Exception(String isbn) {
        super("Book already exists with isbn: " + isbn);
    }
}

class Error400IsbnException extends RuntimeException {
    public Error400IsbnException(String isbn) {
        super("Book already exists with isbn: " + isbn);
    }
}

