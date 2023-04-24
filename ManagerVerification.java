package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManagerVerification {

	Main m = new Main();
	@FXML
	private Button mainMenuBtn;
	@FXML
	Button enterBtn;
	@FXML
	private Label titleLabel;
	@FXML
	private Label outputMessageLabel;
	@FXML
	private Label promptLabel;
	@FXML
	private TextField managerKeyTextField;
	private ActionEvent event;
	private int count = 0;
	
	public ManagerVerification() 
	{
		
	}
	//action handler for enter button
	public void userEnter(ActionEvent event) throws IOException
	{
		checkVerificationKey();
	}
	
	//this method checks user credentials; needs to be updated to check user input with credentials already in db
	private void checkVerificationKey() throws IOException
	{
		Main m = new Main();
		

		if(managerKeyTextField.getText().toString().equals("rainbow"))
		{
			outputMessageLabel.setText("Success!");
			m.changeScene("ManagerDashboard.fxml");
		}
		else if(managerKeyTextField.getText().toString().isEmpty() )
		{
			outputMessageLabel.setText("Type in a key!");
		}
		else
		{
			if(count == 4)
			{
				mainMenuScene(event);
			}
			else
			{
				outputMessageLabel.setText("Incorrect key!");
				count++;
			}
			
		}
		
	}
	
	//action handler to change scenes
	public void mainMenuScene(ActionEvent event) throws IOException
	{
		m.changeScene("Dashboard.fxml");
	}
	
	
}
