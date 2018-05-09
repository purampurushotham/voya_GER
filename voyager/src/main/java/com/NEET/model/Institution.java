package com.NEET.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="INSTITUTION_TBL")
public class Institution {
    @Id
    @Column(name = "institution_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull
    private String institutionName;

    @Column
    @NotNull
    private String address;

}
