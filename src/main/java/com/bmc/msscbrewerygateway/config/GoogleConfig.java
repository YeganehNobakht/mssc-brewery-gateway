package com.bmc.msscbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Masoumeh Yeganeh
 * @created 26/06/2023
 */
//@Profile("google")
//@Configuration
public class GoogleConfig {
    @Bean
    public RouteLocator googleConfiguration(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/").uri("https://google.com"))
                .build();
    }
}
