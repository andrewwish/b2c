package com.andrewwish.b2c.sale.model;

import com.andrewwish.b2c.sale.dto.OrderStatus;
import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "createDate")
    private Instant createDate;

    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    private SaleEntity sale;
}
