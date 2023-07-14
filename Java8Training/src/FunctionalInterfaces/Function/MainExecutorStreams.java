package FunctionalInterfaces.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MainExecutorStreams {
    public static void main(String[] args) {
        Function<Student,String> nameFunction = (Student student) -> student.getSchool();

        List<Student> studentList= new ArrayList();
        Student s1= new Student("John","Doe","Technical Institute");
        Student s2= new Student("Jack","Campdell","Sport Institute");
        Student s3= new Student("Luke","Jae","Art Institute");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        for (Student student : studentList) {
            System.out.println(student);
        }
        Stream<String> stringStream = studentList.stream().map(nameFunction);
        List<String> list = stringStream.toList();

        for (String studentSchool : list) {
            System.out.println(studentSchool);
        }
    }
}
