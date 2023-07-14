package FunctionalInterfaces.Consumer;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Student {
    private String name;
    private String surname;
    private String school;
    private Supplier<LocalDateTime> localDateTimeSupplier;

    public Student(String name, String surname, String school) {
        this.name = name;
        this.surname = surname;
        this.school = school;
        this.localDateTimeSupplier =()->LocalDateTime.now();
        System.out.println(this);
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", school='" + school + '\'' +
                ", enrolled at =" + localDateTimeSupplier.get() +
                '}';
    }
}
