package com.example.applicationdesigntestjava.controller;

import com.example.applicationdesigntestjava.exception.DateFromToException;
import com.example.applicationdesigntestjava.exception.RoomNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {DateFromToException.class})
    public ResponseEntity<String> dateFromToException(DateFromToException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RoomNotAvailableException.class})
    public ResponseEntity<String> roomNotAvailableException(DateFromToException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
