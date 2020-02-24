/* Meet Vora
   8-29-17
   CalculatePi.java
   Apporximating Pi using two methods, and seeing how the original value of Pi
   is different from the approximations. We will be using printf and Format to format the output.
*/

public class CalculatePi	//class header
{
	public static void main (String [] args)	//method header
	{
		
	 System.out.print ("\n\n\n");

	 final double PI = 3.141592;	// Declaring and Initializing PI and making it a constant 
	 
	 double approx1;    //declare approx1 as a double
	 approx1 = 34;		//initialize approx1 as 34
	 double approx2;	// declare approx2 as a double
	 approx2 = 56;		//initialize approx2 as 56
	 
	 double diff1;		//declare diff1 as a double
	 diff1 = 23;		//initialize diff1 as 23
	 double diff2;		//declare diff2 as a double
	 diff2 = 87;		//initialize diff2 as 87
	 
	 
	 approx1 = 22.0/7;		//calculate 22/7, save answer as approx1
	 diff1 = PI - approx1;	// subtract approx1 from 3.141592

	 approx2 = (((4.0+100)*8 + 62000)/20000);		//calculate ((4+100)*8 + 62,000)/200,000
	 diff2 = PI - approx2;		// subtract approx2 from 3.141592
 
	 System.out.println("I am approximating pi (a bit more than 3.141592). \n");		// print first line of output
	 System.out.printf("The calculation 22/7 yields %4.2f " 
		+ "or more specifically %8.6f shown to 6 places.", approx1, approx1); 		// print approx1 to 2 and 6 decimals using printf
	 System.out.print(" It is " + Format.right(diff1, 8, 6) + " different from "
		+ Format.right(PI, 8, 6) + ".");		// Use Format to print diff1 and PI
	
	 System.out.println("\n");
	
	 System.out.printf("The calculation (4+100) x 8 + 62000 all divided by 20000 yields %4.2f " 
		+ "or more specifically %8.6f shown to 6 places.", approx2, approx2);		// print approx2 to 2 and 6 decimals using printf
 	 System.out.println(" It is " + Format.left(diff2, 8, 6) + " different from " 
		+ Format.center(PI, 8, 6) + ".");		// Use Format to print diff2 and PI

	 System.out.print ("\n\n\n");

	}
}