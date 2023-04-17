package com.example.examples.reponses;

import com.example.examples.entities.BookEntity;
import com.example.examples.entities.UserEntity;
import com.example.examples.requests.LendRequest;


public class LendResponse {
    
    private long id;

    private BookEntity book;

    private UserEntity user;

    private String lendDate;
    private String returnDate;

    Byte status;

    public LendResponse() {
    }

    public LendResponse(BookEntity book, UserEntity user, LendRequest lendRequest) {
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
