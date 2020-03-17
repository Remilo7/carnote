package com.carnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class CarnoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarnoteApplication.class, args);
    }

}
