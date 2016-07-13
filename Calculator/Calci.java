package week13;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calci extends JFrame{
	
	public Calci()
	{
		
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4,0));
		
		
		//-------------------------------------------------------------------------------------------
		JPanel panel1 = new JPanel(new FlowLayout (5,5,5));
		
		final JTextField one = new JTextField(5);
		final JTextField two = new JTextField(5);
		final JTextField result = new JTextField(5);
		
		panel1.add(new JLabel("Number 1"));
		panel1.add(one);		
		panel1.add(new JLabel("Number 2"));
		panel1.add(two);	
		panel1.add(new JLabel("Result"));
		panel1.add(result);	
		
		frame.add(panel1);
		
		//-------------------------------------------------------------------------------------------
		
		JPanel panel2 = new JPanel(new FlowLayout (5,5,5));
		
		JButton add = new JButton("ADD");
		JButton subtract = new JButton("SUBTRACT");
		JButton multipy = new JButton("MUTIPLY");
		JButton divide = new JButton("DIVIDE");
		
		panel2.add(add);
		panel2.add(subtract);
		panel2.add(multipy);
		panel2.add(divide);
		
		frame.add(panel2);
		
		//-------------------------------------------------------------------------------------------
		
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent e)
			{
				double number1 = Double.parseDouble(one.getText());
				double number2 = Double.parseDouble(two.getText());
				double result_add = number1 + number2;
				result.setText(String.valueOf(result_add));
			}
		});
		
		subtract.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent e)
			{
				double number1 = Double.parseDouble(one.getText());
				double number2 = Double.parseDouble(two.getText());
				double result_subtract = number1 - number2;
				result.setText(String.valueOf(result_subtract));
			}
		});
		
		multipy.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent e)
			{
				double number1 = Double.parseDouble(one.getText());
				double number2 = Double.parseDouble(two.getText());
				double result_multiply = number1 * number2;
				result.setText(String.valueOf(result_multiply));
			}
		});
		
		divide.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent e)
			{
				double number1 = Double.parseDouble(one.getText());
				double number2 = Double.parseDouble(two.getText());
				double result_division = number1 + number2;
				result.setText(String.valueOf(result_division));
			}
		});
		
		//-------------------------------------------------------------------------------------------
		
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   	frame.setVisible(true);	
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Calci();
	}

}
