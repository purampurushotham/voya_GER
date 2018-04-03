package com.voyager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PASSPORT_TBL")
public class Passport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long p_id;

    @Column
    @NotNull
    private String Type;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date expiredDate;

    /*@OneToOne
    @PrimaryKeyJoinColumn
    private Tourist tourist_ID;*/

    @Column
    @NotNull
    private String issuedBy;

    public void setP_id(Long p_id) { this.p_id = p_id; }
    public void setExpiredDate(Date expiredDate) { this.expiredDate = expiredDate; }
    public void setType(String type) { Type = type; }
    public void setIssuedBy(String issuedBy) { this.issuedBy = issuedBy; }
    public Long getP_id() { return p_id; }
    public Date getExpiredDate() { return expiredDate; }
    public String getIssuedBy() { return issuedBy; }
    public String getType() { return Type; }
}
