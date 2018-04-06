package com.voyager.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TOUR_TBL")
public class Tour implements Serializable{
    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String placeName;

    @Column
    @NotNull
    private String packageType;

    @Column
    @NotNull
    private String packageName;

    @Column
    @NotNull
    private int price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST},targetEntity = Tourist.class)
    @JoinTable(name="Tourist_Visits", joinColumns={@JoinColumn(name="tour_id",nullable = false,updatable = false)}, inverseJoinColumns = {@JoinColumn(name="tourist_id",nullable = false,updatable = false)},
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Tourist> touristSet;

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPackageName() { return packageName; }

    public String getPackageType() {
        return packageType;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Tourist> getTouristSet() { return touristSet; }

    public void setTouristSet(List<Tourist> touristSet) { this.touristSet = touristSet; }
}
