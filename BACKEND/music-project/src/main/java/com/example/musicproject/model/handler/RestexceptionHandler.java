package com.example.musicproject.model.handler;

import com.example.musicproject.model.error.ErrorMessage;
import com.example.musicproject.model.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestexceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){

        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
