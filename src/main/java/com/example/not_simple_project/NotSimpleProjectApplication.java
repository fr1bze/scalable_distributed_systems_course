package com.example.not_simple_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.entity")
public class NotSimpleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotSimpleProjectApplication.class, args);
    }

}
