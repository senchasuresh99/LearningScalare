package com.scalar.ecom.dtos;

import com.scalar.ecom.modals.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private List<Role> roles = new ArrayList<>();
}
