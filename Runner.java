import javax.swing.*;

public class Runner extends JFrame
{
	
	public static void main(String[] args)
	{
		new Runner();
	}
	
	public Runner()
	{
		super("Runner");
		
		JFrame frame = new JFrame("Runner");
		frame.setSize(350,500);		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		BigWhirligig bigwhirl = new BigWhirligig();// allows the user to close the frame
		frame.getContentPane().add(bigwhirl);
		frame.setVisible(true);		// makes the frame visible
		frame.setLocation(500,100);	// Sets the coordinates of the frame
		frame.setResizable(false);
	}
}
