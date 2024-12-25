package org.example.learn.spring.boot.hello;

import org.example.learn.spring.boot.hello.config.Calculator;
import org.example.learn.spring.boot.hello.config.CalculatorConfig;
import org.example.learn.spring.boot.hello.config.SimpleCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
public class SpringApplicationTest {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Test
    public void test0() {
        Calculator calculator = applicationContext.getBean(Calculator.class);
        System.out.println("calculator = " + calculator);
        Assertions.assertEquals(SimpleCalculator.class, calculator.getClass());

        CalculatorConfig calculatorConfig = applicationContext.getBean(CalculatorConfig.class);
        System.out.println("calculatorConfig = " + calculatorConfig);
        Assertions.assertEquals(CalculatorConfig.class, calculatorConfig.getClass());
    }
}
