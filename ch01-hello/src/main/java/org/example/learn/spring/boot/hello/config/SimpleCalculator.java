package org.example.learn.spring.boot.hello.config;

public class SimpleCalculator implements Calculator{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
