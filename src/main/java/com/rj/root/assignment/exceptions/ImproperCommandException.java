package com.rj.root.assignment.exceptions;

public class ImproperCommandException extends RuntimeException {
    public ImproperCommandException(String command) {
        super(command);
    }
}
