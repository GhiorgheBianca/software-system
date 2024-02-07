package com.ubbcluj.software_system_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/send")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET")
                .allowCredentials(true);

        registry.addMapping("/api/data")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET")
                .allowCredentials(true);

        registry.addMapping("/login")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST")
                .allowCredentials(true);

//        registry.addMapping("/**") // Apply globally to all endpoints
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//                .allowCredentials(true); // If cookies or authorization headers are used
    }
}
