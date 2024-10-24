package org.devsu.domain.exception;

public class SqlException extends RuntimeException{

    public SqlException(String msg){
        super(msg,null,false,false);;
    }
}
