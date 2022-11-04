package com.jaieve.mandrakit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class MandraApplication {

    public static void main(String[] args) {
        SpringApplication.run(MandraApplication.class, args);
    }

}
