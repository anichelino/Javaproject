package com.example.com.firstspringtraining.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        System.out.println("0. Spring calls constructor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println(bean.getClass() + "  " + beanName+"post process before initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println(bean.getClass() + "  " + beanName+"post process after initialization");
        return bean;
    }
}
