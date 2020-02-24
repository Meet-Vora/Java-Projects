/* Meet Vora
   8-29-17
   SummerVacationFormatted.java
   A description of my summer vacation with a practice of formatting with 
   Format and printf. 
*/

public class SummerVacationFormatted	//class header
{
	public static void main (String [] args)	//method header
	{
		System.out.print ("\n\n\n");

		int ten;
		ten = 10;
		String str;
		str= "for four hours.";
		double trip;
		trip = 450.648;
		
		
		System.out.printf("This summer, I drove %-1.2f to LA to visit my cousins. While there, we: ", trip);
		System.out.print ("\n\n");
		System.out.println(Format.center("Went to my cousin's birthday party,",75));
		System.out.printf("%75s \n","Bought " + ten + " souvenirs, and ");
		System.out.println(Format.left("Went hiking " + str,75));
		System.out.println(Format.right("It was a great summer!",75));
		System.out.println();
		System.out.printf("I look forward to going to LA again! It should be a nice %-1.1f mile road trip!", trip);
			
		System.out.print ("\n\n\n");
	}
}