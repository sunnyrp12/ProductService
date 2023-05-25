package com.example.test.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class ProductMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @JoinColumn(name = "product_type")
    @ManyToOne()
    private ProductType productType;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_rate")
    private BigDecimal productRate;


}
