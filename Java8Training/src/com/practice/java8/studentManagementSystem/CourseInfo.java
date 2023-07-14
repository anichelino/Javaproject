package com.practice.java8.studentManagementSystem;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfo {
    String courseDescription() default "no course description provided";
}
