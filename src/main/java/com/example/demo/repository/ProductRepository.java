package com.example.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Modifying(clearAutomatically=true)
    @Query("update Product set remaining = remaining - :quantity where id =:id and remaining >= :quantity")
    int decreaseRemaining(@Param("id") long id, @Param("quantity") int quantity);
}
