package com.microservice.SAPCommentService.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.SAPCommentService.exceptions.ErrorResponse;

@RestControllerAdvice
public class ExceptionalHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
          ErrorResponse response = new ErrorResponse(
               HttpStatus.NOT_FOUND.value(),
               HttpStatus.NOT_FOUND.getReasonPhrase(),
               ex.getMessage());

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);   
    }
}
