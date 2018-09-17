package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
    public void sellProductOptimistic(Long id, int quantity) {
		
		
		jdbcTemplate.update("update Product set remaining = remaining - ? where id =? and remaining >= ?",
                preparedStatement -> {
                    preparedStatement.setInt(1, quantity);
                    preparedStatement.setLong(2, id);
                    preparedStatement.setInt(3, quantity);
                });
		
		System.out.println("dasad");
    }
}
