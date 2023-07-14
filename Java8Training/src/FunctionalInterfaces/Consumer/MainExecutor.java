package FunctionalInterfaces.Consumer;

import FunctionalInterfaces.Function.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainExecutor {
    public static void main(String[] args) {

        Consumer<Student> studentConsumer=(Student s)->{s.setName("verified " +s.getName());};
        List<Student> studentList= new ArrayList();
        Student s1= new FunctionalInterfaces.Function.Student("John","Doe","Technical Institute");
        Student s2= new FunctionalInterfaces.Function.Student("Jack","Campdell","Sport Institute");
        Student s3= new Student("Luke","Jae","Art Institute");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        for (Student student : studentList) {
            System.out.println(student);
        }

        for (Student student : studentList) {
            studentConsumer.accept(student);
        }
        for (Student student : studentList) {
            System.out.println(student);
        }


    }
}
