package com.example.test.test.service.impl;

import com.example.test.test.dto.Response;
import com.example.test.test.entity.ProductType;
import com.example.test.test.repository.ProductTypeRepository;
import com.example.test.test.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public Response addProductType(String productTypeName) {
        ProductType productType = new ProductType();
        productType.setProductType(productTypeName);
        ProductType savedProductType = productTypeRepository.save(productType);
        return new Response(false, "Success", savedProductType.getProductTypeId());
    }
}
