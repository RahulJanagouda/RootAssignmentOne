package com.rj.root.assignment.exceptions;

public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException(String command) {
        super(command);
    }
}
