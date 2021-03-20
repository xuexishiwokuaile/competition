package com.example.competition.exception;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class SelectException extends Exception {
    public SelectException(String message) {
        super(message);
    }

    public SelectException(String message, Throwable cause) {
        super(message, cause);
    }
}
