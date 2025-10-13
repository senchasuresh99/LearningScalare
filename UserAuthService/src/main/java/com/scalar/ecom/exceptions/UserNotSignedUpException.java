package com.scalar.ecom.exceptions;

public class UserNotSignedUpException extends Exception{
    public UserNotSignedUpException(String message){
        super(message);
    }
}
