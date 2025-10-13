package com.scalar.ecom.modalInheitanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "ms_ta")
public class TA extends User{
    private Integer numberOfHelpReq;

    public Integer getNumberOfHelpReq() {
        return numberOfHelpReq;
    }

    public void setNumberOfHelpReq(Integer numberOfHelpReq) {
        this.numberOfHelpReq = numberOfHelpReq;
    }
}
