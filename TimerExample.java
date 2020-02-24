// Conlin
// Date:
// TimerExample.java
// This program demonstrates a simple timer animation with a bouncing ball.

import java.awt.Color;		
import java.awt.Graphics;
import java.awt.Font;

import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;	
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;	
import java.awt.event.KeyEvent;
		
import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.Timer;


public class TimerExample 
{
	public TimerExample()
	{
	}	
	
	public static void main (String[] args) 
	{
		TimerExample te = new TimerExample();
		te.run();
	}
	
	public void run() 
	{
		JFrame frame = new JFrame("Timer Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel and add to frame
		
		DrawPanel panel = new DrawPanel();
		frame.getContentPane().add(panel);	// add panel to frame
				
		frame.setSize(500, 600);		// explicitly set size in pixels
		frame.setLocation(100, 200);		// explicitly set size in pixels
		frame.setVisible(true);		// set to false to make invisible
		frame.setResizable(true);		// set to false to make invisible
	}
	
}

class DrawPanel extends JPanel 
{
	private int x,y,count;
	private boolean left,up;
	private Timer timer;

	private class Mover implements ActionListener,MouseListener,KeyListener
	{
		public Mover()
		{
			addMouseListener(this);
			addKeyListener(this);
			count = 0;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			requestFocusInWindow();
			repaint();
		}
		
		public void mousePressed(MouseEvent e)
		{
			requestFocusInWindow();

			count++;
			if (count%2 == 1)
				timer.stop();
			else
				timer.start();
			
			System.out.println("count = " + count);	
		}
	
		public void mouseClicked(MouseEvent e){}	
		public void mouseReleased(MouseEvent e){}		
		public void mouseEntered(MouseEvent e){}	
		public void mouseExited(MouseEvent e){}

		public void keyPressed(KeyEvent e)
		{
			int keyCode;
			keyCode = e.getKeyCode();
			
			
			if (keyCode == KeyEvent.VK_DOWN)
			{
				y+= 20;
			}
			else if (keyCode == KeyEvent.VK_UP)
			{
				y-= 20;
			}
			else if (keyCode == KeyEvent.VK_LEFT)
			{
				x-= 20;
			}
			else if (keyCode == KeyEvent.VK_RIGHT)
			{
				x+= 20;
			}
		}
		
		public void keyTyped(KeyEvent e){}	
		public void keyReleased(KeyEvent e){}
	}

	// The JPanel's constructor
	public DrawPanel () 
	{
		x = 0; y = 30;	// initial upper left corner location of red ball
		left = up = false;		// initialize ball going right and down
		
		Mover mover = new Mover();
		timer = new Timer(100,mover);
		timer.start();
		
	}
	
	// paintComponent() draws the circle and increments the location.
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		setBackground(Color.MAGENTA);
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 50, 50);
		
		// moves the ball right and left
		if (!left && x < getWidth()-50) 
			x++;
		else 
		{ 
			left = true; 
			x--; 
		}
		if ( left && x > 0 ) 
			x--;
		else 
		{ 
			left = false; 
			x++; 
		}
		
		// moves the ball up and down
		if (!up && y < getHeight()-50) 
			y++;
		else 
		{ 
			up = true; 
			y--; 
		}
		if ( up && y > 0 ) 
			y--;
		else 
		{ 
			up = false; 
			y++; 
		}
	}
}	// end class DrawPanel