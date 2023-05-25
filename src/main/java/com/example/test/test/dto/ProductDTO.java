package com.example.test.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("product_description")
    private String productDescription;

    @JsonProperty("product_rate")
    private BigDecimal productRate;



}
