package com.example.test.test.service;

import com.example.test.test.dto.Response;
import com.example.test.test.dto.TaxDTO;

public interface TaxService {
    Response addTaxDetails(TaxDTO reqDTO);

    Response getTaxDetails(Integer taxId);
}
