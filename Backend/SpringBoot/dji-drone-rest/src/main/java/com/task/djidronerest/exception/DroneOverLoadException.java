package com.task.djidronerest.exception;

public class DroneOverLoadException extends RuntimeException {
    public DroneOverLoadException(String message) {
        super(message);
    }

    public DroneOverLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
