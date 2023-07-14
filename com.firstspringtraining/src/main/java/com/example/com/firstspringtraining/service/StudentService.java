package com.example.com.firstspringtraining.service;

import com.example.com.firstspringtraining.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private Student student;
    public String getStudentName(){
        return student.getName();
    }
}
