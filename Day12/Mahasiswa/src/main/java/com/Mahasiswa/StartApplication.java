package com.Mahasiswa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Scan all packages on org.example
@SpringBootApplication(scanBasePackages={"com.Mahasiswa"})
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
