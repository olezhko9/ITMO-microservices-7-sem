package com.microservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApiGatewayApplication.class);
        Map<String, Object> properties = new HashMap<>();
        properties.put("server.port", "8111");
        properties.put("spring.application.name", "api-gateway");
        app.setDefaultProperties(properties);
        app.run(args);
    }

}
