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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TeamDefectLog implements Initializable{

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
	private Label projectLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label defectCategoryLabel;
	@FXML
	private Label statusLabel;
	@FXML
	private Label injectedLabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label removedLabel;
	@FXML
	private Label jobTitleLabel;
	@FXML
	private ChoiceBox <String> filterBox;
	@FXML
	private ListView<String> projectListView;
	@FXML
	private ListView<String> statusListView;
	@FXML
	private ListView<String> defectCategoryListView;
	@FXML
	private ListView<String> descriptionListView;
	@FXML
	private ListView<String> injectedListView;
	@FXML
	private ListView<String>removedListView;
	@FXML
	private ListView<String> nameListView;
	@FXML
	private ListView<String> jobTitleListView;
	@FXML
	private Button managerMenuBtn;
	@FXML
	private Button mainMenuBtn;
	
	public TeamDefectLog()
	{
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 		//called behind the scenes to initialize controller after it's root element has been processed
	{															//use this method to extract data from db and display it in table
	
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
