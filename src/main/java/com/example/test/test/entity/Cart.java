package com.example.test.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "product")
    private String product;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "tax")
    private String taxDetails;

    @Column(name = "total")
    private BigDecimal total;
}
