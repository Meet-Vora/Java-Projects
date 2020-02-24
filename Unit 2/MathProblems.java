/* Meet Vora
   8-29-17
   MathProblems.java
   Get some practice declaring & initializing variables, 
   performing some calculations, and formatting output using 
   Format class amd the printf method. 
*/

public class MathProblems	//class header
{
	public static void main (String [] args)	//method header
	{
		System.out.print ("\n\n\n");
		
		double ans1 = -62.3;   	// declare and initialize variables
		ans1 = 5.6*17/3-49%11/2;
		System.out.print("1) 5.6*17/3-49%11/2 = ");
		System.out.printf("%-7.2f \n", ans1);
		System.out.println("1) 5.6*17/3-49%11/2 = " + Format.left(ans1, 7, 2));
		
		int ans2 = 15;		// declare and initialize variables
		ans2 = 16-17*(5%6/3);
		System.out.print("2) 16-17*(5%6/3) = ");
		System.out.printf("%-7s \n", ans2); 
		
		char ans3 = 'D';		// declare and initialize variables
		ans3 = (char)(56/2+17*3-9%9);
		System.out.println("3) (char)(56/2 + 17*3-9%9) = " + Format.left(ans3 + "", 7));		// adding + "" after ans3 to prevent it from being converted to an integer
		
		int ans4 = 56;		// declare and initialize variables
		ans4 = (int)((double)9/12*3-6.5);
		System.out.println("4) ((double)9/12*3-6.5) = " + Format.left(ans4 , 7));

		double ans5 = 45;		// declare and initialize variables
		ans5 = (int)('g') + (double)('2')/7;
		System.out.println("5) (int)('g') + (double)('2')/7 = " + Format.left(ans5, 7, 2));
		
		System.out.print ("\n\n\n");		


	}
}