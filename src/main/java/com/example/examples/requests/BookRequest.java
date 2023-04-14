package com.example.examples.requests;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

public class BookRequest {

    private String title;
    private String author;
    private String isbn;
    private String description;

    @Min(value = 1, message = "Pages must be greater than 0")
    private int pages;

    public BookRequest() {
    }

    public BookRequest(String title, String author, String isbn, String description, int pages) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setDescription(description);
        this.setPages(pages);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank() || title.isEmpty() || title.trim().isEmpty() || title.length() < 2 || title.length() > 50) {
            System.out.println("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank() || author.isEmpty() || author.trim().isEmpty() || author.length() < 2 || author.length() > 50) {
            System.out.println("Author cannot be null or empty");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank() || isbn.isEmpty() || isbn.trim().isEmpty() || isbn.length() < 2 || isbn.length() > 50) {
            System.out.println("ISBN cannot be null or empty");
        }
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank() || description.isEmpty() || description.trim().isEmpty() || description.length() < 2 || description.length() > 50) {
            System.out.println("Description cannot be null or empty");
        }
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages < 1) {
            System.out.println("Pages cannot be less than 1");
        }
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "BookRequest [author=" + author + ", description=" + description + ", isbn=" + isbn + ", pages=" + pages
                + ", title=" + title + "]";
    }
    
}
