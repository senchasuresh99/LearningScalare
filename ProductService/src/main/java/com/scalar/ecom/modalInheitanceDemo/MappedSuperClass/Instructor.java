package com.scalar.ecom.modalInheitanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "ms_instructor")
public class Instructor extends User{
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
