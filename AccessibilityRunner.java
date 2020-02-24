/** Meet Vora
1-28-18
AccessibilityRunner.java
Description: 
Testing Plan: 
*/
// JPanel class: Accessibility
// import each class needed

import java.awt.Graphics;		// import graphics, JFrame, Color, and JPanel
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class AccessibilityRunner extends JFrame		// AccessibilityRunner class header
{
	public AccessibilityRunner()	// constructor() header
	{
		JFrame frame = new JFrame("Accessibility Runner");	// titles the frame "Masterpiece.java
		frame.setSize(1000,800);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows the user to close the frame
		Accessibility access = new Accessibility();		// create instance of Panel class
		frame.getContentPane().add(access);
		frame.setVisible(true);		// makes the frame visible
		frame.setLocation(0,0);	// Sets the coordinates of the frame
		frame.setResizable(false);	// does not allow the frame to be resized
	}
	
	public static void main (String []args)		// main() header
	{
		AccessibilityRunner ar = new AccessibilityRunner();		// creates instance of AccessibilityRunner class
	}
}

class Accessibility extends JPanel implements MouseListener, KeyListener
{	
	private Color backgroundColor;
	private int fontSize; 
	private int colorNum;
	
	public Accessibility()						//add listeners as appropriate
	{
		addKeyListener(this);
		addMouseListener(this);
		colorNum = 100;
		backgroundColor = new Color(100,100,100);
		fontSize = 12;
	}
	
	public void drawRectanglesWithLabels(Graphics g)    		 	//This method is complete
	{
		g.setColor(Color.RED);
		g.fillRect(10,10,100,20);
		g.fillRect(115,10,100,20);
		g.setColor(Color.BLACK);
		g.drawString("brighter",15,80);
		g.drawString("darker", 115, 80);
	}
	
	public void medicalPageContent(Graphics g){ }  /*Assume this method is complete. */
	
	public void paintComponent(Graphics g)
	{
		setBackground(backgroundColor);
		super.paintComponent(g);							//draw background color
		drawRectanglesWithLabels(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif", Font.PLAIN, fontSize));
		medicalPageContent(g);
	}
	
	public void keyPressed(KeyEvent e)			//fill in blank	
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			fontSize += 5;
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			fontSize -= 5;
		}
		
		setFont(new Font("Serif", Font.PLAIN, fontSize));
		repaint();
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}


	public void mousePressed(MouseEvent e)
	{							
		requestFocusInWindow();
		repaint();
	}
	
	public void mouseClicked(MouseEvent e)
	{	
		if (colorNum < 255 && colorNum > 34)
		{
			int xPos = e.getX();
			int yPos = e.getY();
			
			if (xPos >= 10 && xPos <= 110 && yPos >= 10 && yPos <= 30)
				colorNum += 3;
			else if (xPos >= 115 && xPos <= 215 && yPos >= 10 && yPos <= 30)
				colorNum -= 3;
			
			backgroundColor = new Color(colorNum,colorNum,colorNum);
			repaint();
		}
	}
	
	public void mouseReleased(MouseEvent e){} 		//This method is complete.
	public void mouseEntered(MouseEvent e){}		//This method is complete.
	public void mouseExited(MouseEvent e){}			//This method is complete.
}