package com.andrewwish.b2c.cust.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type")
    private String type;  // ИП/ЮД

    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AgreementEntity> agreements;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ContactEntity> contacts;

    @Column(name = "inn")
    private String inn;

}
