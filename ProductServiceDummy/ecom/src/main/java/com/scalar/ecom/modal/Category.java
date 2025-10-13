package com.scalar.ecom.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "category")
public class Category extends BaseModal {
    @Column(unique = true, nullable = false)
    private String title;

    @OneToMany(mappedBy = "category")
//    @JsonManagedReference
    @JsonIgnore
    private List<Product> products;
}
