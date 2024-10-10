package com.lupogreybeard.dbd.randomizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RandomizerApp {

    public static void main(String[] args) {
        SpringApplication.run(RandomizerApp.class, args);
    }

    @RestController
    @RequestMapping("/api")
    class RandomizerController {

        @GetMapping("/hello")
        public String helloWorld() {
            return "Hello World";
        }
    }
}
