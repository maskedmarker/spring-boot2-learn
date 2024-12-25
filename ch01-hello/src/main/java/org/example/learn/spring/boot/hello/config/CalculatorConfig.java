package org.example.learn.spring.boot.hello.config;

import org.springframework.context.annotation.Bean;

public class CalculatorConfig {

    @Bean
    public Calculator calculator() {
        return new SimpleCalculator();
    }
}
