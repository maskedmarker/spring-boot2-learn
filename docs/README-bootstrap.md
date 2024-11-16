# 关于SpringBoot的定制化启动过程


## 核心概念

### SpringApplication

SpringApplication can be used to bootstrap and launch a Spring application from a Java main method.

SpringApplication perform the following steps to bootstrap your application:
1. Create an appropriate ApplicationContext instance (depending on your classpath)
2. Register a CommandLinePropertySource to expose command line arguments as Spring properties
3. Refresh the application context, loading all singleton beans 
4. Trigger any CommandLineRunner beans