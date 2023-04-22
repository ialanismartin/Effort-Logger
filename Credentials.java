/*
 *Description: This holds the prototype of a log-in system.			
 * This is the only class for the prototype and it holds all of the
 * functions and features necessary for the log-in feature to function optimally.
 * 
 * <p> Title: LogIn Class </p>
* 
* <p> Description: This class serves as a Java implementation of how signing up and logging in
* should work and how it should allow or prevent certain inputs from being saved</p>
* 
* <p>This class is manually tested with specific test cases that are listed in the Phase 4 document 
* written by group W10 .</p>
* 
* @author Junayd Lateef
* ASU ID: 1221505571
* 
* @version 1.10	2023-04-06 
* 
* <p> This implementation aligns with our groups EffortLogger design because of how crucial security is
* for the customer. They want to prevent any hackers from stealing their information and employee's information.
* Our version of EffortLogger will start off with a log-in and sign-up screen that will take the inputed credentials
* and check them with the SQL data base. If the program is not secure, a hacker may be able to leak the information
* inside of the SQL database.</p>
 * 
 * <p> The results demonstrate the prototype demonstrate that the design goals have been satisfied because of
 * how specific inputs that hackers use to leak data are checked by other logic in the program to confirm that the
 * input is reasonable and will not leak any information. If the input is invalid then the program will display
 * the appropriate prompts. </p>
 * 
 * <p> In version 1.1, more functions have been added to the code to improve code
 * 		readability and organization for any to read. Along with that there were more characters that were
 * 		added to the invalid characters list to ensure further security and prevention of 
 * 		SQL injections.</p>
 */

//all necessary classes imported here
import java.io.*;
import java.util.*;

public class Credentials {
//rules for log-in system
/*
**********************************************************************************************************************
*Here are the rules to creating your credentials
*1)Both credentials should be 7-20 characters long. No more, no less
*2)Each credential should have a certain amount of digits. Usernames need one digits. Passwords need two digits.
*3)The characters '*', '&', '=', '%', '#', and '!' may not be used for security reasons.
**********************************************************************************************************************
*/
	
//main function is the log-in/sign-up/credentials check function
	
public static void Main(String[] args) {
	//create scanner so that way the suer can input their data
			Scanner input = new Scanner(System.in);
			
			//create Strings to hold the credentials
			String username = "";
			String password = "";
			
			//boolean is used to decide 
			boolean criteriaMet = false;
			
			//asks user to input their user name
			System.out.print("\n\nPlease enter a username: ");
				username: try {//first try section is used to check the username for any errors or exceptions
				username = input.nextLine(); //user inputs username
				
				//Next, we check the length to see if it matches the length criteria
				if(!lengthCheck(username)) {
					//if the username length does not fit the range then the program stops immediately
					//and informs the user of this
					System.out.println("\nThis username is not withing the appropriate length range.\nPlease choose another username.");
					break username; //exit early to save time and prevent any bugs
				}
				
				//next section checks if there is a specific amount of numbers in the 
				//if not enough digits are in the username then print out this prompt
				if(numCount(username) < 1) {
					System.out.println("\nThis username does not contain enough digits.\nPlease add more.");
					break username; //exit early to save time and prevent any bugs
				}
					
				//Lastly, check if there are any invalid characters used
				if(!invalidCheck(username)) {
					//print out the invalid username statement
					System.out.println("\nThis username contains invalid characters.\nUsername NOT accepted.");
					break username;//exit early to save time and prevent any bugs
				}
				
				//once all the criteria is met for the username
				System.out.print("Please enter a password: "); //asks to input password
				password: try {//have another try catch statement to check the password
					password = input.nextLine(); //user inputs password
					
					//similar to the username field check the length
					if(!lengthCheck(password)) {
						//if the password length does not fit the range then the program stops immediately
						//and informs the user of this
						System.out.println("\nThis password is not withing the appropriate length range.\nPlease choose another password.");
						break password; //exit early to save time and prevent any bugs
					}
						
					//next section checks if there is a specific amount of numbers in the 				
					//if not enough digits are in the password then print out this prompt
					if(numCount(password) < 2) {
						System.out.println("\nThis password does not contain enough digits.\nPlease add more.");
						break password;//exit early to save time and prevent any bugs
					}
					
					//Lastly, check if there are any invalid characters used
					if(!invalidCheck(password)) {
						//print out the invalid password statement
						System.out.println("\nThis password contains invalid characters.\nPassword NOT accepted.");
						break password;//exit early to save time and prevent any bugs
					}
					
					//if all the criteria is met then make sure to set the boolean as true
					//We can ensure that all criteria was met because it would have broken out of the try catch
					//statement if the criteria was not meet
					criteriaMet = true;
					
					//password catch block
					}catch(Exception e) {
						System.out.print("\nYour inputted password has caused an error.");
					}
				}catch(Exception e) {//username catch block
					System.out.print("\nYour inputted username has caused an error.");
				}
			
			//check if the username and password work
		if(criteriaMet) {
			//once all criteria is meet then the positive prompt is displayed
			System.out.print("\nYour credentials are strong and are considered VALID.\nGood job!"); 
			
			//repeat the same process only this time try to log-in
			System.out.print("\nNow that you have signed up, try to log-in.\n"); 
		}
				
			//boolean ends the loop once the user has logged in
			boolean logIn = false;
			
			//next strings will hold the log-in credentials
			String usernameLogIn = "";
			String passwordLogIn = "";
			
			//we should only go through the log-in phase if we have made a proper username and password
			while(!logIn && criteriaMet) {
				//print log in statement
				System.out.print("\nPlease enter your username: "); 
				
				usernameLog: try {//first try section is used to check the username for any errors or exceptions
					usernameLogIn = input.nextLine(); //user inputs username
					
					//Start off by checking the length of the string
					if(!lengthCheck(usernameLogIn)) {
						//if the username length does not fit the range then the program stops immediately
						//and informs the user of this
						System.out.println("\nINVALID USERNAME LENGTH.\nPlease Try Again");
						break usernameLog; //exit early to save time and prevent any bugs
					}
					
					//Next, check if there are any invalid characters so the program does not break
					if(!invalidCheck(usernameLogIn)) {
						//print out the invalid username statement
						System.out.println("\nINVALID USERNAME.\nPlease Try Again");
						break usernameLog;//exit early to save time and prevent any bugs
					}
					
					//Finally, check the password
					if(!usernameLogIn.equals(username)) {//if it does not match then allow user to try again
						System.out.println("\nI'm sorry but the username does not match.\nPlease Try Again");
						break usernameLog;//exit early to save time and prevent any bugs
					}
					
					//once all the criteria is met for the username
					System.out.print("Please enter your password: "); //asks to input password
					passwordLog: try {//have another try catch statement to check the password
						passwordLogIn = input.nextLine(); //user inputs password
						
						//Start off by checking the length of the string
						if(!lengthCheck(passwordLogIn)) {
							//if the username length does not fit the range then the program stops immediately
							//and informs the user of this
							System.out.println("\nINVALID PASSWORD LENGTH.\nPlease Try Again");
							break passwordLog; //exit early to save time and prevent any bugs
						}
						
						//Next, check if there are any invalid characters used so the program does not break
						if(!invalidCheck(passwordLogIn)) {
							//print out the invalid password statement
							System.out.println("\nINVALID PASSWORD.\nPlease Try Again");
							break passwordLog;//exit early to save time and prevent any bugs
						}
						
						//Finally, check the password
						if(!passwordLogIn.equals(password)) {//if it does not match then allow user to try again
							System.out.println("\nI'm sorry but the password does not match.\nPlease Try Again");
							break passwordLog;//exit early to save time and prevent any bugs
						}
						
						//if the logIn information matches then log-in
						logIn = true;
						
					}catch(Exception e) {
						System.out.print("\nYour inputted password has caused an error.");
					}
				}catch(Exception e) {
					System.out.print("\nYour inputted username has caused an error.");
				}
				
				//display logged-in message once logged in
				if(logIn) {
					System.out.print("\nYou have successfully logged-in.\nCongratulations!");
				}
			}
}

	
//helper functions for log-in system
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

public static boolean invalidCheck(String s) {
	if(s.contains("*") || s.contains("!") || s.contains("&") || s.contains("=") || s.contains("#") || s.contains("%")) {
		//if invalid characters exist the return false 
		return false;
	}//if no invalid characters exist then return true
	return true;
}

public static boolean lengthCheck(String s) {
	if(s.length() <= 6 || s.length() > 20) {
		//if the string length does not fit the range then return false
			return false;
		}
	//if character range fits then return true
		return true;
	}
}
