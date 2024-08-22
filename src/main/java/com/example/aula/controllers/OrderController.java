package com.example.aula.controllers;

import com.example.aula.models.Order;
import com.example.aula.services.OrderService;
import com.example.aula.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders(
            @RequestParam(required = false) Number orderNumber,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(required = false)LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate
            ){
        return orderService.getAllOrders(orderNumber, customerName, status, minAmount, maxAmount, startDate, endDate);
    }
}
