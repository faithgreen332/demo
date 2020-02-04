package com.example.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lijinfei
 * @Desc 配置cors请求，另外另种方法是过滤器里加对应的请求头和在请求方法里加注解CrossOrigin
 * @date 2020/2/4 13:15 Version: 1.0
 */
// @Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE",
        // "OPTIONS")
        // .allowedHeaders("*").allowCredentials(true).maxAge(3600);
    }
}
