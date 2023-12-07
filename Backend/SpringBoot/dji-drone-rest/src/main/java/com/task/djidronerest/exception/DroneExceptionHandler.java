package com.task.djidronerest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DroneExceptionHandler {

    @ExceptionHandler(value = {DroneNotFoundException.class})
    public ResponseEntity<Object> handleDroneNotFoundException(DroneNotFoundException ex) {
        DroneException droneException = new DroneException(
                ex.getMessage()
                , ex.getCause()
                , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(droneException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DroneBatteryLowException.class})
    public ResponseEntity<Object> handleDroneBatteryLowException(DroneBatteryLowException ex) {
        DroneException droneException = new DroneException(
                ex.getMessage()
                , ex.getCause()
                , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(droneException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DroneOverLoadException.class})
    public ResponseEntity<Object> handleDroneOverLoadException(DroneOverLoadException ex) {
        DroneException droneException = new DroneException(
                ex.getMessage()
                , ex.getCause()
                , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(droneException, HttpStatus.BAD_REQUEST);
    }
}
