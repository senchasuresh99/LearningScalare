package com.scalar.ecom.modalInheitanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private Integer numberOfHelpReq;

    public Integer getNumberOfHelpReq() {
        return numberOfHelpReq;
    }

    public void setNumberOfHelpReq(Integer numberOfHelpReq) {
        this.numberOfHelpReq = numberOfHelpReq;
    }
}
