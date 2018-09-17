package com.example.demo.configuration;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//@org.springframework.boot.orm.jpa.EntityScan("com.example.demo")
//@EnableJpaRepositories("com.example.demo")
//@EnableTransactionManagement
public class DatabaseConfiguration {

    
    @Primary
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    private HikariConfig hikariConfig() {
    	HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost/gdg");
        config.setUsername("root");
        config.setPassword("");
        return config;
    }
}
