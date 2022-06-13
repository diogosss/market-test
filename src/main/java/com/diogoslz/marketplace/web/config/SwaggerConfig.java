package com.diogoslz.marketplace.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2  //Error de NullPOinter en version3.0.0 swagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.diogoslz.marketplace.web.controller"))
                .build();
    }
}

/*
* Errores ver application.properties
* build.gradle
* 'http://localhost{puerto}/platzi-market/api/swagger-ui/index.html’  version swagger2 3.0.0
* */