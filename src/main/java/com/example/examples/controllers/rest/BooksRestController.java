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

import com.example.examples.entities.BookEntity;
import com.example.examples.requests.BookRequest;
import com.example.examples.services.BooksService;

@RestController
@RequestMapping("/api/v1")
public class BooksRestController {
    
    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<Iterable<BookEntity>> getBooks() {
        return ResponseEntity.status(200).body(this.booksService.getBooks());
    }

    @PostMapping("/books")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookRequest book) {
        return ResponseEntity.status(201).body(this.booksService.creaBook(book));
    }

    @PutMapping("/books")
    public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity book) {
        return ResponseEntity.status(200).body(this.booksService.updateBook(book));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookEntity> deleteBook(@PathVariable long id) {
        return ResponseEntity.status(200).body(this.booksService.deleteBook(id));
    }
}
