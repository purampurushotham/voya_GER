package com.voyager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
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

    @ManyToMany(mappedBy = "tours")
    private Set<Tourist> touristSet;

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

    public String getPackageName() {
        return packageName;
    }

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

    public Set<Tourist> getTouristSet() { return touristSet; }

    public void setTouristSet(Set<Tourist> touristSet) { this.touristSet = touristSet; }
}
