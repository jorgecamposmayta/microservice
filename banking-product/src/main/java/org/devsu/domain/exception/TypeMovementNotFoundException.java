package org.devsu.domain.exception;

public class TypeMovementNotFoundException extends RuntimeException{
    public TypeMovementNotFoundException(String msg){
        super(msg,null,true,false);
    }
}
