package com.practice.java8.studentManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@CourseInfo(courseDescription = "All courses will be held in classes of max 12 people ")

public class Course {
    private String name;
    private long courseId;


    private String instructor;

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    //Task 6: Date and Time API
    //- Use the Date and Time API to store and process the enrollment date for a course (e.g., `LocalDate`).
    private LocalDate enrollmentDate;

    //Task 17: Collectors
    //      - Implement a method to collect and return a map of courses and the number of students enrolled in each course using the `Collectors.groupingBy` and `Collectors.counting` collectors.

    public List<Student> getStudentList() {
        return studentList;
    }

    private List<Student> studentList= new ArrayList<>();


    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public long getCourseId() {
        return courseId;
    }

    public String getInstructor() {
        return instructor;
    }

    public Course(String name, Supplier<Integer> idSupplier, String instructor) {
        this.name = name;
        this.courseId = idSupplier.get();
        this.instructor = instructor;
    }


    //Task 6: Date and Time API
    //- Use the Date and Time API to store and process the enrollment date for a course (e.g., `LocalDate`).
    public Course(String name,Supplier<Integer> idSupplier, String instructor, LocalDate enrollmentDate) {
        this.name = name;
        this.courseId = idSupplier.get();
        this.instructor = instructor;
        this.enrollmentDate=enrollmentDate;

    }

    @Override
    public boolean equals(Object o) {
        Course course2= (Course) o;
        if (this.courseId == course2.getCourseId()) return true;
       else{

        return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return "Course{" /*+ "\n"*/+
                "name='" + name + '\'' /*+ "\n"*/+
                ", courseId=" + courseId /*+ "\n"*/+
                ", instructor='" + instructor /*+ '\''*/ + "\n"+
                "enrollment date"+enrollmentDate/*+"\n"+*/+
                '}';
    }
}
