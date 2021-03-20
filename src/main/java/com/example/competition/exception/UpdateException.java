package com.example.competition.exception;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class UpdateException extends Exception {
    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
