package com.example.test.test.controller;

import com.example.test.test.dto.ProductDTO;
import com.example.test.test.dto.Response;
import com.example.test.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Response addProduct(@RequestBody ProductDTO requestDTO) {
        return productService.addProduct(requestDTO);
    }

    @GetMapping("/get")
    public Response getProduct(@RequestParam Integer productId) {
        return productService.getProduct(productId);
    }

}
