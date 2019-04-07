package com.andrewwish.b2c.sale.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {

    private Long id;
    private Long catalogId;
    private int amount;
}
