package com.example.aula.controllers;

import com.example.aula.models.Product;
import com.example.aula.services.ProductService;
import com.example.aula.services.ProductServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceSpecification productServiceSpecification;
//    private ProductService productService;


    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String name
    ) {
        return productServiceSpecification.getAllProducts(category, name, minPrice, maxPrice);
//        return productService.filterProducts(category, minPrice, maxPrice, name);
    }
}
