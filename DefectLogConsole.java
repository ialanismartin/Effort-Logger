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
import javafx.scene.control.TextField;

public class DefectLogConsole implements Initializable {
	Main m = new Main();
	@FXML 
	private ChoiceBox <String> projectBox;
	@FXML 
	private ChoiceBox <String> defectNameBox;
	@FXML 
	private ChoiceBox <String> injectionStepsBox;
	@FXML 
	private ChoiceBox <String> resolvedStepsBox;
	@FXML 
	private ChoiceBox <String> defectCategoryBox;
	@FXML 
	private ChoiceBox <String> statusBox;
	@FXML
	private Label titleLabel;
	@FXML
	private Label errorMessageLabel;
	@FXML
	private Label projectLabel;
	@FXML
	private Label defectNameLabel;
	@FXML
	private Label newDefectNameLabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label statusLabel;
	@FXML
	private Label injectionStepsLabel;
	@FXML
	private Label resolvedStepsLabel;
	@FXML
	private Label defectCategoryLabel;
	@FXML
	private Button deleteDefectBtn;
	@FXML
	private Button clearDefectsBtn;
	@FXML
	private Button updateDefectBtn;
	@FXML
	private Button defectLogBtn;
	@FXML
	private Button mainMenuBtn;
	@FXML
	private TextArea defectDescriptionTextArea;
	@FXML
	private TextField newDefectTextField;
	
	private String[] projects = {"Business", "Development"};
	
	private String[] businessLifeCycle = {"Planning", "Information Gathering", "Information Understanding", "Verifying", "Oulining", "Drafting",
			"Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
	
	private String[] developmentLifeCycle = {"Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review",
			"Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification",
			"Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update"};
	
	private String[] defectCategory = {"Not Specified", "10-Documentation", "20-Syntax", "30-Build Package", "40-Assignment", "50-Interface", 
			"60-Checking", "70-Data", "80-Function", "90-System", "100-Environment"};
	
	private String[] status = {"Resolved", "Unresolved"};
	private String project;
	private String defectName; 
	private String description;
	private String statusCheck;
	private String injectionStep ;
	private String resolvedStep ;
	private String category; 
	URL arg0;
	ResourceBundle arg1;
	
	//default constructor
	public DefectLogConsole()
	{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {   		//called behind the scenes to initialize controller after it's root element has been processed
		projectBox.getItems().addAll(projects);						//add options to project drop down
		projectBox.setOnAction(this::getProject);					//call action handler for project drop down
		defectCategoryBox.getItems().addAll(defectCategory);		//add options for defect category drop down
		statusBox.getItems().addAll(status);						//add options for status drop down
		defectNameBox.setOnAction(this::getDefects);				//call action listener to display defects
	}			
	
	//action handler for defects drop down
	public void getDefects(ActionEvent event)
	{
		//write code that extracts all previous defect names from database and displays it in drop down list
		//look at previous code to see how to add options to drop down list
	}
	
	//action handler for project drop down
	public void getProject(ActionEvent event)
	{
		project = projectBox.getValue();						//obtain value of project drop down
		
		if(project.equals("Business"))								//if project is business, add necessary life cycle steps
		{
			
			injectionStepsBox.getItems().clear();
			resolvedStepsBox.getItems().clear();
			statusBox.getItems().clear();
			defectCategoryBox.getItems().clear();
			statusBox.getItems().addAll(status);
			defectCategoryBox.getItems().addAll(defectCategory);
			injectionStepsBox.getItems().addAll(businessLifeCycle);
			resolvedStepsBox.getItems().addAll(businessLifeCycle);
		}
		else if(project.equals("Development"))					//add life cycle steps for development project
		{
			injectionStepsBox.getItems().clear();
			resolvedStepsBox.getItems().clear();
			statusBox.getItems().clear();
			defectCategoryBox.getItems().clear();
			statusBox.getItems().addAll(status);
			defectCategoryBox.getItems().addAll(defectCategory);
			injectionStepsBox.getItems().addAll(developmentLifeCycle);	
			resolvedStepsBox.getItems().addAll(developmentLifeCycle);	
		}
		
	}
	
	//action handler for make defect button; as of now it extracts all relevant info to be added to db; populate with code that adds info to db
	//**note: after adding new defect to db, make sure you immediately update defect name drop down to display this change; 
	public void makeDefectLog(ActionEvent event) throws IOException
	{
		if(newDefectTextField.getText().toString().isEmpty() && defectNameBox.getItems().isEmpty())
		{
			errorMessageLabel.setText("Please Specify Defect Name");
		}
		else 
		{
			errorMessageLabel.setText("");
			project = projectBox.getValue();
			defectName = newDefectTextField.getText();
			description = defectDescriptionTextArea.getText();
			statusCheck = statusBox.getValue();
			injectionStep = injectionStepsBox.getValue();
			resolvedStep = resolvedStepsBox.getValue();
			category = defectCategoryBox.getValue();
			
			clearDefectLog(event);
		}
	
	}
	
	//action handler for update defect button; as of now it extracts all relevant info to be updated in db; populate with code that updates info in db
	public void updateDefectLog(ActionEvent event) throws IOException
	{
		if(newDefectTextField.getText().toString().isEmpty() && defectNameBox.getItems().isEmpty())
		{
			errorMessageLabel.setText("Please Specify Defect Name");
		}
		else
		{
			errorMessageLabel.setText("");
			project = projectBox.getValue();
			defectName = defectNameBox.getValue();
			description = defectDescriptionTextArea.getText();
			statusCheck = statusBox.getValue();
			injectionStep = injectionStepsBox.getValue();
			resolvedStep = resolvedStepsBox.getValue();
			category = defectCategoryBox.getValue();
			
			clearDefectLog(event);
		}
		
	
	}
	
	//clear all choices 
	public void clearDefectLog(ActionEvent event) throws IOException
	{
		projectBox.getItems().clear();
		statusBox.getItems().clear();
		injectionStepsBox.getItems().clear();
		resolvedStepsBox.getItems().clear();
		defectCategoryBox.getItems().clear();
		defectNameBox.getItems().clear();
		defectDescriptionTextArea.clear();
		newDefectTextField.clear();
		
		initialize(arg0,arg1);
	}
	//action handler for delete defect button; add code to delete from db
	//**note: after deleting defect, make sure this is reflected in the existing defect names drop down entry drop down
	public void deleteDefectLog(ActionEvent event) throws IOException
	{
		if(newDefectTextField.getText().toString().isEmpty() && defectNameBox.getItems().isEmpty())
		{
			errorMessageLabel.setText("Please Specify Defect Name");
		}
		else
		{
			errorMessageLabel.setText("");
			defectName = defectNameBox.getValue();			//use this value to find defect in db and add code to delete it 
			
			clearDefectLog(event);
		}
		
		
	}
	//action handlers to change scenes
	public void defectLogScene(ActionEvent event) throws IOException
	{
		m.changeScene("DefectLog.fxml");
	}
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}
	
	
	
}
