package com.example.sce;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SceConfig implements WebMvcConfigurer {
    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS");
    }
}