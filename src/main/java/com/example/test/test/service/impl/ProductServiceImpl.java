package com.example.test.test.service.impl;

import com.example.test.test.dto.ProductDTO;
import com.example.test.test.dto.Response;
import com.example.test.test.entity.ProductMaster;
import com.example.test.test.entity.ProductType;
import com.example.test.test.repository.ProductRepository;
import com.example.test.test.repository.ProductTypeRepository;
import com.example.test.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public Response addProduct(ProductDTO requestDTO) {
        ProductMaster savedProduct = new ProductMaster();
        try {

            ProductType productType = productTypeRepository.findByProductType(requestDTO.getProductType());
            if (productType == null) {
                return new Response(false, "No product type found", null);
            }
            ProductMaster productMaster = new ProductMaster();
            productMaster.setProductName(requestDTO.getProductName());
            productMaster.setProductType(productType);
            productMaster.setProductDescription(requestDTO.getProductDescription());
            productMaster.setProductRate(requestDTO.getProductRate());
            savedProduct = productRepository.save(productMaster);
        } catch (Exception e) {
            return new Response(true, e.getLocalizedMessage(), null);
        }
        return new Response(false, "Product added successfully", savedProduct.getProductId());
    }

    @Override
    public Response getProduct(Integer productId) {
        ProductMaster productMaster = productRepository.findByProductId(productId);
        if (productMaster == null) {
            return new Response(false, "No product found with this Id", null);
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productMaster.getProductId());
        productDTO.setProductName(productMaster.getProductName());
        productDTO.setProductType(productMaster.getProductType().getProductType());
        productDTO.setProductDescription(productMaster.getProductDescription());
        productDTO.setProductRate(productMaster.getProductRate());
        return new Response(false, "Success", productDTO);
    }

}
