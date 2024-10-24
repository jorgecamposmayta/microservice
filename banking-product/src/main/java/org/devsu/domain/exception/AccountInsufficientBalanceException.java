package org.devsu.domain.exception;

public class AccountInsufficientBalanceException extends RuntimeException {
    public AccountInsufficientBalanceException(String msg){
        super(msg,null,false,false);
    }
}
