# springBoot配置文件优先级

## 配置文件加载完整顺序(优先级从高到低)

```text
1. 命令行参数(--server.port=8080)
   ↓
2. Java系统属性(System.getProperties())
   ↓
3. 操作系统环境变量
   ↓
4. JNDI属性(java:comp/env)
   ↓
5. ServletContext初始化参数
   ↓
6. ServletConfig初始化参数
   ↓
7. @PropertySource注解加载的配置
   ↓
8. 配置文件(application-{profile}.properties/yml)
   ↓
9. 主配置文件(application.properties/yml)
   ↓
10. @ConfigurationProperties的默认值
```

## 配置文件位置优先级(从高到低)

spring更倾向于在应用根目录下的/config子目录中放置配置文件

```text
// 1. 当前目录的/config子目录(最高优先级) ./config/application.properties
   ↓
// 2. 当前目录 ./application.properties
   ↓
// 3. classpath下的/config包 classpath:/config/application.properties
   ↓
// 4. classpath根目录(最低优先级) classpath:/application.properties
```

## YAML和Properties加载顺序(靠后的优先级高)

```text
当同时存在YAML和Properties文件时,加载顺序为：

application.properties(优先加载)
application.yml(后加载,覆盖前者)

注意：如果两个文件中配置了相同的属性,后加载的会覆盖先加载的.如果有冲突,YAML中的配置会覆盖Properties中的配置.
```

## Profile-specific配置文件 加载顺序(靠后的优先级高)

```text
加载顺序:

1. application.properties(默认配置)
   ↓
2. application-{profile}.properties(profile特定配置,覆盖默认)
   ↓
3. 多个profile时的顺序(后面的覆盖前面的)
   - 通过spring.profiles.active指定的profile(优先级最高)
   - 通过spring.profiles.include包含的profile
```


## 自定义配置文件位置

使用 spring.config.location 指定外部配置
```text
# 使用绝对路径
java -jar app.jar --spring.config.location=/opt/config/application.properties

# 使用多个位置(用逗号分隔)
java -jar app.jar --spring.config.location=./config/,classpath:/config/

# 指定具体文件
java -jar app.jar --spring.config.location=file:/opt/config/application.yml
```

使用 spring.config.additional-location 补充配置
```text
# 在默认位置基础上增加配置位置
java -jar app.jar --spring.config.additional-location=/opt/override/application.properties
```

```text
当你使用 spring.config.location 时, SpringBoot会完全忽略默认路径下的 application.properties 和 application-{profile}.properties 文件
当你使用 spring.config.additional-location 时, SpringBoot不会替换默认加载路径,而是在默认路径的基础上,增加额外的搜索位置.额外位置的配置优先级高于默认配置，可以实现“部分覆盖”.🎯🎯🎯

⚠️ 重要注意事项
目录 vs 文件：
location 或 additional-location 如果指向一个目录(以 / 结尾)，Spring Boot 会按照默认规则(application.properties、application.yml)在该目录下查找文件;如果指向一个具体文件，则直接加载该文件.
```


## @PropertySource注解加载顺序

```java
@Configuration
// 加载顺序：从下到上(后加载的覆盖先加载的)
@PropertySource("classpath:config1.properties")
@PropertySource("classpath:config2.properties")
@PropertySource(value = "classpath:config3.properties", ignoreResourceNotFound = true)
public class AppConfig {
    // config2会覆盖config1,config3会覆盖config2
}
```