package com.example.examples.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.examples.entities.BookEntity;

public interface BooksRepository extends CrudRepository<BookEntity, Long> {
    List<BookEntity> findAll();
    BookEntity findById(long id);
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String author);
    BookEntity findByIsbn(String isbn);
}
