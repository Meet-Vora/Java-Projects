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
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Maze extends JFrame										//DOROTHY
{
	private HoldPanels holdP;
	
	public Maze()
	{
		JFrame frame = new JFrame("Maze");
		frame.setSize(1920, 1180);
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

	class HoldPanels extends JPanel										//DOROTHY
	{
		private CardLayout cards;
		
		private Image stickBoy;
		private String stickBoyName;
		
		private StartPanel startP;
		private EasyPanel easyP;
		private MediumPanel mediumP;
		private HardPanel hardP;
		
		public HoldPanels()
		{
			cards = new CardLayout();
			setLayout(cards);
			
			startP = new StartPanel();
			easyP = new EasyPanel();
			mediumP = new MediumPanel();
			hardP = new HardPanel();
			
			add(startP, "Start Panel");
			add(easyP, "Easy Panel");
			add(mediumP, "Medium Panel");
			add(hardP, "Hard Panel");
			
			//backButton = new JButton("BACK");
			
			stickBoy = null;
			stickBoyName = "StickBoy.jpg";
			getStickBoy();
		}
		
		public void getStickBoy() 
		{
			try
			{
				stickBoy = ImageIO.read(new File(stickBoyName));
			}
			catch (IOException e)
			{
				System.err.println("\n\n"+stickBoyName+" can't be found");
				e.printStackTrace();
			}
		}

		class StartPanel extends JPanel implements ActionListener		//DOROTHY
		{
			private JMenuBar levelMenuBar;
			private JMenu levelMenu;
			private JMenuItem easyItem;
			private JMenuItem mediumItem;
			private JMenuItem hardItem;
			
			public StartPanel()
			{
				setLayout(new FlowLayout(FlowLayout.CENTER, 800, 120));
				
				//backButton.addActionListener(this);
				
				JLabel gameName = new JLabel("ADVENTURES OF");
				JLabel gameName2 = new JLabel("STICKBOY");
				gameName.setFont(new Font("Monospaced", Font.BOLD, 60));
				gameName2.setFont(new Font("Monospaced", Font.BOLD, 100));
				gameName.setPreferredSize(new Dimension(500, 70));
				gameName2.setPreferredSize(new Dimension(500, 100));
				
				add(gameName);
				add(gameName2);
				
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
				g.drawImage(stickBoy, 1250, 500, 500, 500, this);
			}
			public void actionPerformed(ActionEvent e)
			{	
				if(e.getActionCommand().equals("EASY"))
				{
					//System.out.println("hi");
					cards.show(holdP,"Easy Panel");
				}
				else if(e.getActionCommand().equals("MEDIUM"))
				{
					cards.show(holdP, "Medium Panel");
				}
				else
				{
					cards.show(holdP, "Hard Panel");
				}
				/*
				if(e.getActionCommand().equals("BACK"))
				{
					cards.show(holdP, "Start Panel");
				}*/
			}
		}
		
		class InstructionPanel extends JPanel implements ActionListener			//MEET
		{
			private JButton backButton;
			private JLabel instruc;
			private GridLayout instrucGrid;
			private Font font;
		
			public InstructionPanel()
			{		
				instrucGrid = new GridLayout(12,1, 0, 30);
				setLayout(instrucGrid);
			
				//inFileName = "instructions.txt";
				//inFile = new File(inFileName);
				//input = null;
				//value = "";
				backButton = new JButton("BACK");
				backButton.setFont(new Font("Monospaced", Font.BOLD, 30));
				//backButton.setSize(new Dimension(200, 500));
				
				add(backButton);
				backButton.addActionListener(this);	
				
				
				
				font = new Font("Monospaced",Font.BOLD,19);
						
				instruc = new JLabel(" At Each Checkpoint:  ");	
				add(instruc);
				instruc.setFont(font);
				
				instruc = new JLabel("   Choose or enter a polar coordinate (r,\u0398)   ");
				add(instruc);
				instruc.setFont(font);

				instruc = new JLabel("   r -->  distance to travel in feet   ");
				add(instruc);
				instruc.setFont(font);
				
				instruc = new JLabel("   \u0398 -->  direction of motion in degrees   ");
				add(instruc);				
				instruc.setFont(font);

				instruc = new JLabel("  OR  ");
				add(instruc);				
				instruc.setFont(font);
				
				instruc = new JLabel("  Choose or enter a vector value <x,y>   ");
				add(instruc);				
				instruc.setFont(font);
				
				instruc = new JLabel("  x --> horizontal distance in feet   ");
				add(instruc);				
				instruc.setFont(font);
				
				instruc = new JLabel("  y --> vertical distance in feet   ");
				add(instruc);				
				instruc.setFont(font);
				
				instruc = new JLabel(" * right and up are the positive directions   ");
				add(instruc);				
				instruc.setFont(font);
				
				instruc = new JLabel(" * each dot corresponds to one foot   ");
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

				if(instrucCommand.equals("BACK"))
				{
					cards.show(holdP, "Start Panel");
				}
			}
		}

		class EasyPanel extends JPanel						//DOROTHY
		{
			//private JButton eBackButton;
			EasyControlPanel easyControlP;
			private EasyMazePanel easyMazeP;
			private InstructionPanel eInstructionP;

			private BorderLayout easyBorder;
			private int easyXPos;
			private int easyYPos;
			boolean []easyPressed;
			
			private boolean congrats;
			private boolean sorry;
			private boolean eTutorial;
			private JRadioButton opt1,opt2,opt3;
			private ButtonGroup bg;
			
			public EasyPanel()
			{
				easyBorder = new BorderLayout();
				setLayout(easyBorder);
			
				eInstructionP = new InstructionPanel();
				easyControlP = new EasyControlPanel();
				easyMazeP = new EasyMazePanel();
							
				add(eInstructionP,BorderLayout.WEST);
				add(easyControlP,BorderLayout.SOUTH);
				add(easyMazeP,BorderLayout.CENTER);
				
				congrats = false;
				sorry = false;
				
								
				//eBackButton = new JButton("BACK");
				//eBackButton.setFont(new Font("Monospaced", Font.BOLD, 50));
				//eBackButton.setPreferredSize(new Dimension(200, 80));
				//eBackButton.addActionListener(this);
				//add(eBackButton, BorderLayout.WEST);
				//addMouseListener(this);
				
				//EasyMazePanel eMazeP = new EasyMazePanel();
				//eMazeP.setPreferredSize(new Dimension(1000, 800));
				//add(eMazeP, BorderLayout.CENTER);
				//add(eBackButton, BorderLayout.WEST);
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				/*if (pressed[8])
				{
					setBackground(Color.PINK);
					g.setFont(new Font("Monospaced", Font.BOLD, 200));
					g.drawString("CONGRATULATIONS",800,1080);
				}*/
				
			}
		
				/*if (ed)
				{
					setBackground(Color.PINK);
					g.setFont(new Font("Monospaced", Font.BOLD, 200));
					g.drawString("CONGRADULATIONS",800,1080);
				}
				
			}
			*/
			
			class EasyControlPanel extends JPanel implements ActionListener					//MEET
			{
				private String eCommandJRB; 
			//	private ButtonGroup bg;
				//private JRadioButton opt1,opt2,opt3;
				private JButton easyEnterAns;
				private FlowLayout easyControlFlow;
				
				public EasyControlPanel()
				{				
					easyPressed = new boolean[9];		// initializes as total number of indices
					
					easyControlFlow = new FlowLayout(FlowLayout.CENTER,232,0);
					setLayout(easyControlFlow);
					
					bg = new ButtonGroup();
					easyEnterAns = new JButton("Enter");
					easyEnterAns.setPreferredSize(new Dimension(380,380));
					easyEnterAns.addActionListener(this);
					
					//easyPressed[8] = false;

					easyXPos = 1250;
					easyYPos = 610;
									//get coordinates of the circle the user is on, and show the radiobutton options accordingly
					// image(easyXPos,easyYPos); fix image code - dorothy's doing it 
					
					opt1 = new JRadioButton("<0,3>");  // right
					opt2 = new JRadioButton("(-5,180)");
					opt3 = new JRadioButton("(-5,0)");
					
					
					EasyJRBHandler eJRBH =  new EasyJRBHandler();
					
					
					opt1.addActionListener(eJRBH);
					opt2.addActionListener(eJRBH);
					opt3.addActionListener(eJRBH);
					
					Font font = new Font("Monospaced",Font.BOLD,40);

					opt1.setFont(font);
					opt2.setFont(font);
					opt3.setFont(font);

					bg.add(opt1);
					bg.add(opt2);
					bg.add(opt3);
					
					add(opt1);
					add(opt2);
					add(opt3);

					add(easyEnterAns);
					
					setBackground(Color.getHSBColor(0.6F ,0.5F, 1.0F));
					easyUpdateButtons();					
				}
				
				public void easyUpdateButtons()
				{
					if (easyXPos == 1250 && easyYPos == 610)	// 1
					{
						opt1.setText("<0,3>");  // right
						opt2.setText("(-5,180)");
						opt3.setText("(-5,0)");
						
						easyPressed[0] = true;
					}
					
					else if (easyXPos == 1250 && easyYPos == 250)		// 2
					{
						opt1.setText("<0,-2>");
						opt2.setText("<-2,3>");
						opt3.setText("(-2,0)"); // right
						
						easyPressed[1] = true;
					}
					
					else if (easyXPos == 850 && easyYPos == 250)	// 3
					{
						opt1.setText("<0,1>");	// right
						opt2.setText("(3,180)");
						opt3.setText("<0,-1>");
						
						easyPressed[2] = true;
					}
					
					else if (easyXPos == 850 && easyYPos == 130)	// 4
					{
						opt1.setText("<2,0>");
						opt2.setText("(-2,0)");
						opt3.setText("(-2,180)");
						
						easyPressed[3] = true;
					}
					
					else if (easyXPos == 450 && easyYPos == 130)	// 5
					{
						opt1.setText("(2,0)");
						opt2.setText("(1,270)");
						opt3.setText("<0,1>");
						
						easyPressed[4] = true;
					}
					
					else if (easyXPos == 250 && easyYPos == 610)	// 6	// change options of opt 1 2 3 4 based on the circle the user is on,
					{			// so use if-else blocks to change the options 
						opt1.setText("<0,2>");
						opt2.setText("<2,0>");
						opt3.setText("<1,1>");
						
						easyPressed[5] = true;
						//opt4 = new JRadioButton("");

						//names[0] = "<0,2>";
						//names[1] = "<2,0>";
						//names[2] = "<1,1>";
					}
					
					else if (easyXPos == 250 && easyYPos == 370)	// 7
					{
						opt1.setText("(-3,0)");
						opt2.setText("<3,0>");
						opt3.setText("<0,3>");
						
						easyPressed[6] = true;
					}
					
					else if (easyXPos == 850 && easyYPos == 370)	// 8
					{
						opt1.setText("(2,270)");
						opt2.setText("<0,-2>");
						opt3.setText("(-2,270)");
						
						easyPressed[7] = true;
					}
					
					else if (easyXPos == 450 && easyYPos == 490)	// 9
					{
						easyPressed[8] = true;
					}
				}
				
				class EasyJRBHandler implements ActionListener
				{
					public EasyJRBHandler()
					{
					}
					
					public void actionPerformed(ActionEvent evt)
					{
						eCommandJRB = evt.getActionCommand();
					}
				}
				
				public void actionPerformed(ActionEvent evt)
				{
					//String eCommandButton = evt.getActionCommand();
				//	commandJRB = evt.getActionCommand();
					
					// if they press enter, are on the right point, and if they choose the correct JRadionButton, then move the player. 
					// Figure out how to see if they pressed the right JRadioButton 
					
					
					// for(int i = 0; i < easyPressed.length; i++)
					// {
					// 	System.out.println(i + ": " + easyPressed[i]);
					// }
					
					if (evt.getActionCommand().equals("Enter") && (bg.getSelection()!=null))
					{			
						if (easyPressed[0])
						{
							if (eCommandJRB.equals("<0,3>"))
							{
								easyXPos = 1250;
								easyYPos = 250;
								// image coor: (1250,250)
							
							}
							else if (eCommandJRB.equals("(-5,0)"))
							{
								easyXPos = 250;
								easyYPos = 610;
							}
							else
							{
								sorry = true;
							}
							easyPressed[0] = false;
						}
						else if (easyPressed[1])
						{
							if (eCommandJRB.equals("(-2,0)"))
							{
								easyXPos = 850;
								easyYPos = 250;
								// image coor: (850,250)

								easyPressed[1] = false;
								
							}
							else
							{
								sorry = true;
							}
						}
						else if (easyPressed[2])
						{
							if (eCommandJRB.equals("<0,1>"))
							{
								easyXPos = 850;
								easyYPos = 130;
								// image coor: (850,130)
								
								easyPressed[2] = false;
								
							}
							else
							{
								sorry = true;
							}
						}
						else if (easyPressed[3])
						{
							if (eCommandJRB.equals("(-2,0)"))
							{
								easyXPos = 450;
								easyYPos = 130;
								// image coor: (450,130)
								
								easyPressed[3] = false;
								
							}
							else
							{
								sorry = true;
							}
						}	
						else if (easyPressed[4])
						{
							if (eCommandJRB.equals("<0,1>"))
							{
								easyXPos = 450;
								easyYPos = 10;
								// image coor: (450,490)
								
								easyPressed[4] = false;
								congrats = true;

							}
							else
							{
								sorry = true;
							}
						}
						else if (easyPressed[5])
						{
							if (eCommandJRB.equals("<0,2>"))
							{
								easyXPos = 250;
								easyYPos = 370;
								// image coor: (350,370)
								
								easyPressed[5] = false;
							}
							else
							{
								sorry = true;
							}
						}
						else if (easyPressed[6])
						{
							if (eCommandJRB.equals("<3,0>"))
							{
								easyXPos = 850;
								easyYPos = 370;
								// image coor: (850,370)
								
								easyPressed[6] = false;
							}
							else
							{
								sorry = true;
							}
						}
						else if (easyPressed[7])
						{
							if (eCommandJRB.equals("(-2,270)"))
							{
								easyXPos = 850;
								easyYPos = 130;
								// image coor: (850,250)
								
								easyPressed[7] = false;
							}
							else
							{
								sorry = true;
							}
						}
						
						else if (easyPressed[8])	// 9
						{
							//congrats = true;
							
							easyPressed[8] = false;
						}
					}
					
					//System.out.println(commandJRB);
					bg.clearSelection();
					easyUpdateButtons();
					eTutorial = false;
					easyMazeP.repaint();
					
					// easyMazePanel.repaint();  --- repaint picture every time in each if-else
				}
			}
			class EasyMazePanel extends JPanel implements MouseListener								//DOROTHY
			{
				private boolean end;
				//private boolean eTutorial;
				
				public EasyMazePanel()
				{
					setBackground(Color.WHITE);
					end = false;
					eTutorial = true;
					addMouseListener(this);
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					
					if(!sorry && !congrats)
					{
						for(int x = 95; x <= 1400; x+=200)
						{
							for(int y = 55; y <= 720; y+=120)
							{
								g.setColor(Color.PINK);					
								g.fillOval(x, y, 10, 10);	
							}
						}
						
						g.setColor(Color.BLACK);
						
						g.drawImage(stickBoy,easyXPos,easyYPos,100,100,this);
	
						int[]xArray1 = {0,400,400,800,800,200,200,0};
						int[]yArray1 = {0,0,240,240,360,360,120,120};
						g.fillPolygon(xArray1, yArray1, 8);
						
						int[]xArray2 = {600,1200,1200,1000,1000,1200,1200,400,400,1000,1000,600};
						int[]yArray2 = {0,0,240,240,360,360,600,600,480,480,120,120};
						g.fillPolygon(xArray2, yArray2, 12);
						
						g.fillRect(0,480,200,120);
						
						g.drawLine(0,0,1400,0);
						g.drawLine(1400,0,1400,720);
						g.drawLine(1400,720,0,720);
						g.drawLine(0,720,0,0);
						
						g.setFont(new Font("Monospaced", Font.BOLD, 50));
						g.setColor(Color.getHSBColor(0.3F ,0.5F, 1.0F));
						g.drawString("START", 1240, 710);
						g.drawString("FINISH", 410, 40);
					}
					else if(sorry)
					{
						g.setColor(Color.WHITE);
						g.drawRect(0,0,1400,720);
						
						g.setColor(Color.BLACK);
						g.setFont(new Font("Monospaced", Font.BOLD, 80));
						g.drawString("SORRY!", 400, 400);
						g.setFont(new Font("Monospaced", Font.BOLD, 20));
						g.drawString("click [HERE] to try again", 400, 450);
						
						
						end = true;
					}
					else if(congrats)
					{
						g.setColor(Color.WHITE);
						g.drawRect(0,0,1400,720);
						
						g.setColor(Color.BLACK);
						g.setFont(new Font("Monospaced", Font.BOLD, 80));
						g.drawString("CONGRATULATIONS!", 400, 400);
						g.setFont(new Font("Monospaced", Font.BOLD, 20));
						g.drawString("click [HERE] to play again", 400, 450);
						end = true;
					}
					
					if (eTutorial)
					{
						g.setColor(Color.RED);
						g.setFont(new Font("Monospaced", Font.BOLD, 30));
						g.drawString("HINTS",1180,630);
						g.setFont(new Font("Monospaced", Font.BOLD, 50));
						g.drawString("^",1285,580);
						g.drawString("3",1287,600);
						g.drawString("<",1150,680);
						g.drawString("-5",1180,680);
						//eTutorial = false;
					}
				}	
				public void mouseClicked(MouseEvent e){}
				public void mouseEntered(MouseEvent e){}
				public void mousePressed(MouseEvent e)
				{	
					if (end)
					{
						easyXPos = 1250;
						easyYPos = 610;
						
						sorry = congrats = false;
						opt1.setText("<0,3>");  // right
						opt2.setText("(-5,180)");
						opt3.setText("(-5,0)");
						
						eTutorial = true;
						bg.clearSelection();
						
						for(int i=0; i<=8; i++)
						{
							easyPressed[i] = false;
						}
						easyControlP.easyUpdateButtons();
						easyMazeP.repaint();
						easyControlP.repaint();
					}
				}
				public void mouseExited(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
			}
		}
	
		class MediumPanel extends JPanel //implements ActionListener					//DOROTHY
		{
			MediumControlPanel mediumControlP;
			private MediumMazePanel mediumMazeP;
			private InstructionPanel mInstructionP;
			
			private BorderLayout mediumBorder;
			boolean []mediumPressed;
			private int mediumXPos;
			private int mediumYPos;
			
			private boolean mCongrats;
			private boolean mSorry;
			private boolean mTutorial;
			private JRadioButton mOpt1,mOpt2,mOpt3;
			private ButtonGroup mBG;
			
			public MediumPanel()
			{
				mediumBorder = new BorderLayout();
				setLayout(mediumBorder);
			
				mediumControlP = new MediumControlPanel();
				mediumMazeP = new MediumMazePanel();
				mInstructionP = new InstructionPanel();
							
				add(mInstructionP,BorderLayout.WEST);
				add(mediumControlP,BorderLayout.SOUTH);
				add(mediumMazeP,BorderLayout.CENTER);
				
				mCongrats = mSorry = false;
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
			}
			/*public void actionPerformed(ActionEvent e)
			{	
				if(e.getActionCommand().equals("BACK"))
				{
					cards.show(holdP, "Start Panel");
				}
			}*/
		
			class MediumControlPanel extends JPanel implements ActionListener					//MEET
			{
				String mCommandJRB;
				//private ButtonGroup mBG;
				//private JRadioButton mOpt1,mOpt2,mOpt3;
				private JButton mediumEnterAns;
				private FlowLayout mediumControlFlow;

				public MediumControlPanel()
				{
					mediumPressed = new boolean[9];

					mediumControlFlow = new FlowLayout(FlowLayout.CENTER,210,0);
					setLayout(mediumControlFlow);

					mBG = new ButtonGroup();
					mediumEnterAns = new JButton("Enter");
					mediumEnterAns.setPreferredSize(new Dimension(380,380));
					mediumEnterAns.addActionListener(this);
					
					mediumPressed[8] = false;
					
					mediumXPos = 1100;
					mediumYPos = 610;
									//get coordinates of the circle the user is on, and show the radiobutton options accordingly
					// image(easyXPos,easyYPos); fix image code - dorothy's doing it 
					
					mOpt1 = new JRadioButton("(-1,60)");  
					mOpt2 = new JRadioButton("(1,120)");	// right
					mOpt3 = new JRadioButton("<0,-1>");
					
					
					MediumJRBHandler mJRBH =  new MediumJRBHandler();
					
					
					mOpt1.addActionListener(mJRBH);
					mOpt2.addActionListener(mJRBH);
					mOpt3.addActionListener(mJRBH);
					
					Font font = new Font("Monospaced",Font.BOLD,40);

					mOpt1.setFont(font);
					mOpt2.setFont(font);
					mOpt3.setFont(font);

					mBG.add(mOpt1);
					mBG.add(mOpt2);
					mBG.add(mOpt3);
					
					add(mOpt1);
					add(mOpt2);
					add(mOpt3);
					add(mediumEnterAns);
					
					
					setBackground(Color.getHSBColor(0.6F ,0.5F, 1.0F));
					mediumUpdateButtons();
				}

				public void mediumUpdateButtons()
				{
					if (mediumXPos == 1100 && mediumYPos == 610)	// 1
					{
						mOpt1.setText("(-1,60)");  
						mOpt2.setText("(1,120)");	// right
						mOpt3.setText("<0,-1>");
						
						mediumPressed[0] = true;
					}
					
					else if (mediumXPos == 1050 && mediumYPos == 490)	// 2
					{
						mOpt1.setText("<-3,0>");	//right
						mOpt2.setText("<3,0>");
						mOpt3.setText("<0,3>");

						mediumPressed[1] = true;
					}
					
					else if (mediumXPos == 750 && mediumYPos == 490)	// 3
					{
						mOpt1.setText("(1,60)");	//right
						mOpt2.setText("(-7,0)");	//right
						mOpt3.setText("<7,0>");

						mediumPressed[2] = true;
					}
					
					else if (mediumXPos == 795 && mediumYPos == 370)	// 4
					{
						mOpt1.setText("(-1,60)");
						mOpt2.setText("<2,0>");
						mOpt3.setText("(-1,240)");	//right

						mediumPressed[3] = true;
					}
					
					else if (mediumXPos == 850 && mediumYPos == 250)	// 5
					{
						mOpt1.setText("(180,-5)");
						mOpt2.setText("(-5,0)");	//right
						mOpt3.setText("(-5,180)");

						mediumPressed[4] = true;
					}
					
					else if (mediumXPos == 350 && mediumYPos == 250)	// 6
					{
						mOpt1.setText("(-2,240)");
						mOpt2.setText("(2,60)");
						mOpt3.setText("<-0.5,2>");	//right

						mediumPressed[5] = true;
					}
					
					else if (mediumXPos == 50 && mediumYPos == 490)	// 7
					{
						mOpt1.setText("<0,2>");		//right
						mOpt2.setText("<2,0>");
						mOpt3.setText("(-2,90)");

						mediumPressed[6] = true;
					}
					
					else if (mediumXPos == 50 && mediumYPos == 250)	// 8
					{
						mOpt1.setText("(180,3)");
						mOpt2.setText("(-3,180)");	//right
						mOpt3.setText("(3,180)");	

						mediumPressed[7] = true;
					}

					else if(mediumXPos == 270 && mediumYPos == 10)
					{
						mediumPressed[8] = true;
					}
				}

				class MediumJRBHandler implements ActionListener
				{
					public MediumJRBHandler()
					{
					}

					public void actionPerformed(ActionEvent evt)
					{
						mCommandJRB = evt.getActionCommand();
					}
				}

				public void actionPerformed(ActionEvent evt)
				{
					String mCommandButton = evt.getActionCommand();

					if (mCommandButton.equals("Enter") && (mBG.getSelection()!=null)); 
					{
						if (mediumPressed[0]) 
						{
							if (mCommandJRB.equals("(1,120)"))
							{
								mediumXPos = 1050;
								mediumYPos = 490;
								
								mediumPressed[0] = false;
							}
							else
							{
								mSorry = true;
							}
						}
						
						else if (mediumPressed[1])
						{
							if (mCommandJRB.equals("<-3,0>"))
							{
								mediumXPos = 750;
								mediumYPos = 490;
								
								mediumPressed[1] = false;
							}
							else
							{
								mSorry = true;
							}
						}

						else if (mediumPressed[2])
						{
							if (mCommandJRB.equals("(1,60)"))
							{
								mediumXPos = 795;
								mediumYPos = 370;

								mediumPressed[2] = false;
							}

							else if(mCommandJRB.equals("(-7,0)"))
							{
								mediumXPos = 50;
								mediumYPos = 490;

								mediumPressed[2] = false;
							}
							else
							{
								mSorry = true;
							}
						}

						else if (mediumPressed[3])
						{
							if(mCommandJRB.equals("(-1,240)"))
							{
								mediumXPos = 850;
								mediumYPos = 250;

								mediumPressed[3] = false;
							}
							else
							{
								mSorry = true;
							}
						}

						else if (mediumPressed[4])
						{
							if(mCommandJRB.equals("(-5,0)"))
							{
								mediumXPos = 350;
								mediumYPos = 250;

								mediumPressed[4] = false;
	
							}
							else
							{
								mSorry = true;
							}
						}

						else if (mediumPressed[5])
						{
							if (mCommandJRB.equals("<-0.5,2>"))
							{
								mediumXPos = 270;
								mediumYPos = 10;

								mediumPressed[5] = false;
								mCongrats = true;
							}
							else
							{
								mSorry = true;
							}
						}

						else if (mediumPressed[6])
						{
							if (mCommandJRB.equals("<0,2>"))
							{
								mediumXPos = 50;
								mediumYPos = 250;

								mediumPressed[6] = false;
							}
							else
							{
								mSorry = true;
							}
						}

						else if (mediumPressed[7])
						{
							if (mCommandJRB.equals("(-3,180)"))
							{
								mediumXPos = 350;
								mediumYPos = 250;

								mediumPressed[8] = false;
							}
							else
							{
								mSorry = true;
							}
						}
					}
					
					mBG.clearSelection();
					mediumUpdateButtons();
					mTutorial = false;
					mTutorial = false;
					mediumMazeP.repaint();
				}
			}
			
			class MediumMazePanel extends JPanel implements MouseListener								//DOROTHY
			{
				private boolean end;
				//private boolean mTutorial;
				
				public MediumMazePanel()
				{
					setBackground(Color.WHITE);
					end = false;
					mTutorial = true;
					addMouseListener(this);
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					
					g.setColor(Color.PINK);	
					
					if(!mSorry && !mCongrats)
					{
						for(int x = 95; x < 1395; x+=100)
						{				
							g.fillOval(x, 295, 10, 10);
							g.fillOval(x, 535, 10, 10);
						}
						
						for(int x = 95; x < 1395; x+=745)
						{					
							g.fillOval(x, 415, 10, 10);
						}
						
						for(int x = 145; x < 1395; x+=1000)
						{				
							g.fillOval(x, 655, 10, 10);
						}
						
						for(int x = 370; x < 1395; x+=130)
						{					
							g.fillOval(x, 175, 10, 10);
						}
						
						for(int x = 315; x < 1395; x+=160)
						{				
							g.fillOval(x, 55, 10, 10);
						}
					
						g.drawImage(stickBoy,mediumXPos,mediumYPos,100,100,this);
						
						g.setColor(Color.BLACK);
						
						int[]xArray1 = {0,0,300,200,400,500,800,800,900,1100,1000,1000,1200,1200};
						int[]yArray1 = {0,240,240,0,0,240,240,120,0,0,120,240,240,0};
						g.fillPolygon(xArray1, yArray1, 14);
						
						int[]xArray2 = {1400,1300,1000,900,1400,1400,1200,1300,1400};//1100,1000,600,700,100,0,0};
						int[]yArray2 = {240,360,360,480,480,600,600,720,720};
						g.fillPolygon(xArray2, yArray2, 9);
						
						int[]xArray3 = {1100,1000,200,300,100,0,0};
						int[]yArray3 = {720,600,600,720,720,600,720};
						g.fillPolygon(xArray3, yArray3, 7);
						
						int[]xArray4 = {200,800,700,200};
						int[]yArray4 = {360,360,480,480};
						g.fillPolygon(xArray4, yArray4, 4);
						
						g.drawLine(0,0,1400,0);
						g.drawLine(1400,0,1400,720);
						g.drawLine(1400,720,0,720);
						g.drawLine(0,720,0,0);
						
						g.setFont(new Font("Monospaced", Font.BOLD, 50));
						g.setColor(Color.getHSBColor(0.3F ,0.5F, 1.0F));
						g.drawString("START", 1100, 710);
						g.setColor(Color.getHSBColor(0.3F ,0.5F, 1.0F));
						g.drawString("FINISH", 220, 40);
					}
					else if(mSorry)
					{
						g.setColor(Color.WHITE);
						g.drawRect(0,0,1400,720);
						
						g.setColor(Color.BLACK);
						g.setFont(new Font("Monospaced", Font.BOLD, 80));
						g.drawString("SORRY!", 400, 400);
						g.setFont(new Font("Monospaced", Font.BOLD, 20));
						g.drawString("click [HERE] to try again", 400, 450);
						
						end = true;
					}
					else if(mCongrats)
					{
						g.setColor(Color.WHITE);
						g.drawRect(0,0,1400,720);
						
						g.setColor(Color.BLACK);
						g.setFont(new Font("Monospaced", Font.BOLD, 80));
						g.drawString("CONGRATULATIONS!", 400, 400);
						g.setFont(new Font("Monospaced", Font.BOLD, 20));
						g.drawString("click [HERE] to play again", 400, 450);
						end = true;
					}
					
					if (mTutorial)
					{
						g.setColor(Color.RED);
						g.setFont(new Font("Monospaced", Font.BOLD, 30));
						g.drawString("HINTS",1180,595);
						g.setFont(new Font("Monospaced", Font.BOLD, 50));
						g.drawString("^",1090,580);
						g.drawString("\\",1100,600);
						g.drawString("1",1140,600);
						//mTutorial = false;
					}
				}
				public void mouseClicked(MouseEvent e){}
				public void mouseEntered(MouseEvent e){}
				public void mousePressed(MouseEvent e)
				{	
					if (end)
					{
						mediumXPos = 1100;
						mediumYPos = 610;
						
						mSorry = mCongrats = false;
						mOpt1.setText("(-1,60)");  
						mOpt2.setText("(1,120)");	// right
						mOpt3.setText("<0,-1>");
						
						mTutorial = true;
						mBG.clearSelection();
						
						for(int i=0; i<=8; i++)
						{
							mediumPressed[i] = false;
						}
						mediumControlP.mediumUpdateButtons();
						mediumMazeP.repaint();
						mediumControlP.repaint();
					}
				}
				public void mouseExited(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
			}
		}
		
		class HardPanel extends JPanel implements ActionListener						//DOROTHY						
		{
			private JButton hBackButton;
			private HardMazePanel hMazeP;
			private InstructionPanel hInstructionP;
			private HardControlPanel hControlP;
			private int hardXPos;
			private int hardYPos;
			private boolean polar;
			private boolean vector;
			private boolean tutorial;
			
			public HardPanel()
			{
				setLayout(new BorderLayout(0,0));
				setBackground(Color.BLACK);
				
				/*hBackButton = new JButton("BACK");
				hBackButton.setFont(new Font("Monospaced", Font.BOLD, 50));
				hBackButton.setPreferredSize(new Dimension(200, 80));
				hBackButton.addActionListener(this);*/
				//add(hBackButton);
				//addMouseListener(this);
				
				hardXPos = 1250;
				hardYPos = 610;
				
				polar = false;
				vector = true;
				tutorial = true;
				
				hMazeP = new HardMazePanel();
				hInstructionP = new InstructionPanel();
				hControlP = new HardControlPanel();
				add(hMazeP, BorderLayout.CENTER);
				add(hInstructionP, BorderLayout.WEST);
				add(hControlP, BorderLayout.SOUTH);
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
			}
			public void actionPerformed(ActionEvent e)
			{	
				if(e.getActionCommand().equals("BACK"))
				{
					cards.show(holdP, "Start Panel");
				}
			}
			
			class HardControlPanel extends JPanel implements ActionListener
			{
				private JTextField text1;
				private JTextField text2;
				private JButton hardEnterAns;
				private FillerPanel filler;
				
				public HardControlPanel()
				{
					Color lightBlue = Color.getHSBColor(0.6F ,0.5F, 1.0F);
					setBackground(lightBlue);
					setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
					text1 = new JTextField("",3);
					text2 = new JTextField("",3);
					hardEnterAns = new JButton("ENTER");
					hardEnterAns.setFont(new Font("Monospaced", Font.PLAIN, 20));
					//hardEnterAns.setPreferredSize(new Dimension(100,200));
					filler = new FillerPanel();
					filler.setPreferredSize(new Dimension(2000, 200));
					
					text1.addActionListener(this);
					text2.addActionListener(this);
					hardEnterAns.addActionListener(this);
					
					add(text1);
					add(text2);
					add(hardEnterAns);
					add(filler);
					
				}
				class FillerPanel extends JPanel
				{
					public FillerPanel()
					{
						Color lightBlue = Color.getHSBColor(0.6F ,0.5F, 1.0F);
						setBackground(lightBlue);
					}
					public void paintComponent(Graphics g)
					{
						super.paintComponent(g);
					}
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					
					g.setFont(new Font("Monospaced", Font.BOLD, 25));
					
					if(polar)
					{
						g.drawString("enter a polar coordinate",300, 50);
						g.drawString("(", 825, 50);
						g.drawString(",", 888, 50);
						g.drawString(")", 948, 50);
						g.drawString("r   \u0398", 855, 80);
						g.setFont(new Font("Monospaced", Font.PLAIN, 20));
						//g.drawString("use positive values when possible",300, 80);
					}
					else if (vector)
					{
						g.drawString("enter a vector",500, 50);
						g.drawString("<", 825, 50);
						g.drawString(",", 888, 50);
						g.drawString(">", 948, 50);
						g.drawString("x   y", 855, 80);
					}
				}
				public void actionPerformed(ActionEvent e)
				{
					if (hardEnterAns.getActionCommand().equals("ENTER"))
					{
						if((hardXPos == 1250) && (hardYPos == 610) && (text1.getText().equals("0")) && (text2.getText().equals("1")))
						{
							hardXPos = 1250;
							hardYPos = 490;
							vector = false;
							polar = true;
							//tutorial = false;
							hMazeP.repaint();
						}
						else if ((hardXPos == 1250)&&(hardYPos == 490)&&((text1.getText().equals("3"))&&(text2.getText().equals("180"))||(text1.getText().equals("-3"))&&(text2.getText().equals("0"))))
						{
							hardXPos = 650;
							hardYPos = 490;
							hMazeP.repaint();
						}
						else if ((hardXPos == 650)&&(hardYPos == 490)&&(((text1.getText().equals("1"))&&(text2.getText().equals("90")))||((text1.getText().equals("-1"))&&(text2.getText().equals("270")))))
						{
							hardXPos = 650;
							hardYPos = 370;
							vector = true;
							polar = false;
							hMazeP.repaint();
						}
						else if((hardXPos == 650) && (hardYPos == 370)&&(text1.getText().equals("-2")) && (text2.getText().equals("0")))
						{
							hardXPos = 250;
							hardYPos = 370;
							vector = false;
							polar = true;
							hMazeP.repaint();
						}
						else if ((hardXPos == 250)&&(hardYPos == 370)&&(((text1.getText().equals("2"))&&(text2.getText().equals("90")))||((text1.getText().equals("-2"))&&(text2.getText().equals("270")))))
						{
							hardXPos = 250;
							hardYPos = 130;
							vector = true;
							polar = false;
							hMazeP.repaint();
						}
						else if((hardXPos == 250) && (hardYPos == 130) && (text1.getText().equals("4")) && (text2.getText().equals("0")))
						{
							hardXPos = 1050;
							hardYPos = 130;
							vector = false;
							polar = true;
							hMazeP.repaint();
						}
						else if ((hardXPos == 1050)&&(hardYPos == 130)&&(((text1.getText().equals("1"))&&(text2.getText().equals("90")))||((text1.getText().equals("-1"))&&(text2.getText().equals("270")))))
						{
							hardXPos = 1050;
							hardYPos = 10;
							vector = false;
							polar = false;
							hMazeP.repaint();
						}
						else
						{
							polar = vector = false;
							hMazeP.repaint();
						}
						
					}
					tutorial = false;
					hControlP.repaint();
				}
			}
			
			class HardMazePanel extends JPanel implements MouseListener
			{
				private boolean end;
				
				public HardMazePanel()
				{
					setBackground(Color.WHITE);
					
					addMouseListener(this);
				}
				public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					
					g.setColor(Color.PINK);
					if(polar || vector)
					{
						for(int x = 95; x <= 1400; x+=200)
						{
							for(int y = 55; y <= 720; y+=120)
							{					
								g.fillOval(x, y, 10, 10);	
							}
						}
						
						g.setColor(Color.BLACK);
						
						
						int[]xArray1 = {400,400,1000,1000,1200,1200,1400,1400};
						int[]yArray1 = {0,120,120,0,0,240,240,0};
						g.fillPolygon(xArray1, yArray1, 8);
						
						int[]xArray2 = {1400,1000,1000,400,400,800,800,1400};
						int[]yArray2 = {360,360,240,240,360,360,480,480};
						g.fillPolygon(xArray2, yArray2, 8);
						
						int[]xArray3 = {1200,1200,600,600,400,400,200,200};
						int[]yArray3 = {720,600,600,480,480,600,600,720};
						g.fillPolygon(xArray3, yArray3, 8);
						
						g.fillRect(0,120, 200,360);
						
						g.drawLine(0,0,1400,0);
						g.drawLine(1400,0,1400,720);
						g.drawLine(1400,720,0,720);
						g.drawLine(0,720,0,0);
						
						g.drawImage(stickBoy, hardXPos, hardYPos, 100, 100, this);
						
						g.setFont(new Font("Monospaced", Font.BOLD, 50));
						g.setColor(Color.getHSBColor(0.3F ,0.5F, 1.0F));
						g.drawString("START", 1220, 710);
						g.setColor(Color.getHSBColor(0.3F ,0.5F, 1.0F));
						g.drawString("FINISH", 1010, 40);
					}
					else if ((hardXPos == 1050) && (hardYPos == 10))
					{
						g.setColor(Color.WHITE);
						g.drawRect(0,0,1400,720);
						
						g.setColor(Color.BLACK);
						g.setFont(new Font("Monospaced", Font.BOLD, 80));
						g.drawString("CONGRATULATIONS!", 400, 400);
						g.setFont(new Font("Monospaced", Font.BOLD, 20));
						g.drawString("click [HERE] to play again", 400, 450);
						end = true;
					}
					else
					{
						g.setColor(Color.WHITE);
						g.drawRect(0,0,1400,720);
						
						g.setColor(Color.BLACK);
						g.setFont(new Font("Monospaced", Font.BOLD, 80));
						g.drawString("SORRY!", 400, 400);
						g.setFont(new Font("Monospaced", Font.BOLD, 20));
						g.drawString("click [HERE] to try again", 400, 450);
						end = true;
					}
					
					if (tutorial)
					{
						g.setColor(Color.RED);
						g.setFont(new Font("Monospaced", Font.BOLD, 30));
						g.drawString("HINTS",1180,590);
						g.setFont(new Font("Monospaced", Font.BOLD, 50));
						g.drawString("^",1285,580);
						g.drawString("1",1287,600);
						//tutorial = false;
					}
					
					
				}
					
				public void mouseClicked(MouseEvent e){}
				public void mouseEntered(MouseEvent e){}
				public void mousePressed(MouseEvent e)
				{	
					if (end)
					{
						hardXPos = 1250;
						hardYPos = 610;
						
						polar = false;
						vector = true;
						tutorial = true;
						
						hMazeP.repaint();
						hControlP.repaint();
					}
				}
				public void mouseExited(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
			}
		}
	}
}