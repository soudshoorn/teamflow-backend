package com.teamflow.teamflow_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI teamflowOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Teamflow API")
                .description("Overzicht van de API voor Teamflow")
                .version("v1.0"));
    }
}