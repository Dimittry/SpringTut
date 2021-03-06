package com.springtut.module3;

import com.springtut.module3.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class, AppConfig.class
        );
        System.out.println(context.getBeanDefinitionCount());
        for(String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
