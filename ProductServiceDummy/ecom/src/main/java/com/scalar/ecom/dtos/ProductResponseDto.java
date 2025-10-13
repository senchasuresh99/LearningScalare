package com.scalar.ecom.dtos;

public class ProductResponseDto<T> {
    private String statusCode;
    private T data;

    // Constructors
    public ProductResponseDto() {}

    public ProductResponseDto(String statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    // Getters and Setters
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
