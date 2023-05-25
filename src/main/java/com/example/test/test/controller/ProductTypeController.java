package com.example.test.test.controller;

import com.example.test.test.dto.ProductDTO;
import com.example.test.test.dto.Response;
import com.example.test.test.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/add")
    public Response addProductType(@RequestParam String productType) {
        return productTypeService.addProductType(productType);
    }
}
