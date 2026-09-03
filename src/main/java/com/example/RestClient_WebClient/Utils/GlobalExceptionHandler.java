package com.example.RestClient_WebClient.Utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> globalExceptionHandler(Exception ex){
        return ResponseEntity.status(500)
        .body(
            new ApiResponse(false, ex.getMessage(), null)
        );
    }
}
