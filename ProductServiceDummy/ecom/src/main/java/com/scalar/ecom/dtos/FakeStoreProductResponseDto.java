package com.scalar.ecom.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    private String message;
    private String status;
    private FakeStoreProductDto product;
}
