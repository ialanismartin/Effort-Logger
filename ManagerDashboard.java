package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ManagerDashboard {

	Main m = new Main();
	@FXML
	private Button employeeSignUpBtn;
	@FXML
	private Button teamEffortLogBtn;
	@FXML
	private Button teamDefectLogBtn;
	@FXML
	private Button mainMenuBtn;
	@FXML
	private Label titleLabel;
	
	public ManagerDashboard()
	{
		
	}
	
	
	//action handlers to change scenes
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}

	public void teamEffortLogScene(ActionEvent event) throws IOException
	{
		m.changeScene("TeamEffortLog.fxml");
	}

	public void teamDefectLogScene(ActionEvent event) throws IOException
	{
		m.changeScene("TeamDefectLog.fxml");
	}

	public void employeeSignUpScene(ActionEvent event) throws IOException
	{
		m.changeScene("EmployeeSignUp.fxml");
	}
}
