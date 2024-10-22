package org.devsu.domain.exception;

public class AccountNotFoundException extends RuntimeException {
    public  AccountNotFoundException(String msg){
        super(msg,null,false,false);
    }
}
