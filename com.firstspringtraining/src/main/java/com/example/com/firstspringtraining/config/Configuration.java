package com.example.com.firstspringtraining.config;

import com.example.com.firstspringtraining.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Student getFirstStudent(){
        return new Student("gianluca","mottola","politecnico di torino");
    }
}
