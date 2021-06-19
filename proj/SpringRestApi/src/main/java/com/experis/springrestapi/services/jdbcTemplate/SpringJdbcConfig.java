package com.experis.springrestapi.services.jdbcTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SpringJdbcConfig {

    @Bean
    public DataSource sqliteDataSource(@Value("${sqlite.driver.name:non}") String name,
                                      @Value("${sqlite.url:non}") String url) {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(name);
        dataSource.setUrl(url);
        return dataSource;
    }
}
