import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Graphics;


public class BigWhirligig extends JFrame
{
	public BigWhirligig()
	{	
		JFrame frame = new JFrame("BigWhirligig");
		frame.setSize(2000,1000);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		PanelHolder pHold = new PanelHolder();// allows the user to close the frame
		frame.getContentPane().add(pHold);
		frame.setLocation(500,100);	// Sets the coordinates of the frame
		frame.setResizable(false);
		frame.setVisible(true);		// makes the frame visible
 	}

	public static void main(String[] args) 
	{
		BigWhirligig bwgig = new BigWhirligig();
	}
}

class PanelHolder extends JPanel
{
	public CardLayout cards;
	private JPanel jrbPanel;
	private JPanel jcbPanel;
	private final String JRBPANEL = "JRadioButton Card";
	private final String JCBPANEL = "JCheckBox Card";
	private int number;
	
	public PanelHolder()
	{
		System.out.println(number);
		if(number == 0) {
			cards = new CardLayout();
			setLayout(cards);
			
			jrbPanel = new JRadButton();
			jcbPanel = new HoldPanel();
			
			// jrbPanel.addMouseListener(this);
			// jcbPanel.addMouseListener(this);
			
			add(jrbPanel, JRBPANEL);
			add(jcbPanel, JCBPANEL);
		}
		else {
			cards.next(this);
		}
		number++;
	}
	// public void actionPerformed(ActionEvent e)
	// {
	// 	cards.next(this);
	// }
	// public void mouseClicked(MouseEvent e){}
	// public void mouseEntered(MouseEvent e){}
	// public void mouseExited(MouseEvent e){}
	// public void mouseReleased(MouseEvent e){}
}

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
		
		next.addActionListener(this);

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
		add(next);
		add(answer);
	}
	
	public void actionPerformed(ActionEvent evt)
	{		
		if (evt.getActionCommand().equals("Submit Answer"))
		{
			if (sel.equals("Increased risk of diabetes and cancer"))
			{
				answer.setText("CORRECT!");
				if (evt.getActionCommand().equals("Next")) {
					ph = new PanelHolder();
				}
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
			g.setColor(Color.red);
			g.fillOval(400,60,100,100);
			g.setColor(Color.black);
			g.fillOval(430,90,10,10);
			g.fillOval(460,90,10,10);
			g.drawArc(430, 110, 40, 40, 0, -180);
			g.setColor(Color.blue);
			g.fillPolygon(x,y,4);
			g.setColor(Color.black);
			g.drawLine(420,160,320,300);
			g.drawLine(480,160,580,300);
			g.drawLine(320,450,200,700);
			g.drawLine(200,700,150,700);
			g.drawLine(580,450,700,700);
			g.drawLine(700,700,750,700);
			
			if(effect3)
			{
				if(count3%2==1)
				{
					g.drawLine(450, 250, 600, 100);
					g.drawString("Leads to heart disease", 600, 100);
					g.setColor(Color.red);
					g.fillOval(400,60,100,100);
					g.setColor(Color.black);
					g.fillOval(430,90,10,10);
					g.fillOval(460,90,10,10);
					g.drawArc(430, 110, 40, 40, 0, 180);
					g.setColor(Color.red);
					g.fillPolygon(heartX, heartY, 3);
					g.fillArc(580, 130, 80, 40, 0, 180);
					g.fillArc(660, 130, 80, 40, 0, 180);
					g.setColor(Color.black);
					g.drawLine(650,238,650,360);
					g.drawLine(670,238,670,360);
					g.setColor(Color.YELLOW);
					g.fillRect(650,238,21,60);
					g.setColor(Color.BLACK);
					g.drawString("plaque",600,275);
					g.setColor(Color.red);
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
					g.setColor(Color.red);
					g.fillOval(400,60,100,100);
					g.setColor(Color.black);
					g.fillOval(430,90,10,10);
					g.fillOval(460,90,10,10);
					g.drawArc(430, 110, 40, 40, 0, 180);
					g.setColor(Color.red);
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