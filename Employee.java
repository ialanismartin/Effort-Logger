//this class defines an Employee, which will be the primary object of the hashtable. The secondary object(s) are the logs

import java.util.*;
/*
 * METHODS
 * constructor
 * createNewEmployee()
 * 
 * to_String()
 */

import javax.security.sasl.SaslException;

public class Employee {
    public String firstName, lastName;
    public int id;
    public double salary;
    public String techPosition;


    public Employee(){
        this.firstName = null;
        this.lastName = null;
        this.id = -1;
        this.salary = -1.0;
        this.techPosition = null;
    }
    public Employee(String firstName, String lastName, String techPosition, int id, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.salary = salary;
        this.techPosition = techPosition;
    }

    
    public Employee createNewEmployee(){
        String firstName, lastName, position;
        int id;
        double salary;
        
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter your first name:");
        firstName = scnr.nextLine();

        System.out.println("Please enter your last name:");
        lastName = scnr.nextLine();

    
        System.out.println("Please enter your position title:");
        position = scnr.nextLine();
        
        System.out.println("Please enter your salary:");
        salary = scnr.nextDouble();

        System.out.println("Please enter your id:");
        id = scnr.nextInt();

        //create the employee
        Employee newEmployee = new Employee(firstName, lastName, position, id, salary);

        return newEmployee;

    }

    public Employee editEmployee(String firstName, String lastName, String techPosition, int id, double salary) {
        Employee updatedEmployee = new Employee(firstName, lastName, techPosition, id, salary);
        return updatedEmployee;
    }

    public String toString() {
        return firstName + " " + lastName + " ~ " + techPosition ;
    }
}
