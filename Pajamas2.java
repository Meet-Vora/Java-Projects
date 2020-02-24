/** Meet Vora
1-9-18
Pajamas.java
Description: Creating pajamas and overlaying it with a pattern by creating a polygon to create the outline of the pajamas.
Testing Plan: Run the program multiple times to make sure the output is consistent.
* Make sure the pattern looks the same and repeats at regular intervals horizontally and vertically.
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JPanel;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Pajamas2 extends JFrame
{
	private Image image;
	private String pictName;
	
	public Pajamas2()	// constructor() header
	{
		JFrame frame = new JFrame("Me and My Pajamas");	// titles the frame "Masterpiece.java
		frame.setSize(700,700);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows the user to close the frame
		PanelPJ2 pan = new PanelPJ2();		// create instance of Panel class
		frame.getContentPane().add(pan);
		frame.setLocation(100,500);	// Sets the coordinates of the frame
		frame.setResizable(false);	// does not allow the frame to be resized\
		
		image = null;
		pictName = "PicOfMyself.jpg";
	
		getMyImage();
		frame.setVisible(true);		// makes the frame visible

	}
	
	public static void main (String []args)		// main() header
	{
		Pajamas2 pj2 = new Pajamas2();		// creates instance of Pajamas2 class
	}
	
	public void getMyImage() 
	{
		try
		{
			image = ImageIO.read(new File(pictName));
		}
		catch (IOException e)
		{
			System.err.println("\n\n" + pictName + " can't be found.\n\n");
			e.printStackTrace();
		}
	}


class PanelPJ2 extends JPanel
{
	public PanelPJ2()
	{
		setBackground(Color.BLUE);	// sets the background color as red
	}
		
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		// allows the background color to be applied
		
		g.setColor(Color.BLACK);
		
		
		 // use a loop to draw the shapes multiple times	
		 
		for(int x = 0; x <= getWidth(); x+=100)
		{
			for (int y = 0; y <= getHeight(); y+=100)
			{
				g.setColor(Color.WHITE);
				g.fillRect(x+10,y+45,40,40);
				g.setColor(Color.GREEN);
				g.fillRect(x+20,y+65,20,20);
				g.setColor(Color.RED);
				int[] tri1 = {x+10,x+30,x+50};
				int[] tri2 = {y+45,y+10,y+45};
				g.fillPolygon(tri1,tri2,3);
			}
		}	
		
		int[] backgroundpolyX = new int[]{350,350,700,700,0,0,350,350,300,200,75,150,200,200,500,500,550,625,500,400};
		int[] backgroundpolyY = new int[]{200,0,0,700,700,0,0,200,100,100,250,320,250,550,550,250,320,250,100,100};
		
		g.fillPolygon(backgroundpolyX,backgroundpolyY,20);
		
		g.drawImage(image,315,20,386,120,550,175,925,625,this);
	}
}
}