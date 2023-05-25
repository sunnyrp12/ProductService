package com.example.test.test.dto;

import com.example.test.test.entity.ProductMaster;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDTO {

    @JsonProperty("cart_id")
    private Integer cartId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("rate")
    private BigDecimal rate;

    @JsonProperty("tax(SGST+CGST)")
    private String taxDetails;

    @JsonProperty("total")
    private BigDecimal total;
}
