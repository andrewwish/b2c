package com.andrewwish.b2c.cust.web;

import com.andrewwish.b2c.cust.domain.CustomerEntity;
import com.andrewwish.b2c.cust.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/api/v1/customers/{id}")
    public CustomerEntity getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/api/v1/customers")
    public CustomerEntity postCustomer(@RequestBody CustomerEntity customer) {
        return customerService.createCustomer(customer);
    }
}
