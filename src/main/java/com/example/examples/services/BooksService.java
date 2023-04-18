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
            throw new ErrorBooks400IsbnException(book.getIsbn());
        }
        return this.booksRepository.save(new BookEntity(book));
    }

    public BookEntity updateBook(BookEntity book) {
        // check that isbn is unique and not null
        if (this.booksRepository.findByIsbn(book.getIsbn()) != null) {
            return this.booksRepository.save(book);
        }
        throw new ErrorBooks409Exception(book.getIsbn());
    }

    public BookEntity deleteBook(long id) {
        BookEntity book = this.booksRepository.findById(id);
        if (book != null) {
            this.booksRepository.delete(book);
            return book;
        }
        throw new ErrorBooks404Exception(id);
    }

}

class ErrorBooks404Exception extends RuntimeException {
    public ErrorBooks404Exception(long id) {
        super("Book not found with id: " + id);
    }

    public ErrorBooks404Exception(String email) {
        super("Book not found with email: " + email);
    }
}

class ErrorBooks400EmailException extends RuntimeException {
    public ErrorBooks400EmailException(String email) {
        super("Book not found with email: " + email);
    }
}

class ErrorBooks400NameException extends RuntimeException {
    public ErrorBooks400NameException(String name) {
        super("Book not found with name: " + name);
    }
}

class ErrorBooks409Exception extends RuntimeException {
    public ErrorBooks409Exception(String isbn) {
        super("Book already exists with isbn: " + isbn);
    }
}

class ErrorBooks400IsbnException extends RuntimeException {
    public ErrorBooks400IsbnException(String isbn) {
        super("Book already exists with isbn: " + isbn);
    }
}

