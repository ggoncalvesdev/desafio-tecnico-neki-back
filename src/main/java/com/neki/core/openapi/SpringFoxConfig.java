package com.neki.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.neki"))
      .paths(PathSelectors.any())
      .build()
      .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("API - Desafio: NEKI Full Stack")
      .description("Essa é uma API para testar meus conhecimentos.")
      .license("Apache License Version 2.0")
      .licenseUrl(
        "https://www.apache.org/license/LICENSE-2.0%22).version(%221.0.0%22)"
      )
      .version("1")
      .contact(
        new Contact(
          "NEKI",
          "https://neki-it.com.br",
          "gabrielgoncalves4220@gmail.com"
        )
      )
      .build();
  }
}
