package com.example.test.test.service.impl;

import com.example.test.test.dto.CartDTO;
import com.example.test.test.dto.Response;
import com.example.test.test.entity.Cart;
import com.example.test.test.entity.ProductMaster;
import com.example.test.test.entity.TaxMaster;
import com.example.test.test.repository.CartRepository;
import com.example.test.test.repository.ProductRepository;
import com.example.test.test.repository.TaxRepository;
import com.example.test.test.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public Response addProductToCart(Integer productId) {
        CartDTO cartDTO = new CartDTO();
        try {
            ProductMaster productMaster = productRepository.findByProductId(productId);
            TaxMaster taxMaster = taxRepository.findByProductTypeProductType(productMaster.getProductType().getProductType());

            Cart cart = new Cart();
            cart.setProduct(productMaster.getProductName());
            cart.setTotal(productMaster.getProductRate());

            BigDecimal totalPrice = productMaster.getProductRate();
            BigDecimal taxRate = taxMaster.getTaxRate();
            BigDecimal taxAmount = totalPrice.multiply(taxRate).divide(BigDecimal.valueOf(100));
            BigDecimal productRate = totalPrice.subtract(taxAmount);

            //CGST Or SGST
            BigDecimal gst = taxMaster.getTaxRate().divide(BigDecimal.valueOf(2));

            cart.setRate(productRate);
            cart.setTaxDetails(productRate+"+"+gst+"+"+gst);
            Cart savedCart = cartRepository.save(cart);

            cartDTO.setCartId(savedCart.getCartId());
            cartDTO.setProductName(savedCart.getProduct());
            cartDTO.setRate(savedCart.getRate());
            cartDTO.setTaxDetails(savedCart.getTaxDetails());
            cartDTO.setTotal(savedCart.getTotal());
        } catch (Exception e) {
            return new Response(true, e.getLocalizedMessage(), null);
        }
        return new Response(false, "Product added to Cart successfully", cartDTO);
    }
}
