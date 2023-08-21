package com.example.CelluloidInsight.ExceptionHandling;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalTime;
import java.util.List;

public class ApiError {

    private final HttpStatus status;
    private final List<String> message;
    private final LocalTime timestamp;

    public ApiError(HttpStatus status, List<String> message, LocalTime timestamp) {
        this.status= status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public List<String> getMessage() {
        return this.message;
    }

    public LocalTime getTimestamp() {
        return this.timestamp;
    }
}
