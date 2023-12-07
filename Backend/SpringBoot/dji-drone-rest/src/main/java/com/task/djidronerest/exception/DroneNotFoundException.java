package com.task.djidronerest.exception;

public class DroneNotFoundException extends RuntimeException {
    public DroneNotFoundException(String message) {
        super(message);
    }

    public DroneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
