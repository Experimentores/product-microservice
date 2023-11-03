package com.experimentores.productsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProductsApplication.class, args);
    }

}
