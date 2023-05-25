package com.example.test.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class TaxMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    private Integer taxId;

    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    @JoinColumn(name = "product_type")
    @OneToOne
    private ProductType productType;

}
