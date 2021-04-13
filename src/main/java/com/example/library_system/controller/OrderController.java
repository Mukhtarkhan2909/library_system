package com.example.library_system.controller;
import com.example.library_system.entity.Library;
import com.example.library_system.entity.Orders;
import com.example.library_system.service.implementation.GetServiceImpl;
import com.example.library_system.service.implementation.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    GetServiceImpl getService;

    @GetMapping("")
    public List<Orders> getAllOrders() {
        return getService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") Long id) {
        return getService.getOrderById(id).get();
    }

    @PostMapping("")
    public void addOrder(@RequestBody Orders orders) {
        postService.addOrder(orders);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id,
                              @RequestBody Orders orders) {
        orders.setId(id);
        postService.updateOrder(id, orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        postService.deleteOrder(id);
    }
}
