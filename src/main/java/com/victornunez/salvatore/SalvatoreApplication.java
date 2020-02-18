package com.victornunez.salvatore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalvatoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalvatoreApplication.class, args);
    }

}
