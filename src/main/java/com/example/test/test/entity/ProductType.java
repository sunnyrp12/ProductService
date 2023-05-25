package com.example.test.test.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;

    @Column(name = "product_type")
    private String productType;


}
