package org.devsu.infrastructure.adapter.in;

import org.devsu.domain.exception.AccountNotFoundException;
import org.devsu.domain.exception.MovementNotFoundException;
import org.devsu.domain.exception.TypeAccountNotFoundException;
import org.devsu.domain.exception.TypeMovementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TypeAccountNotFoundException.class)
    public ResponseEntity<String> manageTypeAccountNotFound(TypeAccountNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TypeMovementNotFoundException.class)
    public ResponseEntity<String> manageTypeMovementNotFound(TypeMovementNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> manageAccountNotFound(AccountNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovementNotFoundException.class)
    public ResponseEntity<String> manageMovementNotFound(MovementNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
