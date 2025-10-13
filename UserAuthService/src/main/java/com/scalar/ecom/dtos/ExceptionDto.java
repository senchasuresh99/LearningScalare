package com.scalar.ecom.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private String status;
    private String message;

    public ExceptionDto(){}

    public ExceptionDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
