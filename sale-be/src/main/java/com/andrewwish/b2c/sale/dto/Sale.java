package com.andrewwish.b2c.sale.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class Sale {

    private Long id;
    private String number;
    private Instant createDate;
    private Long customerId;
    private Long agreementId;
    private Long assigneeId;
    private List<Order> orders;
}
