package com.NEET.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("Franchise")
@Table(name="FRANCHISE_TBL")
public class Franchise extends User {

    @Column(name="FRANCHISE_REGNO")
    @NotNull
    private String franchiseREGNO;

    @Column(name="isActive")
    @NotNull
    private Boolean isActive;

    public String getFranchiseREGNO() {
        return franchiseREGNO;
    }

    public void setFranchiseREGNO(String franchiseREGNO) {
        this.franchiseREGNO = franchiseREGNO;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}

