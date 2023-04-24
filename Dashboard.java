package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Dashboard {
	
	@FXML
	private Button effortConsoleBtn;
	@FXML
	private Button defectConsoleBtn;
	@FXML
	private Button effortLogEditorBtn;
	@FXML
	private Button effortLogBtn;
	@FXML
	private Button defectLogBtn;
	@FXML
	private Button managerBtn;
	@FXML
	private Button definitionsBtn;
	@FXML
	private Button logoutBtn;
	@FXML
	private Label mainMenuLabel;
	
	Main m = new Main();
	
	public Dashboard()
	{
		
	}
	
	public void effortConsoleScene(ActionEvent event) throws IOException
	{
		m.changeScene("EffortLogConsole.fxml");
	}
	
	public void defectConsoleScene(ActionEvent event) throws IOException
	{
		m.changeScene("DefectLogConsole.fxml");
	}
	public void effortLogEditorScene(ActionEvent event) throws IOException
	{
		m.changeScene("EffortLogEditor.fxml");
	}
	
	public void effortLogScene(ActionEvent event) throws IOException
	{
		m.changeScene("EffortLog.fxml");
	}
	
	public void defectLogScene(ActionEvent event) throws IOException
	{
		m.changeScene("DefectLog.fxml");
	}
	
	public void managerVerificationScene(ActionEvent event) throws IOException
	{
		m.changeScene("ManagerVerification.fxml");
	}
	
	public void definitionsScene(ActionEvent event) throws IOException
	{
		m.changeScene("Definitions.fxml");
	}
	
	
	public void userLogOut(ActionEvent event) throws IOException
	{
		m.changeScene("LogInScreen.fxml");
	}
	
	
}
