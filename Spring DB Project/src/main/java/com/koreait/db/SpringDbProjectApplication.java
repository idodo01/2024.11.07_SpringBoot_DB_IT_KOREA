package com.koreait.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDbProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDbProjectApplication.class, args);
    }

}
