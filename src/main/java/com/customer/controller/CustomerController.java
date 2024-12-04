package com.customer.controller;

import com.customer.ContactServiceFeignClient;
import com.customer.model.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ContactServiceFeignClient contactServiceFeignClient;

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId){

       // var contacts = restTemplate.getForObject("http://localhost:8999/contact/customer/"+customerId, List.class);
        var contacts = contactServiceFeignClient.getContacts(customerId);
        var customer = customerService.getCustomer(customerId);
        customer.setContacts(contacts);
        return customer;
    }
}
