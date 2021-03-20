package com.example.competition.exception;

/**
 * @author Chen Anran
 * @date 2021/3/20
 */
public class DeleteException extends Exception {
    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
