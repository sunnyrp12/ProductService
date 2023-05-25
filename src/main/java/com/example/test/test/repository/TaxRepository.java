package com.example.test.test.repository;

import com.example.test.test.entity.TaxMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaxRepository extends JpaRepository<TaxMaster, UUID> {

    TaxMaster findByTaxId(Integer taxId);

    TaxMaster findByProductTypeProductType(String productType);

}
