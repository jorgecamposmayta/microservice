package org.devsu.domain.exception;

public class CustomerNotFoundException extends  RuntimeException{

    public  CustomerNotFoundException(String msg){
        super(msg,null,false,false);;
    }
}
