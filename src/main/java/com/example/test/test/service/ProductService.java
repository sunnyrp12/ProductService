package com.example.test.test.service;

import com.example.test.test.dto.ProductDTO;
import com.example.test.test.dto.Response;

public interface ProductService {
    Response addProduct(ProductDTO requestDTO);

    Response getProduct(Integer productId);
}
