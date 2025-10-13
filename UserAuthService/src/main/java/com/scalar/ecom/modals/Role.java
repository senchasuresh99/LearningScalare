package com.scalar.ecom.modals;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role extends BaseModal{
    private String name;

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

    //if need we can add the list of permissions
}
