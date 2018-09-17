package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductManager {

	@Autowired
    private ProductRepository productRepository;

    public void sellProductUnsafe(Long id, int quantity) {

        Product product = productRepository.findOne(id);

        if (quantity <= product.getRemaining()) {
            product.setRemaining(product.getRemaining() - quantity);
            productRepository.save(product);
        }
    }
    
    @Transactional
    public void sellProductTransactional(Long id, int quantity) {

        Product product = productRepository.findOne(id);

        if (quantity <= product.getRemaining()) {
            product.setRemaining(product.getRemaining() - quantity);
            productRepository.save(product);
        }
    }
    
    @Transactional
    public void sellProductOptimistic(Long id, int quantity) {
        productRepository.decreaseRemaining(id, quantity);
        System.out.println("dsadsa");
    }
}
