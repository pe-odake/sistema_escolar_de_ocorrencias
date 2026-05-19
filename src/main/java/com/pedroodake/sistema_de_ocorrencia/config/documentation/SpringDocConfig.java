//package com.pedroodake.sistema_de_ocorrencia.config.documentation;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringDocConfig {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .components(new Components()
//                        .addSecuritySchemes(
//                                "bearer-key",
//                                new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                        )
//                )
//                .info(new Info()
//                        .title("Auto Escola N-116")
//                        .description("API de back-end da escola N-116.")
//                        .contact(new Contact()
//                                .name("SENAI") // Nome da empresa pelas normar do codigo
//                                .email("pedroodake@gmail.com")
//                                .url("https://pedroodake.com")
//                        )
//                        .license(new License()
//                                .name("Apache 2.0")
//                                .url("http://autoescolan116.com.br/api/licence")
//                        )
//                );
//    }
//}
