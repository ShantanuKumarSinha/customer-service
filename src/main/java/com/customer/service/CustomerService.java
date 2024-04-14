package com.customer.service;

import com.customer.model.Customer;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {
    public Customer getCustomer(Long customerId);

}
