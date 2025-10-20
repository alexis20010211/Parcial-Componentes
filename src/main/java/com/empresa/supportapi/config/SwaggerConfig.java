package com.empresa.supportapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SupportAPI - Gestión de Clientes,Solicitudes,Tecnicos")
                        .version("1.0.0")
                        .description("API RESTful desarrollada en Spring Boot para la gestión de clientes, autenticación y solicitudes de soporte técnico.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo - SupportAPI")
                                .email("soporte@empresa.com")
                                .url("https://github.com/alexis20010211"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio del Proyecto - SupportAPI")
                        .url("https://github.com/alexis20010211/Parcial-Componentes"));
    }
}
