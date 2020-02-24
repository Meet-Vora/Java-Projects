/** Meet Vora
1-15-18
ReadWritePoem.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWritePoem
{
	private Scanner input;
	private PrintWriter output;
	private String inFileName;
	private String outFileName;
	
	public ReadWritePoem()
	{
		input = null;
		output = null;
		inFileName = "poem.txt";
		outFileName = "output.txt";
	}
	
	public static void main (String []args)
	{
		ReadWritePoem rwp = new ReadWritePoem();
		rwp.run();
	}
	
	public void run()
	{
		readIt();
		writeIt();
		getWords();
	}

	public void readIt()
	{
		File inFile = new File(inFileName);
		
		try
		{
			input = new Scanner (inFile);
		}
		
		catch(FileNotFoundException e)
		{
			System.err.printf("\n\nERROR: Cannot find/open file %s.\n\n", inFileName);
			System.exit(1);
		}
	}
	
	public void writeIt()
	{
		File outFile = new File(outFileName);
		try 
		{
			output = new PrintWriter(outFile);
		}
		
		catch(IOException e)
		{
			System.err.println("\n\nERROR: Cannot create "+ outFileName + " file.\n\n");
			System.exit(1);
		}
	}
	
	public void getWords()
	{
		System.out.println("\n\n\n");
		String word = "";
		
		while(input.hasNext())
		{
			word = input.next();
			input.nextLine();
			output.println(word);
		}
		
		output.close();
		input.close();		
	}
}