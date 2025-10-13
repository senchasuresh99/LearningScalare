package com.scalar.ecom.modalInheitanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "ms_mentor")
public class Mentor extends User{
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
