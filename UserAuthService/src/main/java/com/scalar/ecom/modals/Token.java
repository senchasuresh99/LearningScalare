package com.scalar.ecom.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Token extends BaseModal{
    private String value;
    private Date expiresAt;

    @ManyToOne
    private User user;
}
/*
      1       1
    Token == User  ==> M : 1
      M       1
 */