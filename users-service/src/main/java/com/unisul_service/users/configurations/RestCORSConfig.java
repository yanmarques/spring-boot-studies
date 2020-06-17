package com.unisul_service.users.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class RestCORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
	//WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
		.allowedOrigins("*")
		.allowedHeaders("*");
    }
}
