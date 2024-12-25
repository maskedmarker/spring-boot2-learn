package org.example.learn.spring.boot.hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({MyImportSelector.class})
public class ImportConfig {

}
