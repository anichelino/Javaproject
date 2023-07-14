package FunctionalInterfaces.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainExecutor {
    public static void main(String[] args) {
        Predicate<Student> studentPredicate= (student)->{
          if (student.getSchool()=="Technical Institute"){
              return true;
          }
          else{
              return false;
          }
        };

        List<Student> studentList= new ArrayList();
        List<School> studentListOnlySchoolsObjects= new ArrayList();
        Student s1= new Student("John","Doe","Technical Institute");
        Student s2= new Student("Jack","Campdell","Sport Institute");
        Student s3= new Student("Luke","Jae","Art Institute");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.removeIf(studentPredicate);


        for (Student student : studentList) {
            System.out.println(student);
        }


    }
}
