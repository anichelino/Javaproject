package com.example.com.firstspringtraining.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Student implements BeanPostProcessor {
    private String name;
    private String surname;
    private String school;


}
