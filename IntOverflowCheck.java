package mainPackage;
import java.util.Scanner;

/*******
 * <p> Title: Integer Overflow Checker Class. </p>
 * 
 * <p> This class is designed to check the result of inputed arithmetic operations. This satisfies the design goal because it ensures
 * that any of the operations used to calculate effort in the Effort Logger program will not exceed the bounds of a 32 bit integer representation. 
 * If there is overflow/underflow detected, an exception is thrown and the program exits. Otherwise, result of operation is returned.</p>
 * 
 * @author Buthaina Alassafi
 * 
 * @version 1.00	2023-04-01 
 * 
 */
public class IntOverflowCheck {
	//method takes two integers and return their sum if no underflow/overflow occurs
	static int add(int num1, int num2) 
	{	
		 
		if (num2 > 0 && num1 > Integer.MAX_VALUE - num2) 	//checks if num2 is positive and if the sum of num1 and num2 exceeds 
															//the maximum value that an integer can represent.
		{
		    throw new ArithmeticException("Integer overflow");	//throw arithmetic exception for integer overflow
		}
		  
		else if(num2 < 0 && num1 < Integer.MIN_VALUE - num2) 	//checks if num2 is negative and if the sum of num1 and num2 is less 
																//than the minimum value that an integer can represent
		{
			throw new ArithmeticException("Integer underflow");
		}   
		
		return num1 + num2;					//overflow/underflow not detected, return result on operation
	}

	//method takes two integers and return their difference if no underflow/overflow occurs	 
	static int subtract(int num1, int num2) 
	{
		if (num2 > 0 && num1 < Integer.MIN_VALUE + num2)    //checks if num2 is positive and if the difference of num1 and num2 is less 
															//than the minimum value that an integer can represent
		{
		    throw new ArithmeticException("Integer overflow");
		}
		
		else if(num2 < 0 && num1 > Integer.MAX_VALUE + num2) //checks if num2 is negative and if the difference of num1 and num2 exceeds the maximum 
															 //value that an integer can represent
		{
			throw new ArithmeticException("Integer underflow");
		}   
		
		return num1 - num2;				//overflow/underflow not detected, return result on operation
	}
		 
	//method takes two integer arguments, num1 and num2, and returns their product.
	static int multiply(int num1, int num2) 
	{
		if(num2 == -1 && num1 == Integer.MIN_VALUE) //absolute value of Integer.MIN_VALUE is greater than that of Integer.MAX_VALUE, 
		{		    								//so negating the minimum value will not result in a number that can be represented by 32 bits
			throw new ArithmeticException("Integer overflow");  
		}
		
		else if(num2 > 0) 		//executed if num2 is positive
		{									
			if(num1 > Integer.MAX_VALUE/num2) 	//the product of num1 and num2 is greater than Integer.MAX_VALUE
			{		
				throw new ArithmeticException("Integer overflow");
			}
			else if(num1 < Integer.MIN_VALUE/num2) 		//the product of num1 and num2 is less than Integer.MIN_VALUE
			{	
				throw new ArithmeticException("Integer underflow");
			}
		}
		
		else 								//num2 is not positive
		{
			if(num1 > Integer.MIN_VALUE/num2) 			//product of num1 and num2 is greater than Integer.MIN_VALUE
			{
				throw new ArithmeticException("Integer underflow");
			}
			else if(num1 < Integer.MAX_VALUE/num2) 			//product of num1 and num2 is less than Integer.MAX_VALUE
			{
				throw new ArithmeticException("Integer overflow");
			}
		}
		
		return num1 * num2;				//overflow/underflow not detected, return result on operation
	}
	//method takes two integer parameters, num1 and num2
	static int divide(int num1, int num2) 
	{
		  if (num1 == Integer.MIN_VALUE && num2 == -1) 		//num1 is equal to Integer.MIN_VALUE and num2 is equal to -1; results in integer overflow because
			  												//abs value of Integer.MIN_VALUE is greater than the absolute value of Integer.MAX_VALUE
		  {
			  throw new ArithmeticException("Integer overflow");
		  }
		  
		  return num1 / num2;   //overflow/underflow not detected, return result on operation
	}
		 
	
}
