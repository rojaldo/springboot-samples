package com.example.examples.services;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice 
public class HandleExceptionsController {

    @ExceptionHandler(Error404Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> error404Handler(Error404Exception ex) {
        return ResponseEntity.status(404).body(Map.of("message", "resource not found"));
    }

    @ExceptionHandler(Error409Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> error409Handler(Error409Exception ex) {
        return ResponseEntity.status(409).body(Map.of("message", "resource already exists"));
    }
}

