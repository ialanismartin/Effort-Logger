//this file defines log objects- is super rudimentary for now

import java.util.*;


public class Log {
    public String title;
    boolean isEffort;  //if true, log is an effort log. if false, log is a defect log
    public int timeSpent;
    public int storyPoints;
    public String comments;
    Scanner scnr = new Scanner(System.in);

    public Log(){
        this.title = null;
        this.timeSpent = -1;
        this.storyPoints = -1;
        this.comments = null;
    }

    public Log(String title, int timeSpent, int storyPoints, String comments){
        this.title = title;
        this.timeSpent = timeSpent;
        this.storyPoints = storyPoints;
        this.comments = comments;
    }

    public Log createNewLog() {
        String projTitle, comments;
        int mins, strypts;

        Scanner scnr = new Scanner(System.in);

        System.out.println("You will now create a log.\n Enter project title: ");
        projTitle = scnr.nextLine();

        System.out.println("Please enter any comments: ");
        comments = scnr.nextLine();

        System.out.println("Enter the amount of time spent: ");
        mins = scnr.nextInt();

        System.out.println("Enter story point value of project: ");
        strypts = scnr.nextInt();


        scnr.close();

        //create the log
        Log employeeLog = new Log(projTitle, mins, strypts, comments);

        return employeeLog;
    }

    public Log editLog(String title, int timeSpent, int storyPoints, String comments){
        Log updatedLog = new Log(title, timeSpent, storyPoints, comments);
        return updatedLog;
    }

    public String toString(){
        String output = "Project Title: " + title + "     Minutes Spent: " + timeSpent + "      Story Points: " + storyPoints + "      Comments: " + comments + "\n" ;
        return output;
    }
}

