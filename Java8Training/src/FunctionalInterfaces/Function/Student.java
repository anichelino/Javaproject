package FunctionalInterfaces.Function;

public class Student {
    private String name;
    private String surname;
    private String school;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", school='" + school + '\'' +
                '}';
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

    public Student(String name, String surname, String school) {
        this.name = name;
        this.surname = surname;
        this.school = school;
    }
}
