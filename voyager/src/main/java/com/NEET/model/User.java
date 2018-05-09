package com.NEET.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="USER_TBL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("User")
public class User implements Serializable{
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="FIRST_NAME")
    @NotNull
    private String firstName;

    @Column(name="LAST_NAME")
    @NotNull
    private String lastName;

    @Column(name="MIDDLE_NAME")
    @NotNull
    private String middleName;

    @Column(name="GENDER")
    @NotNull
    private String gender;

    @Column(name="ADDRESS_ONE")
    @NotNull
    private String addressOne;

    @Column(name="ADDRESS_TWO")
    @NotNull
    private String addressTwo;

    @Column(name="CITY")
    @NotNull
    private String city;

    @Column(name="STATE")
    @NotNull
    private String state;

    @Column(name="EMAIL")
    @NotNull
    private String email;

    @Column(name="STATUS")
    @NotNull
    private String status;

    @Column(name="PHONENO")
    @NotNull
    private String phoneNo;

    @Column(name="ZIPCODE")
    @NotNull
    private Integer zipcode;

    @Column(name="LANDLINE_NO")
    @NotNull
    private String landlineNo;

    @Column(name="PANNO")
    @NotNull
    private String panNo;

    @Column(name="AADHARNO")
    @NotNull
    private String aadharNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLandlineNo() {
        return landlineNo;
    }

    public void setLandlineNo(String landlineNo) {
        this.landlineNo = landlineNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }
}

