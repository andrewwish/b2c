package com.andrewwish.b2c.sale.service;

import com.andrewwish.b2c.sale.model.SaleEntity;
import com.andrewwish.b2c.sale.model.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;


    public SaleEntity getSale(long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public SaleEntity postSale(SaleEntity sale) {
        return saleRepository.save(sale);
    }
}
