package com.poised;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.poised.entity.Address;
import com.poised.entity.Person;
import com.poised.entity.Project;

public class Application {
    private static List<Project> projects;

    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to poised");
        projects = new ArrayList<>();
        showMenu();
        start();
    }

    private static void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                //create new project
                createProject(scanner);
                showMenu();
                start();
            case 2:
                //update project
                updateProject(scanner);
                showMenu();
                start();
            case 3:
                //finalise project
                finaliseProject(scanner);
                showMenu();
                start();
            case 4:
                //find incompleted project
                incompletedProject();
                showMenu();
                start();
            case 5:
                //show expiredProject
                expiredProject();
                showMenu();
                start();

            case 6:
                //find project by project number or name
                findProject(scanner);
                showMenu();
                start();
            case 9:
                break;

        }


        scanner.close();

    }

    private static void expiredProject() {
        System.out.println("printing expired project");
        //TODO

    }

    private static void incompletedProject() {
        System.out.println("printing incompleted project");
        //TODO

    }

    private static void finaliseProject(Scanner scanner) {
        System.out.println("Finalizing incomplete project");
        //TODO
    }

    private static void updateProject(Scanner scanner) {
        System.out.println("Updating project");
        //TODO

    }

    private static Project findProject(Scanner scanner) throws ParseException {


        System.out.println("Enter either the name or the number of the project");
        System.out.println("1 For finding project by name");
        System.out.println("2 For finding project by number");

        int userchoice= scanner.nextInt();

        switch (userchoice){

            case 1:
                Project projectFoundByName=findProjectByProjectName(scanner);
                System.out.println("Found project: ");
                System.out.println(projectFoundByName);
                System.out.println();
                return projectFoundByName;



            case 2:
                Project projectFoundByNumber=findProjectByProjectNumber(scanner);
                System.out.println("Found project: ");
                System.out.println(projectFoundByNumber);
                System.out.println();
                return projectFoundByNumber;

            default:
                start();
                return null;

        }

    }

    private static Project findProjectByProjectName(Scanner scanner) {
        System.out.println("Enter the name of the project");
        scanner.nextLine();
        String projectNameToFind = scanner.nextLine();
        for (Project project:projects) {
            if (project.getProjectName().equals(projectNameToFind)){
                return project;
            }
        }
        return null;
    }

    private static Project findProjectByProjectNumber(Scanner scanner) {
        System.out.println("Enter the number of the project");
        int projectNumberToFind = scanner.nextInt();
        for (Project project:projects) {
            if (project.getProjectNumber()==projectNumberToFind){
                return project;
            }
        }
        return null;
    }

    private static void createProject(Scanner scanner) throws ParseException {
        System.out.println("Enter project number");
        long projectNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter project name");
        String projectName = scanner.nextLine();
        System.out.println("Enter type of building");
        String buildingType = scanner.nextLine();

        System.out.println("Enter address of project");
        System.out.println("enter zipcode");
        int projectAddressZipcode = scanner.nextInt();
        System.out.println("enter city");
        scanner.nextLine();
        String projectAddressCity = scanner.nextLine();
        System.out.println("enter state");

        String projectAddressState = scanner.nextLine();
        System.out.println("enter address line");
        String projectAddressLine = scanner.nextLine();
        Address projectAddress = new Address(projectAddressZipcode, projectAddressCity, projectAddressState, projectAddressLine);

        System.out.println("Enter erf number");
        long erf = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter project total fee");
        double totalFees = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter total fees paid till date ");
        double totalFeetodate = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter deadline date in MM/dd/yyyy");
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = simpledateformat.parse(scanner.nextLine());
        System.out.println("Enter name of architect");
        String architectName = scanner.nextLine();
        System.out.println("Enter name of architect telephone number");
        String architectteleNumber = scanner.nextLine();
        System.out.println("Enter architect email");
        String architectEmail = scanner.nextLine();

        System.out.println("Enter address of architect");
        System.out.println("enter zipcode");
        int architectAddressZipcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter city");
        String architectAddressCity = scanner.nextLine();
        System.out.println("enter state");
        String architectAddressState = scanner.nextLine();
        System.out.println("enter address line");
        String architectAddressLine = scanner.nextLine();
        Address architectAddress = new Address(architectAddressZipcode, architectAddressCity, architectAddressState, architectAddressLine);
        Person architect = new Person(architectName, architectteleNumber, architectEmail, architectAddress);

        System.out.println("Enter name of contractor");
        String contractorName = scanner.nextLine();
        System.out.println("Enter name of contractor telephone number");
        String contractorteleNumber = scanner.nextLine();
        System.out.println("Enter contractor email");
        String contractorEmail = scanner.nextLine();

        System.out.println("Enter address of contractor");
        System.out.println("enter zipcode");
        int contractorZipcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter city");
        String contractorAddressCity = scanner.nextLine();
        System.out.println("enter state");
        String contractorAddressState = scanner.nextLine();
        System.out.println("enter address line");
        String contractorAddressLine = scanner.nextLine();
        Address contractorAddress = new Address(contractorZipcode, contractorAddressCity, contractorAddressState, contractorAddressLine);
        Person contractor = new Person(contractorName, contractorteleNumber, contractorEmail, contractorAddress);

        System.out.println("Enter name of customer");
        String customerName = scanner.nextLine();
        System.out.println("Enter name of customer telephone number");
        String customerteleNumber = scanner.nextLine();
        System.out.println("Enter customer email");
        String customerEmail = scanner.nextLine();

        System.out.println("Enter address of customer");
        System.out.println("enter zipcode");
        int customerZipcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter city");
        String customerAddressCity = scanner.nextLine();
        System.out.println("enter state");
        String customerAddressState = scanner.nextLine();
        System.out.println("enter address line");
        String customerAddressLine = scanner.nextLine();
        Address customerAddress = new Address(customerZipcode, customerAddressCity, customerAddressState, customerAddressLine);
        Person customer = new Person(customerName, customerteleNumber, customerEmail, customerAddress);
        Project project = new Project(projectNumber, projectName, buildingType, projectAddress, erf,
                totalFees, totalFeetodate, date, architect, contractor, customer);
        projects.add(project);
    }

    private static void showMenu() {
        System.out.println("1. Capture information about new projects");
        System.out.println("2. Update information about existing projects");
        System.out.println("3. Finalise existing projects");
        System.out.println("4. list of projects that still need to be completed");
        System.out.println("5. See a list of projects that are past the due date");
        System.out.println("6. Find and select a project");
        System.out.println("9. Exit");
    }

}
