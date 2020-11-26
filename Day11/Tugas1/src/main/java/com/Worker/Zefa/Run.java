package com.Worker.Zefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.Worker.Zefa"})//jalankan spring boot app
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}