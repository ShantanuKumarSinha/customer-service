package com.customer.service;

import com.customer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

  List<Customer> list = List.of(Customer
          .builder()
          .customerId(101L)
          .customerName("Shantanu Kumar")
          .phoneNumber(99883456)
          .build(),
          Customer
                  .builder()
                  .customerId(102L)
                  .customerName("Black Box")
                  .phoneNumber(99883451)
                  .build());

    @Override
    public Customer getCustomer(Long customerId) {
        return this.list.stream()
                .filter(customer -> Objects.equals(customer.getCustomerId(),customerId))
                .findFirst()
                .orElse(null);
    }
}
