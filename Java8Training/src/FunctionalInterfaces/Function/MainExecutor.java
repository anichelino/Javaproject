package FunctionalInterfaces.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MainExecutor {
    public static void main(String[] args) {
        Function<Student,School> nameFunctionSchool = (Student student) -> new School(student.getSchool());

        List<Student> studentList= new ArrayList();
        List<School> studentListOnlySchoolsObjects= new ArrayList();
        Student s1= new Student("John","Doe","Technical Institute");
        Student s2= new Student("Jack","Campdell","Sport Institute");
        Student s3= new Student("Luke","Jae","Art Institute");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);


        for (Student student : studentList) {
            studentListOnlySchoolsObjects.add(nameFunctionSchool.apply(student));
        }

        for (School school : studentListOnlySchoolsObjects) {
            System.out.println(school);
        }

    }
}
