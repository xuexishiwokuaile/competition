package com.example.competition.exception;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class AddException extends Exception {
    public AddException(String message) {
        super(message);
    }

    public AddException(String message, Throwable cause) {
        super(message, cause);
    }
}
