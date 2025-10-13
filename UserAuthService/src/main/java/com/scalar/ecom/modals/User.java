package com.scalar.ecom.modals;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModal{
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Role> roles;
}
