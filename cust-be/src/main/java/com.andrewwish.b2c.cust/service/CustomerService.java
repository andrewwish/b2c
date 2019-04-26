package com.andrewwish.b2c.cust.service;

import com.andrewwish.b2c.cust.domain.CustomerEntity;
import com.andrewwish.b2c.cust.domain.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerEntity create(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public CustomerEntity getById(long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
