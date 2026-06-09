package com.blaze.backend.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SpringBootApplication
@OpenAPIDefinition(security = {@SecurityRequirement(name = "Bearer Authentication")})

public class RestaurantAdminPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantAdminPortalApplication.class, args);
	}

}
