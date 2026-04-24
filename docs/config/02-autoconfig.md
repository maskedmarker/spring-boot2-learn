# auto-config

```text
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration { //... }
```

## AutoConfigurationImportSelector

```text
加载所有spring.factories文件中key是EnableAutoConfiguration的配置项,这些配置项对应的class被当作configuration-class,即作为bean的来源来对待.
```


## 自动扫描路径

```text
@Import(AutoConfigurationPackages.Registrar.class)
public @interface AutoConfigurationPackage { //... }
```

```text
static class Registrar implements ImportBeanDefinitionRegistrar, DeterminableImports {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        register(registry, new PackageImports(metadata).getPackageNames().toArray(new String[0]));
    }
}

private static final class PackageImports {

    private final List<String> packageNames;

    PackageImports(AnnotationMetadata metadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(AutoConfigurationPackage.class.getName(), false));
        List<String> packageNames = new ArrayList<>();
        for (String basePackage : attributes.getStringArray("basePackages")) {
            packageNames.add(basePackage);
        }
        for (Class<?> basePackageClass : attributes.getClassArray("basePackageClasses")) {
            packageNames.add(basePackageClass.getPackage().getName());
        }
        if (packageNames.isEmpty()) {
            packageNames.add(ClassUtils.getPackageName(metadata.getClassName()));   // 如果没有指定扫描路径,扫描@AutoConfigurationPackage所在的类(通常用在主类)的包及其子包
        }
        
        this.packageNames = Collections.unmodifiableList(packageNames);
    }
}
```