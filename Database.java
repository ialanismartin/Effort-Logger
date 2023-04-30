package database;
import java.util.*;

public class Database {
    //attributes
    HashMap<Employee, List<Log>> EffortLoggerdatabase;
    int numOfEmployees;
    String loggedUser;



    //methods
    public Database() {
        EffortLoggerdatabase = new HashMap<Employee, List<Log>>();
        numOfEmployees = 0;
    }
    
    //ok so create an employee object outside of this method and then put the employee/empty log list into database -AK
    public void signUp(Employee newEmployee, List<Log> employeesLogs) {
        employeesLogs = null; // employee starts off with empty list of logs
        EffortLoggerdatabase.put(newEmployee, employeesLogs);
        numOfEmployees++;
    }
    
    //adding a search method - AK
    public EffortLog searchEffortLog(Employee employee, String findName)
    {
    	return null; //just for now -AK
    }
    
    public void deleteEffortLog(Employee employee, String name)
    {
    	EffortLog deleteLog = searchEffortLog(name);
    	//still need to implement
    }

    // these two functions add an effort/defect log to an employee's list of logs
    public void addEffortLog(Employee anEmployee, EffortLog eLog) {
        anEmployee.employeeEffortLogs.add(eLog);

        // add it to the overall list of general logs
        List<Log> empLogList = EffortLoggerdatabase.get(anEmployee); // retrieve an employee's associated value
        if(empLogList == null) {
            empLogList = new ArrayList<Log>(); // create a new list if it doesn't exist yet
        }
        empLogList.add(eLog); // add the log to the list that is ^ the associated value

        // update the Database with the new value 
        //we dont need to do this because empLogList is a reference to the log list - it will automatically update - AK
        EffortLoggerdatabase.put(anEmployee, empLogList); // update the hashmap with the new list
    }

    public void addDefectLog(Employee anEmployee, DefectLog dLog) {
        anEmployee.employeeDefectLogs.add(dLog);

        // add it to the overall list of general logs
        List<Log> empLogList = EffortLoggerdatabase.get(anEmployee); // retrieve an employee's associated value
        if(empLogList == null) {
            empLogList = new ArrayList<Log>(); // create a new list if it doesn't exist yet
        }
        empLogList.add(dLog); // add the log to the list that is ^ the associated value
        //update the Database with the new value
        EffortLoggerdatabase.put(anEmployee, empLogList); // update the hashmap with the new list
    }
    
    
    // EFFORT LOG METHODS

    // these will be the INDIVIDUAL retrievals going column by column
    public void returnIndvProjectTitles(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLog eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnProjectTitle());
                }
            }
        }
    }

    public void returnIndvLifeCycleSteps(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername){
                for (EffortLog eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnLifeCycleStep());
                }
            }
        }
    }

    public void returnIndvCategories(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLog eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnCategory());
                }
            }
        }
    }

    public void returnIndvDeliverables(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLog eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnDeliverable());
                }
            }
        }
    }

    public void returnIndvStoryPoints(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLog eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnStoryPoints());
                }
            }
        }
    }

    public void returnIndvUserStories(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername){
                for (EffortLog eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnUserStoryComments());
                }
            }
        }
    }

    // these are the TEAM retrievals
    public void returnAllProjectTitles() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLog eff : e.employeeEffortLogs) {
                System.out.println(eff.returnProjectTitle());
            }
        }
    }

    public void returnAllLifeCycleSteps() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLog eff : e.employeeEffortLogs) {
                System.out.println(eff.returnLifeCycleStep());
            }
        }
    }

    public void returnAllCategories() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLog eff : e.employeeEffortLogs) {
                System.out.println(eff.returnCategory());
            }
        }
    }

    public void returnAllDeliverables() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLog eff : e.employeeEffortLogs) {
                System.out.println(eff.returnDeliverable());
            }
        }
    }

    public void returnAllStoryPoints() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLog eff : e.employeeEffortLogs) {
                System.out.println(eff.returnStoryPoints());
            }
        }
    }

    public void returnAllUserStories() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLog eff : e.employeeEffortLogs) {
                System.out.println(eff.returnUserStoryComments());
            }
        }
    }

    public void deleteEffort(String projTitle, String lifeCycle, String category, String deliverable) {
        // idk
    }

    // DEFECT LOG METHODS

    // INDIVIDUAL retrievals
    public void returnIndvProjectTitlesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnProjectTitle());
                }
            }
        }
    }

    public void returnIndvDefectNamesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnDefectName());
                }
            }
        }
    }

    public void returnIndvDefectDescriptionsD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnDefectDescription());
                }
            }
        }
    }

    public void returnIndvStatusesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnStatus());
                }
            }
        }
    }

    public void returnIndvInjectionsD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnStepInjected());
                }
            }
        }
    }

    public void returnIndvResolutionsD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnStepResolved());
                }
            }
        }
    }

    public void returnIndvDefectCategoriesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLog def : e.employeeDefectLogs) {
                    System.out.println(def.returnCategory());
                }
            }
        }
    }

    // TEAM view retrivals
    public void returnAllProjectTitlesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnProjectTitle());
            }
        }
    }

    public void returnAllDefectNamesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnDefectName());
            }
        }
    }

    public void returnAllDefectDescriptionsD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnDefectDescription());
            }
        }
    }

    public void returnAllStatusesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnStatus());
            }
        }
    }

    public void returnAllInjectionsD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnStepInjected());
            }
        }
    }

    public void returnAllResolutionsD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnStepInjected());
            }
        }
    }

    public void returnAllDefectCategoriesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLog def : e.employeeDefectLogs) {
                System.out.println(def.returnCategory());
            }
        }
    }

    public void deleteDefect(String projTitle, String defectName, String category, String defectDescription,
            String status) {
        // idk
    }

}