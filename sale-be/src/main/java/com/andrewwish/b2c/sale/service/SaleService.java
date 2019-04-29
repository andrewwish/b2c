package com.andrewwish.b2c.sale.service;

import com.andrewwish.b2c.sale.api.MessageSaleCreated;
import com.andrewwish.b2c.sale.domain.SaleEntity;
import com.andrewwish.b2c.sale.domain.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;
    private MessagePublisher messagePublisher;

    public SaleEntity getById(long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public SaleEntity save(SaleEntity sale) {
        SaleEntity savedSale = saleRepository.save(sale);
        messagePublisher.publishMessage(new MessageSaleCreated(sale));
        return savedSale;
    }
}
