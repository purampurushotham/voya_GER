package com.voyager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "ADDRESS_TBL")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

  /*  @ManyToOne
    @JoinColumn(name="tourist_id",nullable=false)
    private Tourist tourist;*/

    @Column
    @NotNull
    @Size(max=30)
    private String city;

    @Column
    @NotNull
    @Size(max=30)
    private String street;

    @Column
    @NotNull
    @Size(max=30)
    private String state;

    @Column
    @NotNull
    @Size(max=5)
    private int zipcode;

    @ManyToOne
    @JoinColumn(name="tourist_id")
    private Tourist tourist;

    public int getId() { return id; }
    public int getZipcode() { return zipcode; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getStreet() { return street; }
    public void setId(int id) { this.id = id; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setStreet(String street) { this.street = street; }
    public void setZipcode(int zipcode) { this.zipcode = zipcode; }
    public Tourist getTourist() { return tourist; }
    public void setTourist(Tourist tourist) { this.tourist = tourist; }
}
