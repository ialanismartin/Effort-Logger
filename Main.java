
/*******
 * <p> Title: Main- this serves as the main class for testing the database for Effort Logger </p>
 * 
 * <p> Description: These classes set up the grounds for the employee/log database for the new EffortLogger. The database will consist of a HashMap data structure, which
 * will map an employee as a key and an arraylist of log objects for its value. A hashtable data structure was attempted to be written by scratch, but that idea has been 
 * SCRATCHED. Java utilities offers a HashMap data carrier, which is what we will be using. Hence version 2.0.  </p>
 * 
 * @author Karen Garcia
 * 
 * @version 2.00	2023-04-09
 * 
 */

import java.time.format.TextStyle;
import java.util.*;

/* 
 * Functionalities to add:
 * -make logs editable
 * -make funtions for pressed-on buttons
 * -sanitize log display
 * -implement types of log: effort vs defect
 * -organize output by feature (team, planning poker, etc)
 * -change employee so that it points to a list of Log objects
 * 
 * 
 * METHODS that we will probably need:
 * returnAllEmployeeLogs()
 * returnSomeEmployeeLogs() //for accessing specifc logs, may need to be split up into several methods for specialization
 * returnEmployeeEffortLogs()
 * returnEmployeeDefectLogs()
 * editLog()
 * editEmployee() //may not be necessary
 * 
 * 
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the Database Test\n");

        /* 
        START of test
        //this is a little test "try-out" with the objects for this project: hashmap, employee, and logs. 
        //define all components and try printing them out to the console. Use to Reference

        //define two employees, one with i/o and one manually
        String firstName, firstName1 = "Lola";
        String lastName, lastName1 = "Avelar";
        int id, id1 = 12345;
        double salary, salary1 = 182000.00;
        String position, position1= "Project Manager";

        //create the manual employee
        Employee lola = new Employee(firstName1, lastName1, id1, salary1, position1);


        //create a dummy log
        Log log1 = new Log("U.F.O.", 115, 3, "n/a");
        Log log2 = new Log("Virtual Cell", 135, 4, "took long");

        //create a list of logs, then add the dummy log within
        List<Log> lolasLogs = new ArrayList<Log>();
        lolasLogs.add(log1);
        lolasLogs.add(log2);

        //create the hashMap that serves as the EffortLoggerDatabase
        HashMap<Employee, List<Log>> EffortLoggerDatabase = new HashMap<Employee, List<Log>>();

        //try adding the employee and log into the hashMap
        EffortLoggerDatabase.put(lola, lolasLogs);

        //print out the contents of the HashMap
        for (Employee e: EffortLoggerDatabase.keySet()){       
            System.out.println(e.toString());                   //print each employee
            for (Log l : lolasLogs){
                System.out.println(l);                          //print that employee's logs
            }
        }
        
        END OF TEST
        */

        //create the hashMap that serves as the EffortLoggerDatabase
        HashMap<Employee, List<Log>> EffortLoggerDatabase = new HashMap<Employee, List<Log>>();

        //create an employee from the console
        Employee anEmployee = new Employee();
        anEmployee = anEmployee.createNewEmployee();

        //create a log with console;
        List<Log> anEmployeesLogs = new ArrayList<>();
        Log emptyLog = new Log();
        anEmployeesLogs.add(emptyLog.createNewLog());


        //add that log to that employee and place in db. will need to create 
        EffortLoggerDatabase.put(anEmployee, anEmployeesLogs);   //also exists: putIfAbsent() if want to check existence

        EffortLoggerDatabase.entrySet();

        System.out.println("are we here yet");

        for (Employee e : EffortLoggerDatabase.keySet()){
            System.out.println(e.toString());
            for (Log l : anEmployeesLogs){
                System.out.println(l.toString());
            }
        }
    
        
    }

    

    

}
