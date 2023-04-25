package application;


import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogIn {

	@FXML 
	private Button loginButton;
	@FXML
	private Label wrongLogIn;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label effortLog;
	
	public LogIn()
	{
		
	}
	
	public void userLogIn(ActionEvent event) throws IOException
	{
		checkLogin();
	}
	
	//this method checks user credentials; needs to be updated to check user input with credentials already in db
	private void checkLogin() throws IOException
	{
		Main m = new Main();
		if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty())//check if empty
		{
			wrongLogIn.setText("Please enter your credentials.");
		}
		else if(!lengthCheck(username.getText()) || !lengthCheck(password.getText())) //check length 
		{
			wrongLogIn.setText("Credentials must be 7-20 chars.");
		}else if(!invalidCheck(username.getText()) || !invalidCheck(password.getText())) //check if invalid
		{
			wrongLogIn.setText("Invalid chars detected.");
		}else if(username.getText().toString().equals("effortlogger") && password.getText().toString().equals("1234effort")) { //compare credentials
			wrongLogIn.setText("Success!");
			m.changeScene("Dashboard.fxml");
		}
		else
		{
			wrongLogIn.setText("Incorrect username or password!");
		}
	}
	
	//The following methods are used to check the code for any invalid inputs
	//checks for invalid characters
	public boolean invalidCheck(String s) {
		if(s.contains("*") || s.contains("!") || s.contains("&") || s.contains("=") || s.contains("#") || s.contains("%")) {
			//if invalid characters exist the return false 
			return false;
		}//if no invalid characters exist then return true
		return true;
	}

	//checks the length of the string so that way nothing suspicious is inputted
	public boolean lengthCheck(String s) {
		if(s.length() <= 6 || s.length() > 20) {
			//if the string length does not fit the range then return false
				return false;
			}
		//if character range fits then return true
			return true;
		}

}

