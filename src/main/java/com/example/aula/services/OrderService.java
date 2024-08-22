package com.example.aula.services;

import com.example.aula.models.Order;
import com.example.aula.repositories.OrderRepository;
import com.example.aula.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(Number orderNumber, String customerName, String status, Double minAmount, Double maxAmount, LocalDate startDate, LocalDate endDade) {
        Specification<Order> spec = Specification
                .where(OrderSpecification.hasOrderNumber(orderNumber))
                .and(OrderSpecification.hasCustomerName(customerName))
                .and(OrderSpecification.hasStatus(status))
                .and(OrderSpecification.hasAmountBetween(minAmount, maxAmount))
                .and(OrderSpecification.hasDateBetween(startDate, endDade));
        return orderRepository.findAll(spec);
    }
}
