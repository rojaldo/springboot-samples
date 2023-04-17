package com.example.examples.entities;

import com.example.examples.requests.LendRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lends")
public class LendEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    String lendDate;
    String returnDate;

    Byte status;

    public LendEntity() {
    }

    public LendEntity(BookEntity book, UserEntity user, LendRequest lendRequest) {
        this.book = book;
        this.user = user;
        this.lendDate = lendRequest.lendDate;
        this.returnDate = lendRequest.returnDate;
        this.status = 0;
    }

    @Override
    public String toString() {
        return "LendEntity [book=" + book + ", id=" + id + ", lendDate=" + lendDate + ", returnDate=" + returnDate
                + ", status=" + status + ", user=" + user + "]";
    }

    
}
