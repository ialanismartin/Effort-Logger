//this class defines an Employee, which will be the primary object of the hashtable. The secondary object(s) are the logs
package database;
import java.util.*;

public class Employee {
    public String username, password;
    public String jobTitle;
    public List<EffortLogs> employeeEffortLogs; //pointer to a list of that employee's logs
    public List<DefectLogs> employeeDefectLogs;


    public Employee(){
        this.username = "";
        this.password = "";
        this.jobTitle = "";
        this.employeeEffortLogs = null; //pointer to a list of that employee's logs
        this.employeeDefectLogs = null;
       // this.employeesLogs = null;

    }

    //this constructor does not include inManager and EMployeesLogs fields
    public Employee(String username, String password, String jobTitle, List<EffortLogs> effortLogs, List<DefectLogs> defectLogs) {
        this.username = username;
        this.password = password;
        this.jobTitle = jobTitle;
        this.employeeEffortLogs = effortLogs;
        this.employeeDefectLogs = defectLogs;
    }

    public Employee editEmployee(String username, String password, String jobTitle, List<EffortLogs> effortLogs, List<DefectLogs> defectLogs) {
        Employee updatedEmployee = new Employee(username, password, jobTitle, effortLogs, defectLogs);
        return updatedEmployee;
    }
    

    
}
