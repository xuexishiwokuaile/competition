package com.example.competition.exception;

public class UpdateException extends Exception {
    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
