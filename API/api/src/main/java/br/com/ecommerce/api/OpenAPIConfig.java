package br.com.ecommerce.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Ecommerce API",
                version = "v1.0.0",
                description = "API para gerenciamento de produtos."
        )
)

public class OpenAPIConfig {
}
