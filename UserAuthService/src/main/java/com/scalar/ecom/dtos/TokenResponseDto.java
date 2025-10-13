package com.scalar.ecom.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDto {
    private String email;
    private String tokenValue;
}
