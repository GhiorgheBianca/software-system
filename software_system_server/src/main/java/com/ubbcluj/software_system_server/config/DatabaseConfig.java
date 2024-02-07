package com.ubbcluj.software_system_server.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource getDataSource() {
        String dbUrl = System.getenv("POSTGRESQL_URI");
        // System.getenv("POSTGRESQL_URI")
        // "jdbc:postgresql://localhost:5432/system_database"
        return DataSourceBuilder
                .create()
                .url(dbUrl)
                .username("postgres")
                .password("admin")
                .build();
    }
}
