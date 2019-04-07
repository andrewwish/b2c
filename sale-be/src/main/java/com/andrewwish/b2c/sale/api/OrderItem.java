package com.andrewwish.b2c.sale.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {

    private Long id;
    private Long catalogId;
    private int amount;
}
