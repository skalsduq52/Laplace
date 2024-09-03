package com.yeop.Laplace.swagger;

import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Laplace API")
                        .version("1.0")
                        .description("Laplace API 명세서입니다."));
    }

    @Bean
    public GroupedOpenApi api() {
        String[] paths = {"/users/**"};
        String[] packagesToScan = {"com.yeop.Laplace"};
        return GroupedOpenApi.builder().group("springdoc-openapi")
                .pathsToMatch(paths)
                .packagesToScan(packagesToScan)
                .build();
    }
}
