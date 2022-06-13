package com.diogoslz.marketplace.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2  //Error de NullPOinter en version3.0.0 swagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.diogoslz.marketplace.web.controller"))
                .build();

    }

    //NO FUNCA
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Supermarket Service API",
                "Supermarket Service API Documentation",
                "1.0.0",
                "https://jcodepoint.com/",
                new Contact("dasl", "https://devsyrc.com", "diogosldus@devsyrc.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}

/*
* Errores ver application.properties
* build.gradle
* 'http://localhost{puerto}/platzi-market/api/swagger-ui/index.html’  version swagger2 3.0.0
* */