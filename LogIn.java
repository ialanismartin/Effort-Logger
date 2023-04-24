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
		if(username.getText().toString().equals("effort") && password.getText().toString().equals("123"))
		{
			wrongLogIn.setText("Success!");
			m.changeScene("Dashboard.fxml");
		}
		else if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty())
		{
			wrongLogIn.setText("Please enter your credentials.");
		}
		else
		{
			wrongLogIn.setText("Incorrect username or password!");
		}
		
	}
}

