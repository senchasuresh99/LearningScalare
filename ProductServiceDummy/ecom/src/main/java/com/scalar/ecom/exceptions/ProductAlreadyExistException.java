package com.scalar.ecom.exceptions;

public class ProductAlreadyExistException extends Exception{
    public ProductAlreadyExistException(String message){
        super(message);
    }
}
