package com.practice.java8.studentManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupportMainExecutor {
    public static void main(String[] args) {
        Supplier<Integer> idProvider=()-> Math.abs(new Random().nextInt(0,50));
        Course course1= new Course("Maths",idProvider,"John", LocalDate.of(2022,12,23));
        Course course2= new Course("Physics",idProvider,"Mark", LocalDate.of(2022,10,23));
        Course course3= new Course("Mechanical Structures",idProvider,"Luke", LocalDate.of(2022,11,23));
        Course course4= new Course("English",idProvider,"Nicole", LocalDate.of(2022,9,23));
        Course course5= new Course("German",idProvider,"Rene", LocalDate.of(2022,1,23));
        Course course6= new Course("Computer Science",idProvider,"Satish", LocalDate.of(2022,7,23));
        Course course7= new Course("History",idProvider,"Raphael", LocalDate.of(2022,6,23));
        Course course8= new Course("Biology",idProvider,"Ronnie", LocalDate.of(2022,8,23));



        Student student1= new Student(18,new ArrayList<>(List.of(course1,course2,course3,course7,course5)),idProvider,"Stephan");
        Student student2= new Student(29,new ArrayList<>(List.of(course4,course5,course3,course7)),idProvider,"Doe");
        Student student3= new Student(23,new ArrayList<>(List.of(course6,course1,course4,course7)),idProvider,"Ronald");
        Student student4= new Student(24,new ArrayList<>(List.of(course7,course2,course3,course6)),idProvider,"Miguel");
        Student student5= new Student(22,new ArrayList<>(List.of(course1,course4,course7,course2)),idProvider,"Mathias");
        Student student6= new Student(28,new ArrayList<>(List.of(course4,course2,course5,course6)),idProvider,"Roger");
        Student student7= new Student(22,new ArrayList<>(List.of(course4,course2,course5,course6)),idProvider,"Mamatha");

        List<Student> allStudentList= new ArrayList<>(List.of(student1,student2,student3,student4,student5,student6,student7));

        List<Course> allCourseList= new ArrayList<>(List.of(course1,course2,course3,course4,course5,course6,course7));

        Comparator<Course> courseComparator= (c1,c2)->c1.getEnrollmentDate().compareTo(c2.getEnrollmentDate());
        Comparator<Course> courseComparatorOtherWay= Comparator.comparing(Course::getEnrollmentDate);
        allCourseList.sort(courseComparator);
        System.out.println(allCourseList);

    }
}
