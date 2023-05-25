package com.example.test.test.controller;

import com.example.test.test.dto.Response;
import com.example.test.test.dto.TaxDTO;
import com.example.test.test.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping("/add")
    public Response addTaxDetails(@RequestBody TaxDTO reqDTO) {
        return taxService.addTaxDetails(reqDTO);
    }

    @GetMapping("/get")
    public Response getTaxDetails(@RequestParam Integer taxId) {
        return taxService.getTaxDetails(taxId);
    }

}
