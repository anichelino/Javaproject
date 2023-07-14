package com.practice.java8.studentManagementSystem;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
@Data
public class Student implements Enrollable,Serializable {
    private int age;
    private List<Course> courseEnrolled;

    private long studentId;
    private String name;

    @Override
    public void enrollToCourse(Course course){
        this.getCourseEnrolled().add(course);


    }

    public Student(int age, List<Course> courseEnrolled, Supplier<Integer> studentId, String name) {
        Supplier<Integer> idProvider=()-> Math.abs(new Random().nextInt(0,50));
        this.age = age;
        this.courseEnrolled = courseEnrolled;
        this.studentId = studentId.get();
        this.name = name;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setCourseEnrolled(List<Course> courseEnrolled) {
//        this.courseEnrolled = courseEnrolled;
//    }
//
//    public void setStudentId(long studentId) {
//        this.studentId = studentId;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public List<Course> getCourseEnrolled() {
//        return courseEnrolled;
//    }
//
//    public long getStudentId() {
//        return studentId;
//    }
//
//    public String getName() {
//        return name;
//    }
}
