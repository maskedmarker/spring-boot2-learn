

```text
在 Spring Boot 中，如果 main 线程负责启动 Spring 应用上下文，它不会在初始化完成后立刻退出，而是会一直保持运行，直到整个应用关闭。

分析 SpringApplication.run() 做了什么？
创建并启动 ApplicationContext；
注册所有 Bean、配置类等；
如果有 Web 容器（如 Tomcat）或调度器，会启动后台线程；
最关键的是：
    run() 方法虽然在 main 线程中调用，但它会阻塞住，不会直接让 main 线程退出！

这是因为：
对于 Web 应用，Spring Boot 内部会启动一个 WebServer（如 Tomcat），它内部的 await() 方法会阻塞，main 线程就不会退出；
对于非 Web 应用，如果有 @Scheduled、@Async、CommandLineRunner、ApplicationRunner 等，Spring 也会维护事件循环，或者至少 main 会等到这些任务处理完。(?????)
```






