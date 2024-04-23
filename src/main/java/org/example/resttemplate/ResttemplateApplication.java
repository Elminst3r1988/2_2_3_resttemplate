package org.example.resttemplate;

import org.example.resttemplate.properties.LoanProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.starter.config.IncomeClientAutoConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(LoanProperties.class)
public class ResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
    }
}
