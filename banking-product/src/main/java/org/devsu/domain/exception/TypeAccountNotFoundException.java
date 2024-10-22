package org.devsu.domain.exception;

public class TypeAccountNotFoundException extends RuntimeException{
    public  TypeAccountNotFoundException(String msg){
        super(msg,null,true,false);
    }
}
