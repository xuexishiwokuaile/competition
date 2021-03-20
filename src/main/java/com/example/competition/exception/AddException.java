package com.example.competition.exception;

public class AddException extends Exception {
    public AddException(String message) {
        super(message);
    }

    public AddException(String message, Throwable cause) {
        super(message, cause);
    }
}
