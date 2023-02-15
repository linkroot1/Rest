package com.example.springCrud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories("com.example.springCrud1.repository")
public class SpringRestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringRestApplication.class, args);

    }
}
