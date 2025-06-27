package com.synergisticit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.synergisticit")
public class Day15SpringBootAssignment1Application {
    public static void main(String[] args) {
        SpringApplication.run(Day15SpringBootAssignment1Application.class, args);
    }
}
