package com.spring.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring.mongo.controller") // Adiciona escaneamento de pacote
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}