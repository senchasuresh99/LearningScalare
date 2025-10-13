package com.scalar.ecom.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModal {
    @Column(unique = true, nullable = false)
    private String title;
    private Double price;
    private String description;
    private String imgUrl;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn
//    @JsonIgnore
//    @JsonBackReference
    private Category category;
}
