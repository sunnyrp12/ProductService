package com.example.test.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO {

    @JsonProperty("tax_id")
    private Integer taxId;

    @JsonProperty("tax_rate")
    private BigDecimal taxRate;

    @JsonProperty("product_type")
    private String productType;

}
