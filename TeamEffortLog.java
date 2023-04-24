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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TeamEffortLog implements Initializable{

	Main m = new Main();
	@FXML
	private Label searchLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label filterLabel;
	@FXML
	TextField searchTextField;
	@FXML
	private ChoiceBox <String> filterBox;
	@FXML
	private TableView teamEffortLogTable;
	@FXML
	private TableColumn jobTitleColumn;
	@FXML
	private TableColumn projectColumn;
	@FXML
	private TableColumn lifeCycleColumn;
	@FXML
	private TableColumn categoryColumn;
	@FXML
	private TableColumn deliverableColumn;
	@FXML
	private TableColumn storyPointsColumn;
	@FXML
	private TableColumn userStoryColumn;
	@FXML
	private Button managerMenuBtn;
	@FXML
	private Button mainMenuBtn;
	
	public TeamEffortLog()
	{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		//called behind the scenes to initialize controller after it's root element has been processed
																//use this method to extract data from db and display it in table
		
	}
	
	//action handler to change scenes
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}
	public void managerMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("ManagerDashboard.fxml");
	}
}
