package com.practice.java8.streams.statefulOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainExecutor {
    public static void main(String[] args) {

        Longsupplier longsupplierImplement= new LongSupplierImp();
        Employee employee1= new Employee(longsupplierImplement::supply,"Hashish",31,"Male");
        Employee employee2= new Employee(longsupplierImplement::supply,"luca",29,"Male");
        Employee employee3= new Employee(longsupplierImplement::supply,"john",28,"Male");
        Employee employee4= new Employee(longsupplierImplement::supply,"jake",27,"Male");
        Employee employee5= new Employee(longsupplierImplement::supply,"emily",26,"Female");
        Employee employee8= new Employee(longsupplierImplement::supply,"emily",26,"Female");
        Employee employee6= new Employee(longsupplierImplement::supply,"bridget",25,"Female");
        Employee employee9= new Employee(longsupplierImplement::supply,"bridget",25,"Female");
        Employee employee7= new Employee(longsupplierImplement::supply,"elena",24,"Female");
        Employee employee10= new Employee(longsupplierImplement::supply,"giorgia",24,"Female");
        Employee employee11= new Employee(longsupplierImplement::supply,"donna",28,"Female");
        Employee employee12= new Employee(longsupplierImplement::supply,"maria",44,"Female");
        Employee employee13= new Employee(longsupplierImplement::supply,"jessica",74,"Female");
        Employee employee14= new Employee(longsupplierImplement::supply,"giovanna",7,"Female");
        Employee employee15= new Employee(longsupplierImplement::supply,"antonia",78,"Female");
        Employee employee16= new Employee(longsupplierImplement::supply,"luisa",94,"Female");

        List<Employee> employeeList= Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8,employee9,employee10,employee11,
                employee12,
                employee13,employee14,employee15,employee16);

        employeeList.forEach(System.out::println);

        Stream<Employee> employeeFemaleStream = employeeList.stream().filter(employee -> employee.getGender() == "Female");
        Stream<Employee> distinct = employeeFemaleStream.distinct();
        System.out.println("----------------------------------");
        Stream<Employee> sort = distinct.sorted();
        Stream<Employee> skipAndLimit = sort.skip(3).limit(5);

        skipAndLimit.forEach(System.out::println)   ;
        System.out.println("----------------------------------");

        
    }
}
interface Longsupplier{
    long supply();
};
class LongSupplierImp implements Longsupplier{
    @Override
    public long supply() {
        return Math.abs(new Random().nextLong());
    }
};
