package com.example.aula.services;

import com.example.aula.models.Product;
import com.example.aula.repositories.ProductRepository;
import com.example.aula.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceSpecification {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(String category, String name, Double minPrice, Double maxPrice) {
        Specification<Product> spec = Specification
                .where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.hasPriceBetween(minPrice,maxPrice))
                .and(ProductSpecification.nameContains(name));

        return productRepository.findAll(spec);
    }
}
