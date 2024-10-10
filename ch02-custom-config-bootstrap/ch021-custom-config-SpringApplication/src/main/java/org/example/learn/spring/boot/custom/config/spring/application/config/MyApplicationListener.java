package org.example.learn.spring.boot.custom.config.spring.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationContextInitializer.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        logger.info("onApplicationEvent: {}", event);
    }
}
