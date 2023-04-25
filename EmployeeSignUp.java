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
		/*
		 * Pseudocode for sign up
		 * 
		 * if(checkSignUp){ //if the credentials are good
		 * 	//add the user in here
		 * }
		 * 
		 */
	}
	
	//this is where Junayd's prototype can be inputed
	//This method uses all of the helper methods to determine if the inputs are valid
	private boolean checkSignUp() throws IOException
	{
		String user = usernameTextField.getText();
		String pass = usernameTextField.getText();
		
		if(!lengthCheck(user) || !lengthCheck(pass)) {//checks for length of the input
			return false;
		}else if(numCount(user) < 1 || numCount(pass) < 2) {//checks numbers of the input
			return false;
		}else if(!invalidCheck(user) || !invalidCheck(pass)) {//checks if there are any invalid characters
			return false;
		}else {
			return true;
		}
		
	}
	//action handler for settings button 
	public void managerMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("ManagerDashboard.fxml");
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
		
		//used to check the number of integers in the string
		public static int numCount(String s) {
			int numInts = 0; //records number of ints in the string
			
			//for loop is used to search through the entire string
			for(int i = 0; i < s.length(); i++) {
				if(Character.isDigit(s.charAt(i))) { //checks if current char is a number
					numInts++; //increments digit count
				}
			}
			return numInts; //return number of integers
		  }
}
