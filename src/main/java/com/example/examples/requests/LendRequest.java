package com.example.examples.requests;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LendRequest {

    @JsonProperty("book_id")
    public long bookID;

    @JsonProperty("user_id")
    public long userID;

    @JsonProperty("lend_date")
    public String lendDate;
    @JsonProperty("return_date")
    public String returnDate;

}
