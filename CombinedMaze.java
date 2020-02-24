/**Dorothy Chou & Meet Vora
4-9-2018
Maze.java
Description: 
Testing Plan: 
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Maze extends JFrame
{
	private HoldPanels holdP;
	
	public Maze()
	{
		JFrame frame = new JFrame("Maze");
		frame.setSize(1900, 1180);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		holdP = new HoldPanels();
		frame.getContentPane().add(holdP);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public static void main (String[]args)
	{
		Maze mz = new Maze();
	}

	class HoldPanels extends JPanel
	{
		private CardLayout cards;
		
		private StartPanel startP;
		private EasyPanel easyP;
		private MediumPanel mediumP;
		/*private HardPanel hardP;
		private InstructionPanel instructionP;*/
		
		public HoldPanels()
		{
			cards = new CardLayout();
			setLayout(cards);
			
			startP = new StartPanel();
			easyP = new EasyPanel();
			mediumP = new MediumPanel();
			/*hardP = new HardPanel();
			instructionP = new InstructionPanel();*/
			
			add(startP, "Start Panel");
			add(easyP, "Easy Panel");
			add(mediumP, "Medium Panel");
			//add(hardP, "Hard Panel");
		}

		class StartPanel extends JPanel implements ActionListener
		{
			private JMenuBar levelMenuBar;
			private JMenu levelMenu;
			private JMenuItem easyItem;
			private JMenuItem mediumItem;
			private JMenuItem hardItem;
			
			//private JButton backButton;
			
			public StartPanel()
			{
				setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 200));
				
				/*backButton = new JButton("BACK");
				backButton.addActionListener(this);*/
				
				JLabel gameName = new JLabel("MAZE");
				gameName.setFont(new Font("Monospaced", Font.BOLD, 200));
				gameName.setPreferredSize(new Dimension(500, 200));
				
				add(gameName);
				
				levelMenuBar = new JMenuBar();
				levelMenu = new JMenu("PLAY");
				easyItem = new JMenuItem("EASY");
				mediumItem = new JMenuItem("MEDIUM");
				hardItem = new JMenuItem("HARD");
				
				levelMenu.setFont(new Font("Monospaced", Font.BOLD, 125));
				easyItem.setFont(new Font("Monospaced", Font.BOLD, 80));
				mediumItem.setFont(new Font("Monospaced", Font.BOLD, 80));
				hardItem.setFont(new Font("Monospaced", Font.BOLD, 80));
				
				easyItem.addActionListener(this);
				mediumItem.addActionListener(this);
				hardItem.addActionListener(this);

				setBackground(Color.WHITE);				//set background color
				
				levelMenu.add(easyItem);
				levelMenu.add(mediumItem);
				levelMenu.add(hardItem);
				levelMenuBar.add(levelMenu);
				add(levelMenuBar);
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
			}
			public void actionPerformed(ActionEvent e)
			{	
				if(e.getActionCommand().equals("EASY"))
				{
					System.out.println("hi");
					cards.show(holdP,"Easy Panel");
				}
				else if(e.getActionCommand().equals("MEDIUM"))
				{
					cards.show(holdP, "Medium Panel");
				}
				/*else
				{
					cards.show(holdP, "Hard Panel");
				}
				*/
				if(e.getActionCommand().equals("BACK"))
				{
					cards.show(holdP, "Start Panel");
				}
			}
		}
		
		class EasyPanel extends JPanel
		{
			EasyControlPanel easyControlP;
			EasyGamePanel easyGameP;
		
			BorderLayout easyBorder;
		
			public EasyPanel()
			{
				easyBorder =  new BorderLayout();
				setLayout(easyBorder);
				
				easyControlP = new EasyControlPanel();
				easyGameP = new EasyGamePanel();
			
				add(instructionP,BorderLayout.EAST);
				add(easyControlP,BorderLayout.SOUTH);
				add(easyGameP,BorderLayout.CENTER);
			}
		
			class EasyControlPanel extends JPanel
			{
				public EasyControlPanel()
				{
				
				}
			}
			
			class EasyGamePanel extends JPanel
			{
				public EasyGamePanel()
				{
				}
			}	
		}
		
		class MediumPanel extends JPanel
		{
			public MediumPanel()
			{
				setBackground(Color.PINK);
				/*backButton = new JButton("BACK");
				add(backButton);*/
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
			}
		}
	}
}