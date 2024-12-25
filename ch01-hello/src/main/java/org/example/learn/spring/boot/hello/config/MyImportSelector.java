package org.example.learn.spring.boot.hello.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportSelector.selectImports的返回值(class-name)会被当做configuration-class,
 * 该configuration-class会被spring容器管理
 *
 * CalculatorConfig不需要添加@Configuration
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{CalculatorConfig.class.getName()};
    }
}
