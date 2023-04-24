package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Definitions 
{
	Main m = new Main();
	@FXML
	private Label titleLabel;
	@FXML
	private TableView projectTableView;
	@FXML
	private TableView lifeCycleTableView;
	@FXML
	private TableView effortCategoryTableView;
	@FXML
	private TableView plansTableView;
	@FXML
	private TableView deliverablesTableView;
	@FXML
	private TableView interruptionsTableView;
	@FXML
	private TableView defectCategoryTableView;
	@FXML
	private TableColumn projectColumn;
	@FXML
	private TableColumn lifeCycleColumn;
	@FXML
	private TableColumn effortCategoryColumn;
	@FXML
	private TableColumn planColumn;
	@FXML
	private TableColumn deliverableColumn;
	@FXML
	private TableColumn interruptionColumn;
	@FXML
	private TableColumn defectCategoryColumn;
	@FXML
	private Button mainMenuBtn;
	
	public Definitions()
	{
		
	}
	//action handlers for buttons
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}
	
}
