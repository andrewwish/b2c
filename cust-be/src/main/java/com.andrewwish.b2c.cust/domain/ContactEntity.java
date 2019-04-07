package com.andrewwish.b2c.cust.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JsonIgnore
    private CustomerEntity customer;

    @ManyToMany(mappedBy = "contacts")
    private List<AgreementEntity> agreements;
}
