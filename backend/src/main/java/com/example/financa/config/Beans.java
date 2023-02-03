package com.example.financa.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Beans {

    @Bean
    public DataSource getDataSource(){

        DataSourceBuilder<?> db_builder = DataSourceBuilder.create();

        db_builder.driverClassName("org.h2.Driver");
        db_builder.url("jdbc:h2:mem:testdb");
        db_builder.username("sa");
        db_builder.password("");

        return db_builder.build();

    }

}
