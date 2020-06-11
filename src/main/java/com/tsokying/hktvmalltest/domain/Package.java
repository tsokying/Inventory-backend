package com.tsokying.hktvmalltest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageId;

    private long product_id;
    private int packageQty;
    private double weight;
    private String dimension;
    private String Status;
    private long fromLocation;
    private long toLocation;
    private long handlingBy;
}
