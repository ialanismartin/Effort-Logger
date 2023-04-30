package database;
import java.util.*;

public class Database {
    //attributes
    HashMap<Employee, List<Log>> EffortLoggerdatabase;
    int numOfEmployees;
    String loggedUser;


    public Database() {
        EffortLoggerdatabase = new HashMap<Employee, List<Log>>();
        numOfEmployees = 0;
    }
    
    //ok so create an employee object outside of this method and then put the employee/empty log list into database
    public void signUp(Employee newEmployee, List<Log> employeesLogs) {
        employeesLogs = null; // employee starts off with empty list of logs
        EffortLoggerdatabase.put(newEmployee, employeesLogs);
        numOfEmployees++;
    }
    
    //method finds the effort log list of a given employee - returns null if no such employee exists -AK
    public List<EffortLogs> findEmployeeEffortLogList(Employee employee)
    {
    	if (employee != null)
    	{
    		for (Map.Entry<Employee, List<Log>> employeeElement : EffortLoggerdatabase.entrySet()) { 
    			 
                if (employeeElement.getKey().username == employee.username)
                {
                	return employeeElement.getKey().employeeEffortLogs; //finding the correct employee's list of effort logs
                	
                }
        	}
    	}
    	return null;
    }
    
    // this search method returns an effort log that lines up with a specific log name (not employee name, the name of the log entry) -AK
    // used in deleteEffort() method
    public EffortLogs findEffortLog(Employee employee, String logName)
    {
    	List<EffortLogs> findLogList = findEmployeeEffortLogList(employee);
    	
    	if (findLogList != null)
    	{
    		for (EffortLogs log : findLogList)
    		{
    			if (log.returnName() == logName)
    			{
    				return log;
    			}
    		}
    		return null; //if there is are no logs with the logName that we want, returns null
    	}
    	return null; //if there is no employee with the username we want, returns null
    }
    
    
    
    //finds the index in the EffortLog list of an effort log that lines up with a specific logName -AK
    public int findEffortLogIndex(Employee employee, String logName)
    {
    	int index = 0;
    	List<EffortLogs> findLogList = findEmployeeEffortLogList(employee);
    	if (findLogList != null)
    	{
    		while (index < findLogList.size() && findLogList.get(index).returnName() != logName)
    		{
    			index++;
    		}
    		if (findLogList.get(index).returnName() == logName) //if while loop gets to last element, but that element isnt the one we want
    		{
    			return index;
    		}
    		else
    		{
    			return -1;
    		}
    		
    	}

    	return -1;
    }
    
    // creating the filter function in the effort log console - AK
    // this just filters out the effort log entries that we want to display in the GUI and places them in an array list
    public ArrayList<EffortLogs> filterDatabase(Employee employee, String lifecycleStep)
    {
    	ArrayList<EffortLogs> filterArray = new ArrayList<EffortLogs>(); //array of all the logs that have the correct lifecycle step
    	List<EffortLogs> findLogList = findEmployeeEffortLogList(employee); //getting the correct employee's list of logs
    	if (findLogList != null)
    	{
    		for (EffortLogs log : findLogList)
    		{
    			if (log.returnLifeCycleStep() == lifecycleStep)
    			{
    				filterArray.add(log);
    			}
    		}
    		if (filterArray.size() > 0)
    		{
    			return filterArray;
    		}
    		    	}
    	return null; //if find list or filterArray is empty, returns null
    }
    
    //creating the search function in the effort log console - AK
    //this just filters out the effort log entries that we want to display in the GUI and places them in an array list
    public ArrayList<EffortLogs> searchDatabase(Employee employee, String keyWord)
    {
    	ArrayList<EffortLogs> searchArray = new ArrayList<EffortLogs>(); //array of all the logs that have the correct lifecycle step
    	List<EffortLogs> findLogList = findEmployeeEffortLogList(employee); //getting the correct employee's list of logs
    	if (findLogList != null)
    	{
    		for (EffortLogs log : findLogList)
    		{
    			if (log.returnUserStoryComments().contains(keyWord))
    			{
    				searchArray.add(log);
    			}
    		}
    		if (searchArray.size() > 0)
    		{
    			return searchArray;
    		}
    		
    	}
    	return null; //if findLogList or searchArray is empty, returns null
    }
    
    //averages all the story points in a given list of effort logs - can implement integer overflow checks here -AK
    public double getStoryPointAverage(List<EffortLogs> effortList)
    {
    	double average = 0;
    	int sum = 0;
 
    	if (effortList != null && effortList.size() > 0)
    	{
    		for (EffortLogs log : effortList)
    		{
    			sum += log.returnStoryPoints();
    		}
    		average = (double)(sum) / (double)effortList.size();
    	}
    	return average;
    }
    
    //returns a String array of names ->used in the effort log editor drop down -AK
    //need to figure out what to do if there are no entries in the effort log list
    public String[] getLogNames(Employee employee)
    {
    	String[] logNameArray = null;
    	List<EffortLogs> findLogList = findEmployeeEffortLogList(employee);
    	if (findLogList != null)
    	{
    		logNameArray = new String[findLogList.size()];
    		for (int i = 0; i < findLogList.size(); i++)
    		{
    			logNameArray[i] = findLogList.get(i).returnName();
    		}
    	}
    	return logNameArray;
    }
    
    //finds the index of the log that needs to be edited and replaces the old log with an edited version -AK
    public void editEffortLog(Employee employee, String logName, String projTitle, String lifeCycle, String category, String deliverable, String userStory, int storyPoints)
    {
    	int index = findEffortLogIndex(employee, logName);
    	if (index != 1)
    	{
    		List<EffortLogs> findLogList = findEmployeeEffortLogList(employee);
    		EffortLogs newLog = EffortLogs.editLog(logName, projTitle, lifeCycle, category, deliverable, userStory, storyPoints);
    		findLogList.set(index, newLog);
    		//i didnt change the List<Log> cuz i dont think that changes anything -AK
    	}
    }
    
    //method deletes an effort log entry from an employee's effortlog list -AK
    //logName is the name of the log we want to delete
    public void deleteEffort(Employee employee, String logName)
    {
    	List<EffortLogs> findLogList = findEmployeeEffortLogList(employee);
    	if (findLogList != null)
    	{
    		EffortLogs deleteLog = findEffortLog(employee, logName);//gets the specific log we want to delete
    		if (deleteLog != null)
    		{
    			findLogList.remove(deleteLog);
    		}
    	}
    }
    
    //Vincent could work on this
    public void deleteDefect(String projTitle, String defectName, String category, String defectDescription,
            String status) {
        // idk
    }
    

    // these two functions add an effort/defect log to an employee's list of logs
    public void addEffortLog(Employee anEmployee, EffortLogs eLog) {
        anEmployee.employeeEffortLogs.add(eLog);

        // add it to the overall list of general logs
        List<Log> empLogList = EffortLoggerdatabase.get(anEmployee); // retrieve an employee's associated value
        if(empLogList == null) {
            empLogList = new ArrayList<Log>(); // create a new list if it doesn't exist yet
        }
        empLogList.add(eLog); // add the log to the list that is ^ the associated value

        // update the Database with the new value 
        EffortLoggerdatabase.put(anEmployee, empLogList); // update the hashmap with the new list
    }

    public void addDefectLog(Employee anEmployee, DefectLogs dLog) {
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
                for (EffortLogs eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnProjectTitle());
                }
            }
        }
    }

    public void returnIndvLifeCycleSteps(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername){
                for (EffortLogs eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnLifeCycleStep());
                }
            }
        }
    }

    public void returnIndvCategories(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLogs eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnCategory());
                }
            }
        }
    }

    public void returnIndvDeliverables(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLogs eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnDeliverable());
                }
            }
        }
    }

    public void returnIndvStoryPoints(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (EffortLogs eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnStoryPoints());
                }
            }
        }
    }

    public void returnIndvUserStories(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername){
                for (EffortLogs eff : e.employeeEffortLogs) {
                    System.out.println(eff.returnUserStoryComments());
                }
            }
        }
    }

    // these are the TEAM retrievals
    public void returnAllProjectTitles() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLogs eff : e.employeeEffortLogs) {
                System.out.println(eff.returnProjectTitle());
            }
        }
    }

    public void returnAllLifeCycleSteps() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLogs eff : e.employeeEffortLogs) {
                System.out.println(eff.returnLifeCycleStep());
            }
        }
    }

    public void returnAllCategories() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLogs eff : e.employeeEffortLogs) {
                System.out.println(eff.returnCategory());
            }
        }
    }

    public void returnAllDeliverables() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLogs eff : e.employeeEffortLogs) {
                System.out.println(eff.returnDeliverable());
            }
        }
    }

    public void returnAllStoryPoints() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLogs eff : e.employeeEffortLogs) {
                System.out.println(eff.returnStoryPoints());
            }
        }
    }

    public void returnAllUserStories() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (EffortLogs eff : e.employeeEffortLogs) {
                System.out.println(eff.returnUserStoryComments());
            }
        }
    }


    // DEFECT LOG METHODS

    // INDIVIDUAL retrievals
    public void returnIndvProjectTitlesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnProjectTitle());
                }
            }
        }
    }

    public void returnIndvDefectNamesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnDefectName());
                }
            }
        }
    }

    public void returnIndvDefectDescriptionsD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnDefectDescription());
                }
            }
        }
    }

    public void returnIndvStatusesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnStatus());
                }
            }
        }
    }

    public void returnIndvInjectionsD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnStepInjected());
                }
            }
        }
    }

    public void returnIndvResolutionsD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnStepResolved());
                }
            }
        }
    }

    public void returnIndvDefectCategoriesD(String employeeUsername) {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            if (e.username == employeeUsername) {
                for (DefectLogs def : e.employeeDefectLogs) {
                    System.out.println(def.returnCategory());
                }
            }
        }
    }

    // TEAM view retrivals
    public void returnAllProjectTitlesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnProjectTitle());
            }
        }
    }

    public void returnAllDefectNamesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnDefectName());
            }
        }
    }

    public void returnAllDefectDescriptionsD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnDefectDescription());
            }
        }
    }

    public void returnAllStatusesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnStatus());
            }
        }
    }

    public void returnAllInjectionsD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnStepInjected());
            }
        }
    }

    public void returnAllResolutionsD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnStepInjected());
            }
        }
    }

    public void returnAllDefectCategoriesD() {
        for (Employee e : EffortLoggerdatabase.keySet()) {
            for (DefectLogs def : e.employeeDefectLogs) {
                System.out.println(def.returnCategory());
            }
        }
    }


}