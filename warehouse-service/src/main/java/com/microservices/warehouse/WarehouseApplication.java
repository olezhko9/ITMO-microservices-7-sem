package com.microservices.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.HashMap;
import java.util.Map;


@EnableEurekaClient
@SpringBootApplication
public class WarehouseApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WarehouseApplication.class);
        Map<String, Object> properties = new HashMap<>();
        properties.put("server.port", "9001");
        properties.put("spring.application.name", "warehouse-service");
        app.setDefaultProperties(properties);
        app.run(args);
    }

}
