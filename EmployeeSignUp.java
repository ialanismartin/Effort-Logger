package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
	@FXML
	private Label errorMessageLabel;
	
	public EmployeeSignUp()
	{
		
	}
	//action handler for sign up button
	public void userSignUp(ActionEvent event) throws IOException
	{
		checkSignUp();
	}
	//this is where Junayd's prototype can be inputed 
	private boolean checkSignUp() throws IOException
	{
		
		errorMessageLabel.setMaxWidth(Double.MAX_VALUE);
		AnchorPane.setLeftAnchor(errorMessageLabel, 0.0);
		AnchorPane.setRightAnchor(errorMessageLabel, 0.0);
		errorMessageLabel.setAlignment(Pos.CENTER);
		
		
		String user = usernameTextField.getText();
		String pass = passwordTextField.getText();
		
		
		if(usernameTextField.getText().toString().isEmpty() || passwordTextField.getText().toString().isEmpty() || jobTitleTextField.getText().toString().isEmpty())
		{
			errorMessageLabel.setText("Please provide an input for all required fields.");
			return false;
		}
		
		if(!lengthCheck(user) || !lengthCheck(pass))
		{
			errorMessageLabel.setText("Incorrect length for credentials. Username and password must be 7-20 characters long!");
			return false;
		}
		
		else if(numCount(user) < 1 || numCount(pass) < 2)
		{
			errorMessageLabel.setText("Username must contain at least 2 digits and password must contain at least 1 digit!");
			return false;
		}
		else if(!invalidCheck(user) || !invalidCheck(pass))
		{
			errorMessageLabel.setText("Employee credentials cannot contain the following characters: '*', '&', '=', '%', '#', '!' ");
			return false;
		}
		else if(Database.db.findUser(user,pass))
		{
			errorMessageLabel.setText("Employee already exists. Please try again.");
		}
		else 
		{
			errorMessageLabel.setText("Success! New employee created.");
		}
		return true;
		
	}
	//action handler for settings button 
	public void managerMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("ManagerDashboard.fxml");
	}
}
