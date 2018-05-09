package com.NEET.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="STUDENT")
@DiscriminatorValue("Student")
public class Student extends User{

    @Column(name="QUALIFICATION")
    @NotNull
    private String qualification;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
