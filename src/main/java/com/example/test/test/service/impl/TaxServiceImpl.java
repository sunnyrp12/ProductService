package com.example.test.test.service.impl;

import com.example.test.test.dto.Response;
import com.example.test.test.dto.TaxDTO;
import com.example.test.test.entity.ProductType;
import com.example.test.test.entity.TaxMaster;
import com.example.test.test.repository.ProductTypeRepository;
import com.example.test.test.repository.TaxRepository;
import com.example.test.test.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public Response addTaxDetails(TaxDTO reqDTO) {
        TaxMaster savedTaxMaster = new TaxMaster();
        try {
            ProductType productType = productTypeRepository.findByProductType(reqDTO.getProductType());
            if (productType == null) {
                return new Response(false, "No product type found", null);
            }
            TaxMaster taxMaster = new TaxMaster();
            taxMaster.setTaxRate(reqDTO.getTaxRate());
            taxMaster.setProductType(productType);
            savedTaxMaster = taxRepository.save(taxMaster);
        } catch (Exception e) {
            return new Response(true, e.getLocalizedMessage(), null);
        }
        return new Response(false, "Tax Details added successfully", savedTaxMaster.getTaxId());
    }

    @Override
    public Response getTaxDetails(Integer taxId) {
        TaxMaster taxMaster = taxRepository.findByTaxId(taxId);
        if (taxMaster == null) {
            return new Response(false, "No Tax Details found with this Id", null);
        }
        TaxDTO taxDTO = new TaxDTO();
        taxDTO.setTaxId(taxMaster.getTaxId());
        taxDTO.setTaxRate(taxMaster.getTaxRate());
        taxDTO.setProductType(taxMaster.getProductType().getProductType());
        return new Response(false, "Success", taxDTO);
    }
}
