package com.capy.back;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//para todos los endpoints
                .allowedOrigins("http://localhost:8100")//permitir solicitudes de todos los origenes
                .allowedMethods("*")//permitir todos los metodos
                .allowCredentials(true);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
