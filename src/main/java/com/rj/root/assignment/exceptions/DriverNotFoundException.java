package com.rj.root.assignment.exceptions;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(String command) {
        super(command);
    }
}
