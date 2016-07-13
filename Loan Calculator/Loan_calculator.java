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
import javax.swing.SwingConstants;

public class Loan_calculator {
	
	public Loan_calculator()
	{
		
		JFrame frame=new JFrame("Future Value");
		frame.setLayout(new GridLayout(2,0));

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,0));
		frame.setVisible(true);
	    
	    JPanel panel1 = new JPanel(new GridLayout (4,2));
	    
	    JLabel amount_label =new JLabel("Investment Amount");
	    JLabel years_label =new JLabel("Years");
	    final JLabel ROI=new JLabel("Annual Interest Rate");
	    JLabel value_label=new JLabel("Future Value");
	    
	    final JTextField amount_field=new JTextField(SwingConstants.RIGHT);
	    final JTextField years_field=new JTextField(SwingConstants.RIGHT);
	    final JTextField ROI_field=new JTextField(SwingConstants.RIGHT);
	    final JTextField value_field=new JTextField(SwingConstants.RIGHT);
	    value_field.setEditable(false);
	    
	    panel1.add(amount_label);
	    panel1.add(amount_field);
	    panel1.add(years_label);
	    panel1.add(years_field);
	    panel1.add(ROI);
	    panel1.add(ROI_field);
	    panel1.add(value_label);
	    panel1.add(value_field);
	    
	    frame.add(panel1);
	    
	    //--------------------------------------------------------------------------------------------------------
	    
	    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    
	    JButton calculate = new JButton("CALCULATE");
	    panel2.add(calculate);
	    
	    frame.add(panel2);
	    
	  //--------------------------------------------------------------------------------------------------------
	    
	    calculate.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		double annual_ROI = Double.parseDouble(ROI_field.getText());
	    		double monthly_ROI = annual_ROI/12;
	    		double years = Double.parseDouble(years_field.getText());
	    		double investment = Double.parseDouble(amount_field.getText());
	    		double value_future = investment * Math.pow(1.0 + monthly_ROI, years*12);
	    		value_field.setText(String.format("%.2f", value_future));
	    	}
	    	
	    });
	    
	    
	    
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Loan_calculator();
	}

}
