package com.practice.java8.studentManagementSystem;



import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainExecutor {
    public static void main(String[] args) {
        // Define Student and Course Models
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

        //Implement a method to filter and retrieve students who are above a certain age (e.g., 20 years) using the Stream API and a functional interface.
        List<Student> olderThan20YearsStudents= RetrieveUtils.olderthan(allStudentList,25);
        //olderThan20YearsStudents.forEach(System.out::println);

       // Implement a method to calculate and return the average age of all students using the Stream API.

        Double averageAge= RetrieveUtils.averageAge(allStudentList);
        System.out.println("------------ ");
        //System.out.println("(average age is ) "+averageAge.intValue());

        //Implement a method to sort students based on their names using method references.
        System.out.println("------------ ");
        List<Student> studentsSortedByNames = RetrieveUtils.sortByNames(allStudentList);
        // System.out.println("student sorted by names "+ studentsSortedByNames);

        // Implement a method to print the course names of a student using method references.

        Optional<List<Course>> coursesOfOneStudent = RetrieveUtils.displayCoursesOfAStudent(allStudentList, student1.getStudentId());

        //System.out.println("courses of the selected student: "+coursesOfOneStudent.get());

        //Task 4: Optional
          //      - Implement a method to find a student by ID and return an `Optional<Student>`. Handle the case where the student is not found.

        Optional<Student> studentById = RetrieveUtils.findStudentById(allStudentList, student2.getStudentId());
        /*if (studentById.isPresent()){
            System.out.println(studentById.get());
        }
        else{

            throw new RuntimeException("\"student with given id is not present\"");
        }*/

        //Task 5: Default Methods in Interfaces
        //- Create an interface `Enrollable` with a default method `enrollToCourse(Course course)` that adds the given course to the student's `coursesEnrolled` list.
          //      - Make the `Student` class implement the `Enrollable` interface.
        System.out.println("------------ ");


        //student7.enrollToCourse(course1);
        //System.out.println(student7.getCourseEnrolled());

        //Task 6: Date and Time API
        //- Use the Date and Time API to store and process the enrollment date for a course (e.g., `LocalDate`).
        System.out.println("------------ ");

        allCourseList.sort(Comparator.comparing(Course::getEnrollmentDate));

        //allCourseList.forEach(System.out::println);

        //Task 7: Parallel Streams
        //- Implement a method to find all students who are enrolled in a specific course using parallel streams for improved performance.


        Optional<List<Student>> studentsByCourse = RetrieveUtils.findStudentsByCourse(allStudentList,course1);
        //System.out.println(collect);
        if (studentsByCourse.isPresent()){

        //studentsByCourse.get().forEach(System.out::println);
        }
        else{
            System.out.println("course given not present");
        }

        //Task 8: Functional Programming with Streams
        //- Implement a method to find the student with the highest number of courses enrolled using functional programming concepts with streams.

        Optional<Student> highestCourseEnrolled = RetrieveUtils.findHighestCourseEnrolled(allStudentList);
        System.out.println("-------------------");
       // System.out.println("student with highest amount of courses enrolled: "+highestCourseEnrolled);

        //Task 9: Grouping and Partitioning
          //      - Implement a method to group students by their age into separate lists using groupingBy.

        Map<Integer, Set<Student>> agecollect = RetrieveUtils.ageGroup(allStudentList);
        //System.out.println(agecollect);

        Map<String,Integer> employee_feat=new HashMap<>();
        employee_feat.put("John",5);
        employee_feat.put("Alice",10);
        employee_feat.put("Nicola",2);
        employee_feat.put("Giovanni",1);
        employee_feat.put("Arona",1);
        employee_feat.put("Cosimo",13);

        Optional<Map.Entry<String, Integer>> collect = employee_feat.entrySet().stream().collect(Collectors.maxBy(Comparator.comparing(Map.Entry::getValue)));
        //System.out.println(collect.get());

        //Task 10: Predicate Composition
        //- Implement a method to filter students based on multiple criteria (e.g., age and course enrollment) using predicate composition.


        List<Student> studentsAgeAndCourse = RetrieveUtils.ageandCoursePredicate(allStudentList, 22, course2);

       // System.out.println(studentsAgeAndCourse);

       // Task 11: Immutable Data Structures
         //       - Use an immutable data structure (e.g., `ImmutableList` from a third-party library) to store the courses enrolled by a student.

        List<List<Course>> coursesByStudent = RetrieveUtils.findCoursesByStudent(allStudentList, student4);
        //collect1.add(null);
        //System.out.println(coursesByStudent);

        //Task 17: Collectors
          //      - Implement a method to collect and return a map of courses and the number of students enrolled in each course using the `Collectors.groupingBy` and `Collectors.counting` collectors.


        //Map<List<Course>, Long> collect1 = allStudentList.stream().collect(Collectors.groupingBy(Student::getCourseEnrolled, Collectors.counting()));
        Map<Course, Long> numberOfEnrollmentOfCourses = RetrieveUtils.findNumberOfEnrollmentOfCourses(allStudentList);
        //numberOfEnrollmentOfCourses.entrySet().forEach(System.out::println);

        //Task 13: Method Parameter Reflection
           //     - Implement a method that uses method parameter reflection to print the names of method parameters dynamically.

        List<Parameter> methodParameters = null;
        try {
            methodParameters = RetrieveUtils.getMethodParameters(student1,"Student");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        //methodParameters.forEach((p)-> System.out.println("parameter type "+p.getType()+", parameter name "+p.getName()));
        //System.out.println(methodParameters);

        /*Task 14: Java 8 Annotations
                - Define a custom annotation `CourseInfo` that can be applied to the `Course` class to provide additional information (e.g., course description).
        - Implement a method that retrieves the course information using reflection on the `Course` class and the custom annotation.
*/
        String courseDescription =RetrieveUtils.getCoursesDescription();
        //System.out.println(courseDescription);



/*
        Task 15: Functional Interfaces and Lambda Expressions
                - Create a functional interface `StudentFilter` with a method `boolean test(Student student)` to perform custom filtering operations on students.
                - Implement a method that takes a `StudentFilter` implementation as a parameter and returns a filtered list of students based on the provided filter.*/

        StudentFilter studentFilter =(s)->s.getAge()>23;

        List<Student> filteredStudents = RetrieveUtils.getFilteredStudents(allStudentList, studentFilter);
        //filteredStudents.forEach(System.out::println);

        /*Task 16: File I/O and Streams
                - Implement methods to read student and course data from files using the File I/O API.
                - Use streams to process the data and populate the student and course objects accordingly.
*/
        String fname="/Users/gianlucamottola/IdeaProjects/JavaFirstSteps/Java8Training/src/com/practice/java8/studentManagementSystem/InputStudents";
        File inputStudents = new File(fname);
        String fname2="/Users/gianlucamottola/IdeaProjects/JavaFirstSteps/Java8Training/src/com/practice/java8/studentManagementSystem/InputCourses";


        List<Course> coursesFromFileApi = RetrieveUtils.getCoursesFromFileApi(fname2, idProvider);
        List<Student> studentsFromFileApi = RetrieveUtils.getStudentsFromFileApi(fname, idProvider, coursesFromFileApi);
        //coursesFromFileApi.forEach(System.out::println);
        //studentsFromFileApi.forEach(System.out::println);

        //Task 21: Stream FlatMap
        //- Implement a method to retrieve a list of all distinct courses enrolled by students using the `flatMap` operation.

        List<Course> collect1 = allStudentList.stream().flatMap(student -> student.getCourseEnrolled().stream()).distinct().collect(Collectors.toList());
        //System.out.println(collect1);

        //Task 22: Numeric Stream Operations
          //      - Implement a method to calculate and return the sum of ages of all students using numeric stream operations like `sum`, `max`, or `min`.

        int sum = studentsFromFileApi.stream().mapToInt(Student::getAge).sum();
        //System.out.println("sum of all ages : "+sum);

        //Task 28: Functional Programming with Streams
        //- Implement a method that returns the student with the highest number of courses enrolled, considering only students above a certain age, using functional programming concepts with streams.

        int thresholdAge=17;
        Optional<Student> collect2 = studentsFromFileApi.stream().filter(student -> student.getAge() > thresholdAge).collect(Collectors.maxBy(Comparator.comparing(s -> s.getCourseEnrolled().size())));

        //System.out.println(collect2);

        //Task 33: Stream Reduce Operation
        //- Implement a method to find and return the student(s) with the longest name using the stream `reduce` operation.

        Student studentLongestName = allStudentList.stream().reduce(student1, (stud1, stud2) -> stud1.getName().length() > stud2.getName().length() ? stud1 : stud2);
        System.out.println("student with longest name : "+ studentLongestName);

        //Task 27: Stream Short-Circuiting Operations
        //- Implement a method that checks if any student is enrolled in a specific course using short-circuiting operations like `anyMatch` or `findFirst`.

        Optional<Student> studentOptional = allStudentList.stream().filter(s -> s.getCourseEnrolled().contains(course7)).findFirst();
      /*  if(studentOptional.isPresent()) {
            System.out.println("student enrolled in the given course is present and is the following student : "+studentOptional.get());
        }
        else {
            System.out.println("no students enrolled in the mentioned course");
        }*/

        //Task 25: Default Methods in Interfaces
        //- Create an interface `CourseEnrollment` with a default method `List<Student> getEnrolledStudents()` that returns a list of students currently enrolled in the course.
        //- Make the `Course` class implement the `CourseEnrollment` interface.

        allCourseList.stream().forEach(
                course -> {
                    allStudentList.stream().forEach(
                            student -> {
                                if (student.getCourseEnrolled().contains(course)){
                                    course.getStudentList().add(student);
                                }
                            }
                    );

                }
        );
        System.out.println(course1.getStudentList());




    }
}
