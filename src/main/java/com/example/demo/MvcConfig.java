package com.example.demo;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        Path productUploadDir = Paths.get("product-image");
        Path staticDir = Paths.get("src/main/resources/static");
        String staticPath = staticDir.toFile().getAbsolutePath();
        String productUploadPath = productUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/product-image/**", "/**").addResourceLocations("file:/" + productUploadPath + "/", "file:/" + staticPath + "/");
    }    
}
