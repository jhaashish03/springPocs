package com.practice.springPractice.controller;


import com.practice.springPractice.entity.mysqlEntities.Product;
import com.practice.springPractice.repositories.mysqlRepo.ProductRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    ProductRepository productRepository;
    @PostMapping("/customer")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/get/{id}")
    public Product getProductById(@PathParam("id") String productId){
        return productRepository.findById(productId).get();
    }

}
