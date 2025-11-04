package com.ieee754;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IEEE754Application {
    public static void main(String[] args) {
        SpringApplication.run(IEEE754Application.class, args);
        System.out.println("IEEE 754 Calculator API is running on http://localhost:8080");
    }
}