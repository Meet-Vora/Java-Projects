/** Meet Vora
2-6-18
Masterpiece.java
Description: Using graphics to draw a "masterpiece" on a JPanel with different shapes, fonts, and colors.
Testing Plan: Run the program multiple times to check that the output is consistent.
* Check if the shapes are in the right position (coordinates are correct).
* It should look like a compilation of shapes filled with different bright colors.
* The frame has a red rectangle near the top left corner, a blue octagon right under it, and a white line to the right of the rectangle.
* There should also be a yellow circle near the bottom middle of the frame, with a black arc and sector near it.
*/

import java.awt.Graphics;		// import graphics, JFrame, Color, and JPanel
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;

public class Masterpiece extends JFrame		// Masterpiece class header
{
	public Masterpiece()	// constructor() header
	{
		JFrame frame = new JFrame("My Masterpiece");	// titles the frame "Masterpiece.java
		frame.setSize(750,600);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows the user to close the frame
		Panel3 pan7 = new Panel3();		// create instance of Panel class
		frame.getContentPane().add(pan7);
		frame.setVisible(true);		// makes the frame visible
		frame.setLocation(500,300);	// Sets the coordinates of the frame
		frame.setResizable(false);	// does not allow the frame to be resized
	}
	
	public static void main (String []args)		// main() header
	{
		Masterpiece mp = new Masterpiece();		// creates instance of Masterpiece class
	}
}

class Panel3 extends JPanel		// class header
{
	public Panel3()
	{
		setBackground(Color.GREEN);	// sets the background color to green
	}
		
	public void paintComponent(Graphics g)		// paintComponent() header
	{
		Font coolfont = new Font("Serif", Font.BOLD + Font.ITALIC, 40);		// creates Serif font and bolds and italicizes it at size 40
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);	// sets the color of the font and string as white
		g.setFont(coolfont);	// calls the created font
		g.drawString("Hello", 20, 550);		// creates a string
		g.drawLine(200,150,450,150);	// draws a line with the given endpoints
		
		g.setColor(Color.RED);		// sets the color of the rectangle as red
		g.fillRect(100,100,100,250);	// fills the color of the rectangle as red
		
		int [] polygon1 = new int[]{100,50,50,100,150,200,200,150};		// sets the x coordinates of the polygon
		int [] polygon2 = new int[]{350,400,450,500,500,450,400,350};	// sets the y coordinates of the polygon
		g.setColor(Color.BLUE);	// sets the color of the polygon as blue
		g.fillPolygon(polygon1,polygon2,8);		// uses the x and y coordinates of the arrays with 8 sides of the polygon
		
		g.setColor(Color.ORANGE);	// sets the color of the circle as orange
		g.fillOval(300,450,100,100);	// creates a circle filled with color orange
		
		g.setColor(Color.BLACK);	// sets the color of the arc as yellow
		g.fillArc(500,250,200,150,45,90);	// fills the arc with color yellow
		g.drawArc(400,450,150,100,30,60);
	}
}