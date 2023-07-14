package com.practice.java8.studentManagementSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RetrieveUtils {

    public static List<Student> olderthan(List<Student> studentList,int age){
        return studentList.stream().filter(s->s.getAge()>age).collect(Collectors.toList());

    }

    public static Double averageAge(List<Student> studentList){
        return studentList.stream().collect(Collectors.averagingDouble(Student::getAge));

    }
    public static List<Student> sortByNames(List<Student> studentList){
        studentList.sort(Comparator.comparing(Student::getName));
                return studentList;

    }
    public static Optional<List<Course>> displayCoursesOfAStudent(List<Student> studentList, Long studentId){
        return studentList.stream().filter(s->s.getStudentId()==studentId).findFirst().map(Student::getCourseEnrolled);


    }

    public static Optional<Student> findStudentById(List<Student> studentList, Long studentId){
        return studentList.stream().filter(s->s.getStudentId()==studentId).findFirst();


    }

    public static Optional<List<Student>> findStudentsByCourse(List<Student> studentList, Course course){

        List<Student> studentsByCourse = studentList.parallelStream().filter(student -> student.getCourseEnrolled().contains(course)).collect(Collectors.toList());


        return Optional.ofNullable(studentsByCourse);


    }
    public static Optional<Student> findHighestCourseEnrolled(List<Student> studentList){

        Optional<Student> collect = studentList.stream().collect(Collectors.maxBy(Comparator.comparing(s -> s.getCourseEnrolled().toArray().length)));


        return collect;


    }

    public static Map<Integer, Set<Student>>  ageGroup(List<Student> studentList){

        Map<Integer, Set<Student>> agecollect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.toSet()));

        return agecollect;


    }

    public static List<Student>  ageandCoursePredicate (List<Student> studentList,Integer thresholdAge,Course courseToFind){

        Predicate<Student> studentPredicate = (s)->s.getAge()>thresholdAge;
        Predicate<Student> andPredicate = studentPredicate.and(s -> s.getCourseEnrolled().contains(courseToFind));
        List<Student> collect1 = studentList.stream().filter(andPredicate).collect(Collectors.toList());
        return collect1;



    }
    public static List<List<Course>>  findCoursesByStudent (List<Student> studentList,Student studentToFind){


        List<List<Course>> collect1 = studentList.stream().filter(s -> s == studentToFind).map(Student::getCourseEnrolled).collect(Collectors.toUnmodifiableList());
        return collect1;



    }

    public static Map<Course, Long>  findNumberOfEnrollmentOfCourses (List<Student> studentList){


        Map<Course, Long> collect2 = studentList.stream().flatMap(s -> s.getCourseEnrolled().stream()).collect(Collectors.groupingBy(course -> course, Collectors.counting()));
        return collect2;



    }

    public static List<Parameter>  getMethodParameters (Object object,String inputMethod) throws NoSuchMethodException {

        Method[] getMethods = object.getClass().getMethods();


        if (object.getClass().getName().contains(inputMethod)){

            Constructor<?>[] constructors = object.getClass().getConstructors();

            for (Constructor constructor: constructors) {
                Parameter[] parameters = constructor.getParameters();
                return Arrays.asList(parameters);
            }

        }

        else{
            for (Method method : getMethods){



                if (method.getName().contains(inputMethod)){

                    Parameter[] parameters = method.getParameters();

                    /*for (Parameter parameter : parameters){

                        System.out.println("parameter name: " + parameter.getName()+ ",  parameter type "+parameter.getType());

                    }*/
                    return Arrays.asList(parameters);
                }

        }


        }


        /*List<Method> list = Arrays.asList(inputClass.getDeclaredMethods());
        for (Method method : list) {
            String methodName = method.getName();
            System.out.println(methodName);

            for (int i = 0; i <method.getParameters().length ; i++) {

                System.out.println(method.getParameters()[i]);
            }
        }*/
        return null;

    }

    public static String  getCoursesDescription () {

        return Course.class.getAnnotation(CourseInfo.class).courseDescription();
    }
    public static List<Student>  getFilteredStudents (List<Student> studentList, StudentFilter studentFilter) {

        return studentList.stream().filter(s->studentFilter.test(s)).collect(Collectors.toList());

    }


    public static List<Student> getStudentsFromFileApi (String studentInputFilePath,Supplier<Integer> idProvider,List<Course>coursesList) {

        Supplier<Stream<String>> streamStudentSupplier=()-> {
            try {
                return new BufferedReader(new FileReader(studentInputFilePath)).lines();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };


        List<Student> students = streamStudentSupplier.get().skip(1).map((s ->
        {
            String[] content = s.split(";");
            String[] courses = content[1].split(",");
            List<String> coursesListOfEachStudent = Arrays.asList(courses);

            List<Integer> courseNumbers = coursesListOfEachStudent.stream().map(st -> Integer.valueOf(st.split("course")[1])).collect(Collectors.toList());
            List<Course> coursesOfEachStudent = courseNumbers.stream().map(i -> coursesList.get(i - 1)).collect(Collectors.toList());
            Student student = new Student(Integer.valueOf(content[0]).intValue(), coursesOfEachStudent, idProvider, content[2]);

            return student;

        })).collect(Collectors.toList());

        return students;

    }

    public static List<Course>  getCoursesFromFileApi (String courseInputFilePath,Supplier<Integer> idProvider) {

        Supplier<Stream<String>> streamCourseSupplier=()-> {
            try {
                return new BufferedReader(new FileReader(courseInputFilePath)).lines();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        List<Course> coursesList = streamCourseSupplier.get().skip(1).map(
                (s -> {
                    String[] content = s.split(";");
                    String[] coursesDates = content[2].split(",");
                    List<String> coursesDatesList = Arrays.asList(coursesDates);
                    List<Integer> collectDatesEachCourse = coursesDatesList.stream().map(st -> Integer.valueOf(st)).collect(Collectors.toList());
                    LocalDate localDateEachCourse = LocalDate.of(collectDatesEachCourse.get(2).intValue(), collectDatesEachCourse.get(1).intValue(), collectDatesEachCourse.get(0).intValue());
                    Course course = new Course(content[0], idProvider, content[1],localDateEachCourse);
                    return course;
                })
        ).collect(Collectors.toList());
        return coursesList;

    }


}
