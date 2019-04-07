package com.andrewwish.b2c.sale.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
public class SaleEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sale_number")
    private String number;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "agreement_id")
    private Long agreementId;

    @Column(name = "assignee_id")
    private Long assigneeId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderEntity> orders;
}
