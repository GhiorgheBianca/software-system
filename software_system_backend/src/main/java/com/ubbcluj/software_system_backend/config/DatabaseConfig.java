package com.ubbcluj.software_system_backend.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

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
