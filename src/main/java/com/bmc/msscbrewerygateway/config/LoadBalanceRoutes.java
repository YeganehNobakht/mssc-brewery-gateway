package com.bmc.msscbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Masoumeh Yeganeh
 * @created 27/06/2023
 */
@Profile("local-discovery")
@Configuration
public class LoadBalanceRoutes {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/api/v1/beer*","/api/v1/beer/*","/api/v1/beerUpc/*")
                        .uri("lb://beer-service"))

                .route(r->r.path("/api/v1/customers/**")
                        .uri("lb://order-service"))

                .route(r->r.path("/api/v1/beer/*/inventory")
                        .uri("lb://inventory-service"))

                .build();
    }
}
