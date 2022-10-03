package com.portfolio.Fran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FranApplication {

    public static void main(String[] args) {
        SpringApplication.run(FranApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
        public void addCorsMapping(CorsRegistry registry){
            registry.addMapping("/edu/lista").allowedOrigins("https://frontendfranh.web.app/");
        }
        };
    }

}
