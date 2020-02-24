import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import java.io.File;                        // for classes File, IOException, ImageIO
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.Timer;

import java.util.Scanner;


public class BigWhirligig2 extends JFrame
{
	public BigWhirligig2()
	{	
		JFrame frame = new JFrame("BigWhirligig");
		frame.setSize(2000,1000);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		PanelHolder pHold = new PanelHolder();// allows the user to close the frame
		frame.getContentPane().add(pHold);
		frame.setLocation(50,20);	// Sets the coordinates of the frame
		frame.setResizable(false);
		frame.setVisible(true);		// makes the frame visible
 	}

	public static void main(String[] args) 
	{
		BigWhirligig2 bwgig2 = new BigWhirligig2();
	}
}

class PanelHolder extends JPanel
{
	public GridLayout grid;
	private JPanel jrbPanel;
	private JPanel jcbPanel;
	private JPanel jbPanel;
	private JPanel sliPanel;
	private JPanel instrucPanel;
	private int number;
	
	public PanelHolder()
	{
		grid = new GridLayout(2, 3);
		setLayout(grid);
		
		jrbPanel = new JRadButton();
		jcbPanel = new HoldPanel();
		jbPanel = new WhirligigButton();
		sliPanel = new SliderPanel();
		instrucPanel = new InstructionPanel();
		
		// jrbPanel.addMouseListener(this);
		// jcbPanel.addMouseListener(this);
		
		add(jrbPanel);
		add(jcbPanel);
		add(jbPanel);
		add(sliPanel);
		add(instrucPanel);
	}

		// public void actionPerformed(ActionEvent e)
	// {
	// 	cards.next(this);
	// }
	// public void mouseClicked(MouseEvent e){}
	// public void mouseEntered(MouseEvent e){}
	// public void mouseExited(MouseEvent e){}
	// public void mouseReleased(MouseEvent e){}

class JRadButton extends JPanel implements ActionListener
{
	private JRadioButton opt1,opt2,opt3,opt4;
	private JButton button;
	private JButton next;
	private JLabel answer;
	private ButtonGroup bg;
	private String sel;
	private PanelHolder ph;

	public JRadButton()
	{
		
		JLabel question = new JLabel("What effect can a lack of exercise have on a person?");
		JLabel qq = new JLabel("QUICK QUIZ!");
		answer = new JLabel("");
		
		sel = "";
		
		bg = new ButtonGroup();		
		button = new JButton("Submit Answer");
		button.addActionListener(this);
		
		opt1 = new JRadioButton("Good Health");
		opt2 = new JRadioButton("Weight Loss");
		opt3 = new JRadioButton("Increased risk of diabetes and cancer");
		opt4 = new JRadioButton("Prolonged life");
		
		next = new JButton("Next");

		setLayout(new GridLayout(10,1));
		
		opt1.addActionListener(this);
		opt2.addActionListener(this);
		opt3.addActionListener(this);
		opt4.addActionListener(this);
		
		bg.add(opt1);
		bg.add(opt2);
		bg.add(opt3);
		bg.add(opt4);

		add(qq);	
		add(question);
		add(opt1);
		add(opt2);
		add(opt3);
		add(opt4);
		add(button);
		add(answer);
	}
	
	public void actionPerformed(ActionEvent evt)
	{		
		if (evt.getActionCommand().equals("Submit Answer"))
		{
			if (sel.equals("Increased risk of diabetes and cancer"))
			{
				answer.setText("CORRECT!");
				
			}
			else
			{
				answer.setText("Incorrect");
			}
		} 
		else
		{
			sel = evt.getActionCommand();
		}

	}
}
  

/*class WhirligigJCB
{
	public WhirligigJCB()
	{
		JFrame sneezeFrame = new JFrame ("Effect");
		sneezeFrame.getContentPane().setBackground(Color.BLUE);
		sneezeFrame.setSize(1900, 1000);				
		sneezeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		sneezeFrame.setLocation(0,0);
		sneezeFrame.setResizable(true);
		HoldPanel pHolder = new HoldPanel(); 
		sneezeFrame.getContentPane().add( pHolder );	

		sneezeFrame.setVisible(true);
	}
}   */    

class HoldPanel extends JPanel
{
	private boolean effect1, effect2, effect3, effect4;
	private int count1, count2, count3, count4;
	private GraphicsPanel panel2;
	
	public HoldPanel()
	{
		effect1 = false;
		count1 = 0;
		effect2 = false;
		count2 = 0;
		effect3 = false;
		count3 = 0;
		effect4 = false;
		count4 = 0;
		
		setLayout(new GridLayout(1,2,10,10));
		setBackground(Color.blue);
		CheckPanel panel1 = new CheckPanel();
		add(panel1);
		panel2 = new GraphicsPanel();
		add(panel2);
	}

	class GraphicsPanel extends JPanel
	{
		public GraphicsPanel()
		{
		}
		public void paintComponent(Graphics g)
		{
			setBackground(Color.white);
			int[] x = {420,300,600,480};
			int[] y = {160,450,450,160};
			int[] heartX = {740,580,660};
			int[] heartY = {150,150,250};
			
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(400,60,100,100);
			g.setColor(Color.BLACK);
			g.fillOval(430,90,10,10);
			g.fillOval(460,90,10,10);
			g.drawArc(430, 110, 40, 40, 0, -180);
			g.setColor(Color.BLUE);
			g.fillPolygon(x,y,4);
			g.setColor(Color.BLACK);
			g.drawLine(420,160,320,300);
			g.drawLine(480,160,580,300);
			g.drawLine(320,450,200,700);
			g.drawLine(200,700,150,700);
			g.drawLine(580,450,700,700);
			g.drawLine(700,700,750,700);
			if(effect1)
			{
				if(count1%2==1)
				{
					g.drawLine(380,212,150,150);
					g.drawString("Easily breakable bones",90,140);
					g.setColor(Color.RED);
					g.fillOval(400,60,100,100);
					g.setColor(Color.BLACK);
					g.fillOval(430,90,10,10);
					g.fillOval(460,90,10,10);
					g.drawArc(430, 110, 40, 40, 0, 180);
					g.drawRect(90, 180, 100, 10);
					g.drawArc(76,180,50,10,120,150);
					g.drawLine(140,180,130,188);
					g.drawArc(154,180,50,10,300,130);
				}
			}
			if(effect2)
			{
				if(count2%2==1)
				{
					g.drawLine(230,400,400,300);
					g.drawString("Gain more weight(if you eat unhealthy)",0,400);
					g.setColor(Color.RED);
					g.fillOval(400,60,100,100);
					g.setColor(Color.BLACK);
					g.fillOval(430,90,10,10);
					g.fillOval(460,90,10,10);
					g.drawArc(430, 110, 40, 40, 0, 180);
					x[0]-=20;
					x[1]-=20;
					x[2]+=20;
					x[3]+=20;
					g.setColor(Color.BLUE);
					g.fillPolygon(x,y,4);
				}
			}
			if(effect3)
			{
				if(count3%2==1)
				{
					g.drawLine(450, 250, 600, 100);
					g.drawString("Leads to heart disease", 600, 100);
					g.setColor(Color.RED);
					g.fillOval(400,60,100,100);
					g.setColor(Color.BLACK);
					g.fillOval(430,90,10,10);
					g.fillOval(460,90,10,10);
					g.drawArc(430, 110, 40, 40, 0, 180);
					g.setColor(Color.RED);
					g.fillPolygon(heartX, heartY, 3);
					g.fillArc(580, 130, 80, 40, 0, 180);
					g.fillArc(660, 130, 80, 40, 0, 180);
					g.setColor(Color.BLACK);
					g.drawLine(650,238,650,360);
					g.drawLine(670,238,670,360);
					g.setColor(Color.YELLOW);
					g.fillRect(650,238,21,60);
					g.setColor(Color.BLACK);
					g.drawString("plaque",600,275);
					g.setColor(Color.RED);
					g.fillRect(650, 298, 21, 63);
					g.setColor(Color.BLACK);
					g.drawString("blood", 600, 325);
				}
			}

			if(effect4)
			{
				if(count4%2==1)
				{
					g.drawLine(450,600,620,600);
					g.drawString("Muscle atrophy", 350, 602);
					g.setColor(Color.RED);
					g.fillOval(400,60,100,100);
					g.setColor(Color.BLACK);
					g.fillOval(430,90,10,10);
					g.fillOval(460,90,10,10);
					g.drawArc(430, 110, 40, 40, 0, 180);
					g.setColor(Color.RED);
					g.fillOval(325,612,80,10);
					g.fillOval(525,612,80,30);
					g.setColor(Color.BLACK);
					g.drawString("Atrophying muscle",325, 642);
					g.drawString("Healthy muscle", 500, 662);
					g.drawLine(475, 605, 475, 700);
				}
			}
		}
	}

	class CheckPanel extends JPanel implements ActionListener 
	{
		private JLabel label;
		private JCheckBox box1, box2, box3, box4;
		public CheckPanel()
		{
			setBackground(Color.red);
			setLayout(new GridLayout(5,1));
			
			label = new JLabel("The negative effects of being inactive");
			box1 = new JCheckBox("Effect 1(Click to see what happens!)");
			box2 = new JCheckBox("Effect 2(Click to see what happens!)");
			box3 = new JCheckBox("Effect 3(Click to see what happens!)");
			box4 = new JCheckBox("Effect 4(Click to see what happens!)");
			
			box1.addActionListener(this);
			box2.addActionListener(this);
			box3.addActionListener(this);
			box4.addActionListener(this);
			
			add(label);
			add(box1);
			add(box2);
			add(box3);
			add(box4);
		}

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==box1)
			{
				effect1 = true;
				count1++;
			}
			else if(e.getSource()==box2)
			{
				effect2 = true;
				count2++;
			}
			else if(e.getSource()==box3)
			{
				effect3 = true;
				count3++;
			}
			else if(e.getSource()==box4)
			{
				effect4 = true;
				count4++;
			}
			panel2.repaint();
		}
	}
}

// class Whirligig
// {        
       
        // public Whirligig()
        // {
        // }
        
        // public void runIt()
        // {
        //     JFrame frame = new JFrame("Gdfsk");
        //     frame.setSize( 600, 500);                                
        //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        //     frame.setLocation(400,50);
        //     frame.setResizable(true);
        //     getMyImage();
        //     WhirligigButton pills2Panel = new WhirligigButton();                 
        //     frame.getContentPane().add( pills2Panel );        
        //     frame.setVisible(true);                
        // }
        
       


class WhirligigButton extends JPanel
{
  
	private ButtonPanel buttonP;
	private GraphicPanel graphP;
	public boolean pressed;        // used to tell is button pressed
	/////////
	//private JButton button; // 2.  declare the button
	public int y,jumpCount;
	private Timer timer;
	private int yPlace;
	public int time,weight;
	
	public Image image;
    private String pictName;

		
   
	public WhirligigButton ()
	{
		pictName = new String("ThisManCanWork.jpg");

		setLayout(new GridLayout(1,2));
		graphP = new GraphicPanel();
		weight = 0;
		buttonP = new ButtonPanel();
		add(buttonP);
		add(graphP);
		pressed = false;
		y = 0;
		jumpCount = 0;
		yPlace = 0;                        // initial upper left corner location of red ball
		Jumper jump = new Jumper();                                                        ////////////////////////////////////////////////
				//        Declare and initialize
				//        - an ActionListener object
		timer = new Timer(5,jump); //        - a Timer
		time = 0;
				////////////////////////////////////////////////
	}

	public void getMyImage() 
    {
            ///////////////////////////////////////////////////
            // 1. Create a try-catch block for loading the image
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
	
	private class Jumper implements ActionListener
	{
		public Jumper()
		{
		}
		public void actionPerformed(ActionEvent e)
		{
			time += 2;
			graphP.repaint();
			
			if (y == 0)
				timer.stop();
		}
	}

	public class ButtonPanel extends JPanel
	{
		private TextPanel tPa;
		private ButtonPPanel bP;

		public ButtonPanel()
		{
			setLayout(new GridLayout(2,1));
			tPa = new TextPanel();
			bP = new ButtonPPanel();
			add(bP);
			add(tPa);
		}
		public class ButtonPPanel extends JPanel
		{
			public void paintComponent(Graphics g)
			{
				setBackground(Color.GREEN);
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				Font newFont = new Font("Serif", Font.BOLD, 30);
				g.setFont(newFont);
				g.drawString("Excercise now", 0, 50);
				Font writ = new Font("Serif", Font.PLAIN, 10);
				g.setFont(writ);
				g.drawString("Excercise isn't limited to just the gym or a sport. Jumprope, for",0,70);
				g.drawString("example, jump rope is an easy way to burn calories without having to ",0,80);
				g.drawString("spend money for a monthly membership. Don't Believe It? Test it out! ", 0,90);
				g.drawString("Make the man on the right jump, and see how many calories he'll burn ",0,100);
				g.drawString("in just jumps. Go on, press that button below and make him jump!",0,110);
				g.drawString("Note: These stats are based on a 150 pound man.",0,150);
			}
		}

		public class TextPanel extends JPanel
		{
			private JButton button2;
	
			public TextPanel()
			{
				setLayout(new FlowLayout());
				button2 = new JButton("Make me jump");
				Button2Handler bh = new Button2Handler();
				button2.addActionListener(bh);
				pressed = false;
				add(button2);
			}
	
			class Button2Handler implements ActionListener
			{
				public void actionPerformed(ActionEvent evt)
				{
					String command = evt.getActionCommand();
					if (command.equals("Make me jump"))
					{
						pressed = true;
						timer.start();
						time = 0;
						jumpCount += 15;
						weight--;
					}
			
					graphP.repaint();
				}
			}	
		}
	}
}

public class GraphicPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		WhirligigButton wgb = new WhirligigButton();

		String cB = "Jumps Done:\t" + wgb.jumpCount;
		int calorie = wgb.jumpCount/6;
		String jB = "Calories Burnt:\t" + calorie;
		setBackground(Color.WHITE);
		super.paintComponent (g);        // draw background        
		g.setColor(Color.BLUE);        
		Font font = new Font ("Serif", Font.BOLD, 20);
		g.setFont( font );        
		g.drawString(cB,50,50);
		g.drawString(jB,50,70);
		if (calorie >= 800)
		g.drawString("That's too much! STop!",50,100);
				
		g.setColor(Color.BLACK);
	}
	////////////////////////////
	// 3.  conditionally draw string, reset.
		if (wgb.pressed)
		{
			
			if(wgb.time > 50)
			{
					wgb.y += 5;
			}
			if(wgb.time < 50)
			{
					wgb.y -= 5;
			}
			
			if (wgb.y == 0)
			{
				wgb.pressed = false;
				wgb.time = 0;
			}
			
		}
		
		g.fillRect(50,wgb.y+330,50,100);
		g.drawImage(wgb.image,50,wgb.y+300,200-wgb.weight,200,this);
	}
}	


class SliderPanel extends JPanel
{
	public SliderPanel()
    {
	    JSlider slider = new JSlider(slider.HORIZONTAL, 0, 10, 0);
	    SliderHandler shandler = new SliderHandler();
	    
	    slider.addChangeListener(shandler);

	    JLabel label = new JLabel("Amount of exercise", JLabel.CENTER);
	    slider.setMajorTickSpacing(1);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    Font font = new Font("Arial",Font.BOLD, 10);
	    slider.setFont(font);
	    add(label);
	    add(slider);
	    if(slider.getValue()<5)
	    {
			JLabel jb = new JLabel("Amount of exercise might not be enough", JLabel.SOUTH);
		}
		else
		{
			JLabel jbb = new JLabel("Amount of exercise is enough. Good Job!", JLabel.SOUTH);
		}
	}

}

class InstructionPanel extends JPanel
{
    public InstructionPanel()
    {
	    Scanner sc = new Scanner(System.in);
        System.out.println("What kind of exercise you prefer, running, swimming or soccer?");
        String choice = sc.nextLine();
        JTextArea JTA = new JTextArea(choice);
        JTA.setEditable(false);
        add(JTA);
        if (choice == "running" || choice == "swimming" || choice == "soccer")
        {
		  Font font = new Font("Arial",Font.BOLD, 10);
		  JLabel lab = new JLabel(choice + " is a good exercise!", JLabel.CENTER);
	    }
	    else
	    {
		    Font font = new Font("Arial",Font.BOLD, 10);
	    	JLabel lab = new JLabel(choice + " is not an option, sorry.", JLabel.CENTER);
		}
	}
}
