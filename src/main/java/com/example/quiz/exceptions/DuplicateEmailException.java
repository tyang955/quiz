package com.example.quiz.exceptions;

/**
 * Created by tianhaoyang on 11/5/23.
 */
public class DuplicateEmailException extends Exception {

    public DuplicateEmailException() {
        super();
    }

    public DuplicateEmailException(String message) {
        super(message);
    }

    public DuplicateEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEmailException(Throwable cause) {
        super(cause);
    }
}
