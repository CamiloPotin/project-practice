package com.app.noteAPI.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Configura el mapeo de CORS para tus endpoints
                .allowedOrigins("http://localhost:3000") // Permite solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("Authorization", "Content-Type") // Encabezados permitidos
                .exposedHeaders("header1", "header2") // Encabezados expuestos
                .allowCredentials(true)
                .maxAge(3600); // Tiempo máximo de caché de la pre-solicitud (en segundos)
    }
}
