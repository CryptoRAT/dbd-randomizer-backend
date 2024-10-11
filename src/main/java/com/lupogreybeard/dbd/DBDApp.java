package com.lupogreybeard.dbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lupogreybeard.dbd.repository")
public class DBDApp {

    public static void main(String[] args) {
        SpringApplication.run(DBDApp.class, args);
    }
}
