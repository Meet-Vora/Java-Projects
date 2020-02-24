/** Meet Vora
1-23-18
Worksheet.java
Description: Prints a worksheet with numbers in a range entered by the user and prints them into a text file called "worksheet.txt"
Testing Plan: When prompted for a range, try entering integers in the range -100 to 100.
* Enter 0 and 5, -75, and 26, or -3 and 0, the program should print to "worksheet.txt"
* with addition and subtraction questions with numbers within the range
* Enter decimals (9.56), characters ('D'), and String ("Hi") and an error message should show saying InputMismatchException.
* Run a few times to check that the addition and subtraction is random. 
* Check that the answer key is correct for each question
*
*/

import java.io.File;		// import Scanner, File, FileNotFoundException, IOException, PrintWriter
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Worksheet// class header
{
	private Scanner kb;	// declare new Scanner and Printwriter as field variables
	private PrintWriter output;// declare field variable String worksheet
	private int[] numberOne;// declare 3 arrays, numberOne, numberTwo, and answers
	private int[] numberTwo;
	private int[] answers;
	private int upperLim;
	private int lowerLim;	// declare int lowerLim and upperLim field variables
	private String worksheet;
	
	public Worksheet()		// constructor header
	{
		answers = new int[20];
		kb = new Scanner(System.in);
		output = null;
		numberOne = new int[20];
		numberTwo = new int[20];
		answers = new int[20];
		lowerLim = 0;
		upperLim = 0;
		worksheet = "Worksheet.txt";
	}
	
	public static void main (String []args)		// main() method header
	{
		System.out.print("\n\n\n");

		Worksheet ws = new Worksheet();		// instance of class
		ws.run();	//call run
		
		System.out.print("\n\n\n");
	}
	
	public void run()		// run() method header
	{
		getRange();			// call getRange()
		generateNumbers();	// call generateNumbers() 
		formatWkSt();	// call formatWkSt()		
	}
	
	public void getRange()	// getRange() header
	{
		System.out.print("Enter an integer lower limit between -100 and 100 ->  ");		// prompt for lower and upper limit of range of numbers
		lowerLim = kb.nextInt();
		
		System.out.print("Enter an integer upper limit between -100 and 100 ->  ");
		upperLim = kb.nextInt();
	}
		
	public void	generateNumbers()	// generateNumbers() method header 

	{
		for (int x = 0; x <= answers.length-1; x++)		// generate 20 random ints with Math.random() in the entered range for the numberOne array
			numberOne[x] = (int)(Math.random()*(upperLim-lowerLim+1) + lowerLim);
		for (int k = 0; k <= answers.length-1; k++)		// generate 20 random ints with Math.random() in the entered range for the numberTwo array
			numberTwo[k] = (int)(Math.random()*(upperLim-lowerLim+1) + lowerLim);
	}
	
	public void formatWkSt()		// formatWkst() method header
	{
		File outFile = new File(worksheet);
		
		try 
		{
			output = new PrintWriter(outFile);
		}
		
		catch(IOException e)
		{
			System.err.println("ERROR: Cannot create "+ worksheet + " file.");
			System.exit(1);
		}
		
		output.printf("%140s\n", "Name______________________");
		output.printf("%140s\n", "Addition and subtraction practice using numbers "
			+ lowerLim + " to " + upperLim + " Date______________________");
		
		// format the questions in worksheet.txt
		int operator = 0;		// declare and initialize an int called operator
		int indexCounter = 0;		
		
		while (indexCounter <= answers.length-1)	// while loop for when counter counter is less than or equal to 19
		{
			output.printf("%-4s %-3d", (indexCounter+1) + ". ", numberOne[indexCounter]);
			operator = (int)(Math.random()*2);		// generate either a 0 or 1 with Math.random() and save it as value
			
			if (operator == 0)		// if else block
				output.print(" - ");			// if operator is equal to 0, print "-"
			else			// else print "+"
				output.print(" + ");
	
			output.printf("%-3d%-20s", numberTwo[indexCounter], "= ");
			calcAnswers(operator, indexCounter);

			if ((indexCounter+1)%4 == 0)
				output.println("\n");
					
			indexCounter++;
		}
		
		output.print("\n\n\n\n\nAnswer Key");
		
		int questionNum = 1;
		while (questionNum <= answers.length)
		{
			output.printf("%-4s %-20d", questionNum + ".", answers[questionNum-1]);
			
			if (questionNum%4 == 0)
				output.println("\n");
				
			questionNum++;
		}
		output.close();
	}
	
	public void calcAnswers(int inOperator, int counterIn)
	{
		if (inOperator == 0)
			answers[counterIn] = numberOne[counterIn] - numberTwo[counterIn];		// the answer at index counter is numberOne at counter minus numberTwo at counter
		else 
			answers[counterIn] = numberOne[counterIn] + numberTwo[counterIn];		// the answer at index counter is numberOne at counter plus numberTwo at counter
	}
}

		
	
	
		
		


		// call calcAnswers() and send parameter operator and counter
	
	
	// calcAnswers(inValue)
	// if-else block for if value is 0\
		// the answer at index cunter is numberOne at counter minus numberTwo at counter
	// else
		// the answer at index counter is numberOne at counter plus numberTwo at counter 