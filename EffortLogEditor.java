package application;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class EffortLogEditor implements Initializable{
	
	Main m = new Main();
	@FXML 
	private ChoiceBox <String> projectBox;
	@FXML 
	private ChoiceBox <String> effortLogEntryBox;
	@FXML 
	private ChoiceBox <String> categoryBox;
	@FXML 
	private ChoiceBox <String> deliverableBox;
	@FXML 
	private ChoiceBox <String> lifeCycleBox;
	@FXML 
	private ChoiceBox <String> storyPointsBox;
	@FXML
	private Label titleLabel;
	@FXML
	private Label projectLabel;
	@FXML
	private Label lifeCycleStepLabel;
	@FXML
	private Label categoryLabel;
	@FXML
	private Label deliverableLabel;
	@FXML
	private Label storyPointsLabel;
	@FXML
	private Label userStoryLabel;
	@FXML
	private Label effortLogEntryLabel;
	@FXML
	private TextArea userStoryTextArea;
	@FXML
	private Button mainMenuBtn;
	@FXML
	private Button effortConsoleBtn;
	@FXML
	private Button effortLogBtn;
	@FXML
	private Button deleteEntryBtn;
	@FXML
	private Button updateEntryBtn;
	
	private String[] projects = {"Business", "Development"};
	
	private String[] businessLifeCycle = {"Planning", "Information Gathering", "Information Understanding", "Verifying", "Oulining", "Drafting",
			"Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
	
	private String[] developmentLifeCycle = {"Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review",
			"Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification",
			"Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update"};
	private String[] storyPoints = {"1","2","3","4","5","6","7","8","9","10"};
	
	private String project;
	private String lifeCycle;
	private String category;
	private String deliverable;
	private String userStory;
	private String points;
	private String effortEntryName;
	private Database db;
	URL arg0;
	ResourceBundle arg1;
	
	//added the database to the constructor - AK
	public EffortLogEditor(Database db)
	{
		this.db = db;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)    //called behind the scenes to initialize controller after it's root element has been processed
	{
		projectBox.getItems().clear();
		projectBox.getItems().addAll(projects);						//add options to project drop down
		projectBox.setOnAction(this::getProject);					//call action handler for project drop down
		storyPointsBox.getItems().addAll(storyPoints);				//add story point options
		
	}
	//action handler for project drop down
	public void getProject(ActionEvent event)
	{
		project = projectBox.getValue();						//obtain value of project drop down
		
		if(project.equals("Business"))								//if project is business, add necessary life cycle steps
		{
			lifeCycleBox.getItems().clear();
			lifeCycleBox.getItems().addAll(businessLifeCycle);
		}
		else if(project.equals("Development"))					//add life cycle steps for development project
		{
			lifeCycleBox.getItems().clear();
			lifeCycleBox.getItems().addAll(developmentLifeCycle);	
		}
		
		lifeCycleBox.setOnAction(this::getLifeCycle);			//call action handler for life cycle steps
	}
	public void getLifeCycle(ActionEvent event)
	{
		project = projectBox.getValue();
		lifeCycle = lifeCycleBox.getValue();
		
		switch(project)
		{
		case "Business":								//these are the life cycle steps for business projects 
			categoryBox.getItems().clear();							
			deliverableBox.getItems().clear();
			switch(lifeCycle)
			{
			//these are the categories for the life cycle and the associated deliverable that goes with them
			case "Planning":												
				categoryBox.getItems().add("Plans");						
				deliverableBox.getItems().add("Project Plan");				
				break;
			case "Drafting":
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Draft");
				break;
			case "Finalizing":
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Report");
				break;
			default:
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Conceptual Design");
				break;
			}
			break;
		case "Development":								//these are the life cycle steps for development projects
			categoryBox.getItems().clear();
			deliverableBox.getItems().clear();
			//these are the categories for the life cycle and the associated deliverable that goes with them
			switch(lifeCycle)
			{
			case "Conceptual Design Plan":
				categoryBox.getItems().add("Plan");
				deliverableBox.getItems().add("Conceptual Design Plan");
				break;
			case "Detailed Design Plan":
				categoryBox.getItems().add("Plan");
				deliverableBox.getItems().add("Detailed Design Plan");
				break;
			case "Implementation Plan":
				categoryBox.getItems().add("Plan");
				deliverableBox.getItems().add("Implementation Plan");
				break;
			case "Test Case Generation":
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Test Cases");
				break;
			case "Problem Understanding":
			case "Requirements":
			case "Conceptual Design":
			case "Conceptual Design Review":
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Conceptual Design");
				break;
			case "Detailed Design/Prototype":
			case "Detailed Design Review":
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Detailed Design");
				break;
			default:
				categoryBox.getItems().add("Deliverables");
				deliverableBox.getItems().add("Solution");
				break;
			}
			break;
		}
	}
	//clear all choices 
	public void clearEffortLog(ActionEvent event) throws IOException
	{
		projectBox.getItems().clear();
		effortLogEntryBox.getItems().clear();
		categoryBox.getItems().clear();
		deliverableBox.getItems().clear();
		lifeCycleBox.getItems().clear();
		storyPointsBox.getItems().clear();
		userStoryTextArea.clear();
		
		initialize(arg0,arg1);
	}
	
	//action handler for delete effort log button; add code to delete from db
	//**note: after deleting defect, make sure this is reflected in the effort log entry drop down
	public void deleteEntry(ActionEvent event) throws IOException
	{
			
		effortEntryName = effortLogEntryBox.getValue();			//use this value to find defect in db and add code to delete it 
		clearEffortLog(event);
			
	}
	
	//action handler for update effort log button;extracts all relevant info; add code to update effort log in db
	public void updateEntry(ActionEvent event) throws IOException
	{
		
		project = projectBox.getValue();
		effortEntryName = effortLogEntryBox.getValue();	
		category = categoryBox.getValue();
		deliverable = deliverableBox.getValue();
		lifeCycle = lifeCycleBox.getValue();
		points = storyPointsBox.getValue();
		userStory = userStoryTextArea.getText();
		clearEffortLog(event);
				
	}
	//action handlers to change scenes
	public void effortConsoleScene(ActionEvent event) throws IOException
	{
		m.changeScene("EffortLogConsole.fxml");
	}
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}
	public void effortLogScene(ActionEvent event) throws IOException
	{
		m.changeScene("EffortLog.fxml");
	}
	
}
