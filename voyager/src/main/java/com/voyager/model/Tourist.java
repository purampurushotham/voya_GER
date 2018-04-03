package com.voyager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TOURIST_TBL")
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
    @Temporal(TemporalType.DATE)
    private Date dob;

    @OneToOne
    @JoinColumn(name="passport_id")
    private Passport passport_id;

    @OneToMany(mappedBy = "tourist")
    private Set<Address> addressesSet;

    @ManyToMany
    @JoinTable(name="Tourist_Visits", joinColumns={@JoinColumn(name="tourist_id")}, inverseJoinColumns = {@JoinColumn(name="tour_id")})
    private Set<Tour> tours;



    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDob(Date dob) {
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
    public Date getDob() {
        return dob;
    }
    public void setPassport_id(Passport passport_id){ this.passport_id = passport_id; }
    public Passport getPassport_id() { return passport_id; }
    public Set<Address> getAddressList() { return addressesSet; }
    public void setAddressesSet(Set<Address> addressesSet) { this.addressesSet = addressesSet; }
    public void setTours(Set<Tour> tours) { this.tours = tours; }
    public Set<Address> getAddressesSet() { return addressesSet; }
    /*
    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }*/

}
