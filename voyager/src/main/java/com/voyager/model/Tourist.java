package com.voyager.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jboss.logging.annotations.Message;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
@Entity
@Table(name = "TOURIST_TBL")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tourist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    @Size(min = 4, max = 20)
    private String firstName;

    @Column
    @NotNull
    @Size(min = 4, max = 20)
    private String lastName;

    @Column
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn(name="passport_id")
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourist", fetch = FetchType.EAGER,targetEntity = Address.class)
    private List<Address> addressList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST},targetEntity = Tour.class)
    @JoinTable(name="Tourist_Visits", joinColumns={@JoinColumn(name="tourist_id",nullable = false,updatable = false)}, inverseJoinColumns = {@JoinColumn(name="tour_id",nullable = false,updatable = false)},
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Tour> tours;



    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setPassport(Passport passport){ this.passport = passport; }
    public Passport getPassport() { return passport; }
    public void setAddressList(List<Address> addressList) { this.addressList = addressList; }
    public void setTours(List<Tour> tours) { this.tours = tours; }
    public List<Address> getAddressList() { return addressList; }
    public LocalDate getDob() { return dob; }
    public List<Tour> getTours() { return tours; }
}
