//this class defines an Employee, which will be the primary object of the hashtable. The secondary object(s) are the logs
package database;
import java.util.*;

public class Employee {
    public String username, password;
    public String jobTitle;
    public List<EffortLog> employeeEffortLogs; //pointer to a list of that employee's logs
    public List<DefectLog> employeeDefectLogs;


    public Employee(){
        this.username = null;
        this.password = null;
        this.jobTitle = null;
       // this.employeesLogs = null;

    }

    //this constructor does not include inManager and EMployeesLogs fields
    public Employee(String username, String password, String jobTitle, List<EffortLog> effortLogs, List<DefectLog> defectLogs) {
        this.username = username;
        this.password = password;
        this.jobTitle = jobTitle;
        this.employeeEffortLogs = effortLogs;
        this.employeeDefectLogs = defectLogs;
    }

    public Employee editEmployee(String username, String password, String jobTitle, List<EffortLog> effortLogs, List<DefectLog> defectLogs) {
        Employee updatedEmployee = new Employee(username, password, jobTitle, effortLogs, defectLogs);
        return updatedEmployee;
    }

    
}
