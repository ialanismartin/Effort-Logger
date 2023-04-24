package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeeSignUp {
	
	Main m = new Main();
	@FXML
	private Button signUpBtn;
	@FXML
	private Button managerMenuBtn;
	@FXML
	private Label titleLabel;
	@FXML
	private Label jobTitleLabel;
	@FXML
	private Label usernameLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private TextField jobTitleTextField;
	
	public EmployeeSignUp()
	{
		
	}
	//action handler for sign up button
	public void userSignUp(ActionEvent event) throws IOException
	{
		checkSignUp();
	}
	//this is where Junayd's prototype can be inputed 
	private void checkSignUp() throws IOException
	{
		
	}
	//action handler for settings button 
	public void managerMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("ManagerDashboard.fxml");
	}
}
