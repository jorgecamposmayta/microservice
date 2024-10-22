package org.devsu.domain.exception;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(String msg){
        super(msg,null,false,false);
    }
}
