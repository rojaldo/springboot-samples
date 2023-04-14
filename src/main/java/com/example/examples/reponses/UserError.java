package com.example.examples.reponses;

public class UserError implements IUserResponse{
    public String code;
    public String message;

    public UserError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
