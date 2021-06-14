package com.experis.springrestapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class SpringJdbcConfig {
    @Bean
    public DataSource sqliteDataSource(@Value("${sqlite.driver.name:non}") String url,
                                      @Value("${sqlite.url:non}") String name) {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(name);
        dataSource.setUrl(url);
        return dataSource;
    }
}
