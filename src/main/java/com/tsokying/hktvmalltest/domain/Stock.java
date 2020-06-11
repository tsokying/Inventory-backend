package com.tsokying.hktvmalltest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stockId;

    @Column(name="prodcut_id")
    private long productId;

    @Column(name="location_id")
    private long locationId;

    private int stockQty;

}