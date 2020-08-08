package com.initializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringinitializrApplication {

    public static void main(String[] args) {
        System.out.println("Start...");
        SpringApplication.run(SpringinitializrApplication.class, args);
        System.out.println("Success...");
    }

}
