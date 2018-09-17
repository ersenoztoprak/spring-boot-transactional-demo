package com.example.demo.controller;

import com.example.demo.dto.ProductUpdateDTO;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductManager;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductManager productManager;

    @Autowired
    private ProductService productService;
   

    //@GetMapping("/")
    //public List<Product> deleteME() {
    //    return productRepository.findAll();
    //}

    //@PutMapping(value = "/{id}")
    @RequestMapping(value = "/{id}",  method = RequestMethod.PUT)
    public void sell(@PathVariable("id") Long id, @RequestBody ProductUpdateDTO dto) {
    	productManager.sellProductOptimistic(id, dto.getQuantity());
    	//productService.sellProductOptimistic(id, dto.getQuantity());
    }


}
