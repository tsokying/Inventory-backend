package com.tsokying.hktvmalltest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @Pattern(regexp = "[A-Z]{2}-[A-Z]{2,4}[0-9]{2,4}", message = "Product Code's format is not correct")
    private String code;

    private double weight;

    private String status;

}
