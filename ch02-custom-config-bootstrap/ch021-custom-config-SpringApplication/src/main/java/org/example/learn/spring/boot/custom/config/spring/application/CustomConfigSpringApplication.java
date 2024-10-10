package org.example.learn.spring.boot.custom.config.spring.application;

import org.example.learn.spring.boot.custom.config.spring.application.config.MyApplicationContextInitializer;
import org.example.learn.spring.boot.custom.config.spring.application.config.MyApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类SpringApplication的主要功能就是boostrap,而且是将启动信息存储在对象属性中,而非类属性中.
 * 如果不涉及到server的话,可以在一个应用中启动多个SpringApplication,即同时存在多个独立的SpringApplication
 */
@SpringBootApplication
public class CustomConfigSpringApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CustomConfigSpringApplication.class);
        customConfig(springApplication);
        springApplication.run(args);
    }

    // 定制化启动过程
    private static void customConfig(SpringApplication springApplication) {
        springApplication.addInitializers(new MyApplicationContextInitializer());
        springApplication.addListeners(new MyApplicationListener());
    }
}
