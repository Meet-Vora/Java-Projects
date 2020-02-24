import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;

import java.util.Scanner;

public class GoodEasyP extends JFrame
{
	public GoodEasyP()
	{
		JFrame frame = new JFrame("Maze");
		frame.setSize(1920,1180);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		EasyPanell ep = new EasyPanell();
		frame.setContentPane(ep);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String []args)
	{
		GoodEasyP gep = new GoodEasyP();
	}
}

class EasyPanell extends JPanel
{
	EasyControlPanell easyControlP;
	EasyGamePanell easyGameP;
	InstructionPanell inP;
	
	BorderLayout easyBorder;
	
	public EasyPanell()
	{
		easyBorder = new BorderLayout();
		setLayout(easyBorder);
		
		easyControlP = new EasyControlPanell();
		easyGameP = new EasyGamePanell();
		inP = new InstructionPanell();
		
		add(inP,BorderLayout.WEST);
		add(easyControlP,BorderLayout.SOUTH);
		add(easyGameP,BorderLayout.CENTER);
	}
	
	class EasyControlPanell extends JPanel implements ActionListener
	{
		ButtonGroup bg;
		JRadioButton opt1,opt2,opt3,opt4;
		JButton easyEnterAns;
		GridLayout controlGrid;
		int easyXPos;
		int easyYPos;
		
		Boolean pressed[];
		
		public EasyControlPanell()
		{
			pressed[] = new String[10];
			
			easyControlGrid = new GridLayout(1,5);
			setLayout(easyControlGrid);
			
			bg = new ButtonGroup();
			easyEnterAns = new JButton("Enter Answer");
			easyEnterAns.addActionListener(this);
			
							//get coordinates of the circle the user is on, and show the radiobutton options accordingly
			
			
			if (easyXPos == 1250 && easyYPos == 610)	// 1
			{
				opt1 = new JRadioButton("<0,3>");
				opt2 = new JRadioButton("(5,pi)");
				opt3 = new JRadioButton("(5,0)");
				
				pressed[0] = true;
			}
			
			else if (easyXPos == 1250 && easyYPos == 250)		// 2
			{
				opt1 = new JRadioButton("<0,-2>");
				opt2 = new JRadioButton("<-2,1>");
				opt3 = new JRadioButton("(-2,0)"); 
			}
			
			else if (easyXPos == 895 && easyYPos == 295)	// 3 - 45
			{
				opt1 = new JRadioButton("<0,1>");
				opt2 = new JRadioButton("(2,3pi/2");
				opt3 = new JRadioButton("<0,-1>");
			}
			
			else if (easyXPos == 895 && easyYPos == 415)	// 4 - 45
			{
				opt1 = new JRadioButton("<2,0>");
				opt2 = new JRadioButton("(-2,0)");
				opt3 = new JRadioButton("(-2,pi)");
			}
			
			else if (easyXPos == 495 && easyYPos == 415)	// 5 - 45
			{
				opt1 = new JRadioButton("2,0)");
				opt2 = new JRadioButton("(1,3pi/2)");
				opt3 = new JRadioButton("<0,1>");
			}
			
			else if (easyXPos == 495 && easyYPos == 535)	// 6 - 45
			{
				// end the level - show a congratulations message
			}
			
			else if (easyXPos == 250 && easyYPos == 610)	// 7	// change options of opt 1 2 3 4 based on the circle the user is on,
			{			// so use if-else blocks to change the options 
				opt1 = new JRadioButton("<0,2>");
				opt2 = new JRadioButton("<2,0>");
				opt3 = new JRadioButton("<1,1>");
				
				pressed[1] = true;
				//opt4 = new JRadioButton("");

				//names[0] = "<0,2>";
				//names[1] = "<2,0>";
				//names[2] = "<1,1>";
			}
			
			else if (easyXPos == 295 && easyYPos == 415)	// 8 - 45
			{
				opt1 = new JRadioButton("<3,0>");
				opt2 = new JRadioButton("(-3,0)");
				opt3 = new JRadioButton("<");
			}
			
			else if (easyXPos == 895 && easyYPos == 415)	// 9 - 45
			{
				opt1 = new JRadioButton("(1,3pi/2)");
				opt2 = new JRadioButton("<0-1>");
				opt3 = new JRadioButton("(-1,3pi/2)");
			}
			
			image(easyXPos,easyYPos)
			
			opt1.addActionListener(this);
			opt2.addActionListener(this);
			opt3.addActionListener(this);
			//opt4.addActionListener(this);
			
			bg.add(opt1);
			bg.add(opt2);
			bg.add(opt3);
			//bg.add(opt4);
			
			add(opt1);
			add(opt2);
			add(opt3);
			//add(opt4);
			add(easyEnterAns);
			
			setBackground(Color.YELLOW);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			String command = evt.getActionCommand();
			
			// if they press enter, are on the right point, and if they choose the correct JRadionButton, then move the player. 
			// Figure out how to see if they pressed the right JRadioButton 
			
			if (command.equals("Enter"))
			{			
				if ()
				{
					
				}
			}
			
			
	}
	
	class EasyGamePanell extends JPanel
	{
		public EasyGamePanell()
		{
			setBackground(Color.GREEN);
		}
	}        
}

class InstructionPanell extends JPanel
{
	//private String inFileName;
	//private File inFile;
	//private Scanner input;
	//private String value;
	private JButton easyBack;
	private JLabel instruc;
	private GridLayout instrucGrid;
	private Font font;
	//private int counter;
	
	public InstructionPanell()
	{		
		instrucGrid = new GridLayout(20,1);
		setLayout(instrucGrid);
		//inFileName = "instructions.txt";
		//inFile = new File(inFileName);
		//input = null;
		//value = "";
		easyBack = new JButton("Back");
		
		/*try
		{
			input = new Scanner(inFile);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Cannot find " + inFileName + " file.");
			System.exit(1);
		}
		
		while(input.hasNext())
		{
			value = value + " " + input.nextLine();
			//System.out.print(value);
			
		}
		
		counter = value.length();
		*/

		add(easyBack);	
		
		font = new Font("Monospaced",Font.BOLD,20);
				
		instruc = new JLabel(" At Each Checkpoint:  ");	
		add(instruc);
		instruc.setFont(font);
		
		instruc = new JLabel("    Choose a polar coordinate (r,O)    ");
		add(instruc);
		instruc.setFont(font);

		instruc = new JLabel("    r -->  distance to travel in feet    ");
		add(instruc);
		instruc.setFont(font);
		
		instruc = new JLabel("    O -->  direction of motion in degrees    ");
		add(instruc);				
		instruc.setFont(font);

		instruc = new JLabel(" * each dot corresponds to one foot    ");
		add(instruc);				
		instruc.setFont(font);

		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);        
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String instrucCommand = evt.getActionCommand();

		if(instrucCommand.equals("Back"))
		{
			cards.show(holdP, "Start Panel");
		}
	}
}