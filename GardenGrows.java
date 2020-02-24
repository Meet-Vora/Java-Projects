/** Meet Vora
1-28-18
GardenGrows.java
Description: Using JFrame and JPanel, painting a pink garden that turns green when "watered"
* and grows flowers when given sunlight. The garden resets when the space is pressed
Testing Plan: Run the program and make sure the garden begins as a pink rectangle
* and the top right corner is at (50,50) on the panel
* Try clicking in the panel and holding shift and typing '5'. The panel should turn green.
* Press the up arrow after clicking in the panel, and red circles should show.
* Try holding shift and pressing '5' or pressing the up key without clicking in the panel.
	The panel should not turn green and the red flowers should not pop up.
* Press space and the garden should revert back to its original pink state
* Make sure the flowers show by pressing the up arrow only after the garden turns green  
*/


import java.awt.Graphics;		// import graphics, JFrame, Color, and JPanel
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GardenGrows extends JFrame		// GardenGrows class header
{
	public GardenGrows()	// constructor() header
	{
		JFrame frame = new JFrame("My Garden");	// titles the frame "Masterpiece.java
		frame.setSize(1100,650);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// allows the user to close the frame
		Garden garden = new Garden();		// create instance of Panel class
		frame.getContentPane().add(garden);
		frame.setVisible(true);		// makes the frame visible
		frame.setLocation(100,100);	// Sets the coordinates of the frame
		frame.setResizable(false);	// does not allow the frame to be resized
	}
	
	public static void main (String []args)		// main() header
	{
		GardenGrows gg = new GardenGrows();		// creates instance of GarderGrows class
	}
}

class Garden extends JPanel implements MouseListener, KeyListener
{
	private Color color;
	private boolean drawGrass;
	private boolean shining;
	
	
	public Garden()
	{
		addMouseListener(this);
		addKeyListener(this);
		color = Color.GREEN;
		drawGrass = false;
		shining = false;
	}
		
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		// allows the background color to be applied
		
		g.setColor(Color.PINK);
		g.fillRect(50,50,1000,500);
		
		if (drawGrass)
		{
			g.setColor(Color.GREEN);
			g.fillRect(50,50,1000,500);
		
			if (shining)
			{
				for (int y = 50; y < 550; y+=200)
				{
					for (int x = 50; x < 1050; x+=200)
					{
						g.setColor(Color.RED);
						g.fillOval(x,y,50,50);
					}
				}
			}
		}
	}
	public void mousePressed(MouseEvent e){}
	
	public void mouseClicked(MouseEvent e)
	{
		requestFocusInWindow();
		repaint();
	}	
	
	public void mouseReleased(MouseEvent e){}		
	public void mouseEntered(MouseEvent e){}	
	public void mouseExited(MouseEvent e){}

	public void keyPressed(KeyEvent e)
	{
		
		if (e.getKeyChar() == '%')
			drawGrass = true;
			
		if (drawGrass && (e.getKeyCode() == KeyEvent.VK_UP))
			shining = true;
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shining = drawGrass = false;
	
		repaint();
		
	}

	public void keyTyped(KeyEvent e){}	
	public void keyReleased(KeyEvent e){}
}