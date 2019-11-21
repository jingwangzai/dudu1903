package com.qfjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DuduWeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduWeixinApplication.class, args);
    }

}
