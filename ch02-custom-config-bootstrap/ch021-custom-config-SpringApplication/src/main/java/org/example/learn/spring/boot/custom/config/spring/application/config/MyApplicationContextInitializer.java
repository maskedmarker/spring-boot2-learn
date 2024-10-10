package org.example.learn.spring.boot.custom.config.spring.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        logger.info("initialize: {}", applicationContext);
    }
}
