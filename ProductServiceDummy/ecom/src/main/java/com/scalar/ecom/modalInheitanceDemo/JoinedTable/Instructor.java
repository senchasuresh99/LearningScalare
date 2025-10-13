package com.scalar.ecom.modalInheitanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    private String subject;
    private Double rating;

    public String getSubject() {
        return subject;
    }

    public Double getRating() {
        return rating;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
