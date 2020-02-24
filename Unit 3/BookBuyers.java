/* Meet Vora
   9-12-17
   BookBuyers.java
   This program accepts an input from the user for the price of textbooks, 
   then prints the cost of each of the types of textbooks, the subtotal, the discount, the total before tax, tax,
   and the final price of all the books. The program also prints the output formatted in a column for the 
   ease of reading for the user.
   Testing plan: 
   should work: double, positive int, and float will work as input.
   should not work: characters, boolean, string input will not work. If entered, error message InputMismatchException will show.
*/

import java.util.Scanner;		//import Scanner class

public class BookBuyers	//class header
{ 
	public static void main (String [] args)	//method header
	{
	
	Scanner price = new Scanner(System.in);		// Create Scanner Instance
	
	System.out.print ("\n\n\n");

	double calculus = -3.0;		// declare and initialize variable calculus as a double
	double english = -5.0;		// declare and initialize variable english as a double
	double history = -7.0;		// declare and initialize variable history as a double

	System.out.println("Enter the prices of each textbook");
	
	System.out.print("Calculus book: $  ");	// Prompt user to enter price of calculus book
	calculus = price.nextDouble();				// Read user's double price of calculus books
	
	System.out.print("English book: $ ");		// Prompt user to enter price of english book
	english = price.nextDouble();				// Read user's double price of english books

	System.out.print("History book: $  ");		// Prompt user to enter price of history book
	history = price.nextDouble();				// Read user's double price of history books

	System.out.print("\n");

	double calculusTotal = -4.0;	// declare and initialize variable calculusTotal as a double
	calculusTotal = 2*calculus;		// total cost of calculus books that are needed to be bought
	double englishTotal = -6.0;		// declare and initialize variable englishTotal as a double
	englishTotal = 10*english;		// total cost of english books that are needed to be bought
	double historyTotal = -8.0;		// declare and initialize variable historyTotal as a double
	historyTotal = 4*history;		// Number of history books that are needed to be bought
	
	
	double subtotal = -9.0;		// declare and initialize variable subtotal as a double
	subtotal = calculusTotal + englishTotal + historyTotal;		// 
	final double DISCOUNT = 0.10;
	double discount = -10.0;		// declare and initialize variable discount as a double
	discount = DISCOUNT * subtotal;
	double totalBeforeTax = -11.0;		// declare and initialize variable totalBeforeTax as a double
	totalBeforeTax = subtotal - discount;
	final double TAX = 0.0925;	
	double tax = -12.0;		// declare and initialize variable tax as a double
	tax = TAX * totalBeforeTax;
	double grandTotal = -13.0;			// declare and initialize variable grandTotal as a double
	grandTotal = totalBeforeTax + tax;
	
	System.out.printf("%-20s", "Calculus books");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", calculusTotal);		// prints Calculus book price formatted to 2 decimal places

	System.out.printf("%-20s", "English books");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", englishTotal);		// prints English books prices formatted to 2 decimal places

	System.out.printf("%-20s", "History books");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", historyTotal);		// prints History books prices formatted to 2 decimal places
	
	System.out.printf("%-20s", "Subtotal");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", subtotal);		// prints subtotal formatted to 2 decimal places

	System.out.printf("%-20s", "Discount");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", discount);		// prints discount formatted to 2 decimal places
	
	System.out.printf("%-20s", "Total Before Tax");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", totalBeforeTax);		// prints the total before tax formatted to 2 decimal places
	
	System.out.printf("%-20s", "Tax");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n", tax);		// prints tax formatted to 2 decimal places
	
	System.out.printf("%-20s", "Grand Total");
	System.out.printf("%4s", "=  $");
	System.out.printf("%,10.2f\n\n", grandTotal);		// prints Grand Total formatted to 2 decimal places
	
	System.out.printf("The total cost for 16 books is $%,.2f. Thank you for shopping with BooksRUs.com.", grandTotal);		
	
	System.out.print ("\n\n\n");
	}
}