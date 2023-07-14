package com.practice.java8.streams.statefulOperations;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Supplier;

public class Employee implements Comparable {

   private long id ;
    private String name;
    private int age;
    private String gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee(Supplier<Long> idsupplier, String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id= idsupplier.get();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name == employee.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {

        Employee e2= (Employee) o;
        if (this.getAge()>=e2.getAge()){
            return 1;
        }
        if (this.getAge()<e2.getAge()){
            return -1;
        }
        return 0;
    }
}
