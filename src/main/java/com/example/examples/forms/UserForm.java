package com.example.examples.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserForm {

    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @Email(message = "Email must be valid")
    private String email;

    public UserForm() {
    }

    public UserForm(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty() || name.trim().isEmpty() || name.length() < 2 || name.length() > 50) {
           System.out.println("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (email == null || email.isBlank() || email.isEmpty() || email.trim().isEmpty() || email.length() < 5 || email.length() > 50) {
            System.out.println("Email cannot be null or empty");
        }
        this.email = email;
    }
    
}
