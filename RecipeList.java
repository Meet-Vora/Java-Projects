/** Meet Vora
1-29-18
RecipeList.java
Description:
Testing Plan: 
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class RecipeList
{
	private Scanner kb;
	private Scanner staplesFile;
	private Scanner recipeFile;
	private PrintWriter shoppingList;
	private String staplesFileName;
	private String recipeFileName;
	private String shoppingListName;
	private String userInput;
	private String[]ingredients;
	private String[]dishes;
	private String findDish;

	public RecipeList()
	{
		kb = new Scanner(System.in);
		staplesFile = null;
		recipeFile = null;
		shoppingList = null;
		staplesFileName = "Staples.txt";
		recipeFileName = "Recipe.txt";
		shoppingListName = "ShoppingList.txt";
		userInput = "";
		ingredients = new String[11];
		dishes = new String[11];
		findDish = "";
	}

	public static void main (String[]args)
	{
		RecipeList rl = new RecipeList();
		rl.run();
	}

	public void run()
	{
		printStaples();
		readRecipe();
		getInput();
	}

	public void readRecipe()
	{
		File inFile2 = new File(recipeFileName);

		try
		{
			recipeFile = new Scanner(inFile2);
		}

		catch (FileNotFoundException e)
		{
			System.err.println("Cannot open " + recipeFileName);
			System.exit(1);
		}

		int indexCounter = -1;

		while(recipeFile.hasNext())
		{
			String line = recipeFile.nextLine();

        		if (line.length()> 7 && line.substring(0, 7).equals("Recipe:"))
			{
               			indexCounter++;
	          		dishes[indexCounter]=line.substring((line.indexOf(" ")+1),line.indexOf(" - "));
			}	

			else if (line.length()> 13 && line.substring(0, 12).equals("Ingredients:"))
			{
				String ingredientList = "";
				String checkLine = "";
					
				checkLine = recipeFile.nextLine();
		
				while (checkLine.indexOf("Directions:") == -1)
				{             
					ingredientList = ingredientList +"\n"+checkLine;
					checkLine = recipeFile.nextLine();
				}
	
				ingredients[indexCounter] = ingredientList;
      			}
		}
	}

	public void printStaples()
	{
		File inFile = new File (staplesFileName);
		
		try
		{
			staplesFile = new Scanner(inFile);
		}

		catch (FileNotFoundException e)
		{
			System.err.println("Cannot open " + staplesFileName);
			System.exit(2);
		}
	
		File outFile = new File(shoppingListName);
		
		try
		{
			shoppingList = new PrintWriter(new FileWriter(outFile,true))
		}

		catch(IOException e)
		{
			System.err.println("Cannot append to "+shoppingListName);
			System.exit(3);
		}

		while (staplesFile.hasNext())
		{
			shoppingList.println(staplesFile.nextLine());
		}

		shoppingList.print("\n");

	}

	public void getInput()
	{
		System.out.println("Enter a list of dishes to be cooked (pressing enter after each dish) and enter \"quit\" when you're done:");

		userInput = kb.nextLine();

		while (!userInput.equalsIgnoreCase("quit"))
		{	
			int myRecipeIndex = -1;
            		myRecipeIndex = getRecipe();

            		if (myRecipeIndex >= 0)
				printRecipe(myRecipeIndex);

            		else
			{
				if (!userInput.equals(""))
				shoppingList.println(userInput+" (1)");
			}
		}
		
		userInput = kb.nextLine();

		staplesFile.close();
		recipeFile.close();
		shoppingList.close();

	}

	public int getRecipe()
	{
		int indexOfDish = 0;
		boolean foundDish = false;

		while(indexOfDish <= dishes.length-1 && !foundDish)
		{
			if (userInput.equalsIgnoreCase(dishes[indexOfDish]))
			{
				findDish = dishes[indexOfDish];
				foundDish = true;
			}

			else
				indexOfDish++;

		}

		if (foundDish == true)
			return indexOfDish;

		else
			return -1;
	}

	public void printRecipe(int dishNumber)
	{
		shoppingList.println(ingredients[dishNumber]);
	}
}

