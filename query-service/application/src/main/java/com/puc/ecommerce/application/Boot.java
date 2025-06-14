package com.puc.ecommerce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.puc.ecommerce.api")
@ComponentScan("com.puc.ecommerce")
@EnableJpaRepositories(basePackages = "com.puc.ecommerce.repository")
@EntityScan(basePackages = "com.puc.ecommerce.repository")
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
