package com.risco.friendApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource( {"classpath:root-context.xml", "classpath:spring-database.xml", "classpath:spring-security.xml" })
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}	