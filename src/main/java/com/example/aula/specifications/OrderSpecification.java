package com.example.aula.specifications;

import com.example.aula.models.Order;
import com.example.aula.models.Product;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class OrderSpecification {

    public static Specification<Order> hasOrderNumber(Number orderNumber) {
        return (((root, query, criteriaBuilder) ->
                orderNumber == null ?
                        null :
                        criteriaBuilder.equal(root.get("orderNumber"), orderNumber)));
    }

    public static Specification<Order> hasCustomerName(String customerName) {
        return (((root, query, criteriaBuilder) ->
                customerName == null ?
                        null :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("customerName")), "%"+customerName.toLowerCase()+"%")));
    }

    public static Specification<Order> hasStatus(String status) {
        return (((root, query, criteriaBuilder) ->
                status == null ?
                        null :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), "%"+status.toLowerCase()+"%")));
    }

    public static Specification<Order> hasAmountBetween(Double minAmount, Double maxAmount){
        return ((root, query, criteriaBuilder) ->  {
            if(minAmount!=null && maxAmount!=null) return criteriaBuilder.between(root.get("totalAmount"), minAmount, maxAmount);
            else if (minAmount!=null) return criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minAmount);
            else if (maxAmount!=null) return criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxAmount);
            return null;
        });
    }

    public static Specification<Order> hasDateBetween(LocalDate startDate, LocalDate endDate){
        return ((root, query, criteriaBuilder) ->  {
            if(startDate!=null && endDate!=null) return criteriaBuilder.between(root.get("orderDate"), startDate, endDate);
            else if (startDate!=null) return criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
            else if (endDate!=null) return criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
            return null;
        });
    }
}
