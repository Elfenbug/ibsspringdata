package ru.ibs.spring.springdata.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CarIncorrectId> handleException(NoSuchElementException exception) {
        CarIncorrectId id = new CarIncorrectId();
        id.setInfo(exception.getMessage());
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}
