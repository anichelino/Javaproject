package com.practice.java8.studentManagementSystem;

@FunctionalInterface
public interface StudentFilter {
    boolean test(Student student);
}
