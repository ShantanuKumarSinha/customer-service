package com.customer;

import com.customer.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="contact-service",url="localhost:8999",path="/contact")
public interface ContactServiceFeignClient {
    @GetMapping("/customer/{customerId}")
    public List<Contact> getContacts(@PathVariable Long customerId);
}
