package com.example.geriafarm.exeptions;

public class AlreadyInTheDBException extends RuntimeException{
    public AlreadyInTheDBException (String message){
        super(message);
    }
}
