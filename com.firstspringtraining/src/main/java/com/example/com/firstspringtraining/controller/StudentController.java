package com.example.com.firstspringtraining.controller;

import com.example.com.firstspringtraining.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/studentName")
    String getStudentName(){
        return studentService.getStudentName();
    }


}
