package com.example.webapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex) {
//        log.warn("Bad request: {}", ex.getMessage());
//        return ResponseEntity.badRequest().body(error(400, ex.getMessage()));
//    }
//
//
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<Map<String, Object>> handleNotFound(NoSuchElementException ex) {
//        log.warn("Not found: {}", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error(404, ex.getMessage()));
//    }

    // 500 - catch all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        log.error("Unexpected error", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error(500, "An unexpected error occurred"));
    }

    private Map<String, Object> error(int status, String message) {
        return Map.of(
                "status", status,
                "message", message,
                "timestamp", LocalDateTime.now().toString()
        );
    }
}