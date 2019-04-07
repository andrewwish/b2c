package com.andrewwish.b2c.sale.api;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class Order {

    private Long id;
    private List<OrderItem> orderItems;
    private Instant createDate;
    private OrderStatus status;
    private Long managerId;
    private String comment;
}
