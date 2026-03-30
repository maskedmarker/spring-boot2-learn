# auto-config

```text
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration { //... }
```

## AutoConfigurationImportSelector

```text
加载所有spring.factories文件中key是EnableAutoConfiguration的配置项,这些配置项对应的class被当作configuration-class,即作为bean的来源来对待.
```