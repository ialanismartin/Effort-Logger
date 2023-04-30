package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class Definitions implements Initializable 
{
	Main m = new Main();
	
	ObservableList<String> projects = FXCollections.observableArrayList("Business","Development");
	
	ObservableList<String> lifeCycles = FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying", "Oulining", "Drafting",
			"Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting", "Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design", "Conceptual Design Review",
			"Detailed Design Plan", "Detailed Design/Prototype", "Detailed Design Review", "Implementation Plan", "Test Case Generation", "Solution Specification",
			"Solution Review", "Solution Implementation", "Unit/System Test", "Reflection", "Repository Update");
	
	ObservableList<String> effortCategory = FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects");
	
	ObservableList<String> plans = FXCollections.observableArrayList("Project","Risk Management","Conceptual Design","Detailed Design", "Implementation");
	ObservableList<String> deliverables = FXCollections.observableArrayList("Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", 
			"Outline","Draft", "Report", "User Defined");
	ObservableList<String> defectCategory = FXCollections.observableArrayList("Not Specified", "10-Documentation", "20-Syntax", "30-Build Package", "40-Assignment", "50-Interface", 
			"60-Checking", "70-Data", "80-Function", "90-System", "100-Environment");
	@FXML
	private ListView<String> projectListView;
	@FXML
	private ListView<String> lifeCycleListView;
	@FXML
	private ListView<String> effortCategoryListView;
	@FXML
	private ListView<String> plansListView;
	@FXML
	private ListView<String> deliverablesListView;
	@FXML
	private ListView<String> defectCategoryListView;
	@FXML
	private Label titleLabel;
	@FXML
	private Label projectLabel;
	@FXML
	private Label effortCategoryLabel;
	@FXML
	private Label plansLabel;
	@FXML
	private Label lifeCycleLabel;
	@FXML
	private Label deliverableLabel;
	@FXML
	private Label defectCategoryLabel;
	@FXML
	private Button mainMenuBtn;
	
	
	public Definitions()
	{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		projectListView.getItems().addAll(projects);
		lifeCycleListView.getItems().addAll(lifeCycles);;
		effortCategoryListView.getItems().addAll(effortCategory);
		plansListView.getItems().addAll(plans);
		deliverablesListView.getItems().addAll(deliverables);
		defectCategoryListView.getItems().addAll(defectCategory);
		
		projectListView.setEditable(false);
		lifeCycleListView.setEditable(false);
		effortCategoryListView.setEditable(false);
		plansListView.setEditable(false);
		deliverablesListView.setEditable(false);
		defectCategoryListView.setEditable(false);
		
		
	}
	
	//action handlers for buttons
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}

	
	
}
