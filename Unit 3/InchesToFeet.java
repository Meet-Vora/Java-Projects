/* Meet Vora
   9-8-17
   InchesToFeet.java
   This program converts user input of inches to feet formatted to do decimal places.
   Testing plan: 
*/

import java.util.Scanner;		//import Scanner class

public class InchesToFeet	//class header
{
	public static void main (String [] args)	//method header
	{
		
	System.out.print ("\n\n\n");
	
	Scanner measure = new Scanner(System.in);		// Create Scanner Instance

	System.out.println("Please enter the number of inches you would like to convert to feet: ");	// Prompt user for input inches
	int inches = -5;		// initialize inches as an integer
	inches = measure.nextDouble();		// Read user's int inches
	double feet = -4.0;		// Initialize feet as a double
	feet = inches/12.0;		// Divide number of inches by 12 to convert to feet
	
	System.out.printf(inches + " is equivalent to %.2f feet.\n", feet);		// Print feet as output, formatted to 2 decimal places
	
	System.out.print ("\n\n\n");
	
	}
}

	