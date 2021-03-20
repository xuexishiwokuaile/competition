package com.example.competition.exception;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
