package com.example.library_system.controller;

import com.example.library_system.entity.Customer;
import com.example.library_system.service.implementation.GetServiceImpl;
import com.example.library_system.service.implementation.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    GetServiceImpl getService;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return getService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return getService.getCustomerById(id).get();
    }

    @PostMapping("")
    public void addCustomer(@RequestBody Customer customer) {
        postService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id,
                           @RequestBody Customer customer) {
        customer.setId(id);
        postService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        postService.deleteCustomer(id);
    }

    @GetMapping("/book/{id}")
    public List<Customer> getCustomersByBookId(@PathVariable("id") Long id) {
        return getService.getCustomersByBookId(id);
    }
}
