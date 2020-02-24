import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class WhirligigJRB extends JPanel implements ActionListener
{
	private JRadioButton opt1,opt2,opt3,opt4;
	private JButton button;
	private JLabel answer;
	private ButtonGroup bg;
	private String sel;
	
	public WhirligigJRB()
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
	
		setLayout(new GridLayout(8,1));
		
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
		/*String command = evt.getActionCommand();
		String terminate = button.getText();*/
		
		if (evt.getActionCommand().equals("Submit Answer")){
		{
			if (sel.equals("Increased risk of diabetes and cancer"))
				answer.setText("CORRECT!");
			else
				answer.setText("Incorrect");
		} 
		
		else
			sel = evt.getActionCommand();
	}
}