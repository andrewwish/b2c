package com.andrewwish.b2c.cust.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * Договор
 */
@Entity
@Table(name = "agreement")
@Getter
public class AgreementEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "release_date")
    private Instant releaseDate;

    @ManyToOne
    @JsonIgnore
    private CustomerEntity customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agreement_to_contact",
            joinColumns = @JoinColumn(name = "agreement", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact", referencedColumnName = "id"))
    private List<ContactEntity> contacts;
}
