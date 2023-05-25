package com.example.test.test.controller;

import com.example.test.test.dto.Response;
import com.example.test.test.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addProduct")
    public Response addProductToCart(@RequestParam Integer productId) {
        return cartService.addProductToCart(productId);
    }

}
