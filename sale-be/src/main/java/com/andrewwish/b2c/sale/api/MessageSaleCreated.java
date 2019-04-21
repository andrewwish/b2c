package com.andrewwish.b2c.sale.api;

import com.andrewwish.b2c.sale.domain.SaleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MessageSaleCreated implements Message<SaleEntity> {

    private SaleEntity payload;

    public String getKey() {
        return "sale_" + payload.getId() + " " + payload.getVersion();
    }
}
