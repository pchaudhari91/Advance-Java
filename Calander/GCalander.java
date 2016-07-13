//package week 11;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;

public class GCalander {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Week 11 Homework");
		frame.setBounds(200, 200, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(10, 10));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(255,255,255)));
		panel2.setLayout(new GridLayout(1, 7, 0, 0));

		JLabel lb1 = new JLabel(" Sunday");
		panel2.add(lb1);
		JLabel lb2 = new JLabel(" Monday ");
		panel2.add(lb2);
		JLabel lb3 = new JLabel(" Tuesday ");
		panel2.add(lb3);
		JLabel lb4 = new JLabel(" Wendesday");
		panel2.add(lb4);
		JLabel lb5 = new JLabel(" Thursday");
		panel2.add(lb5);
		JLabel lb6 = new JLabel(" Friday");
		panel2.add(lb6);
		JLabel lb7 = new JLabel(" Saturday");
		panel2.add(lb7);
		panel.add(panel2, BorderLayout.SOUTH);


		JPanel panel3 = new JPanel();
		GregorianCalendar calendar = new GregorianCalendar();
		JLabel lb8 = new JLabel((calendar.get(Calendar.MONTH) + 1)
		                + "/" + calendar.getWeekYear());

		panel3.add(lb8);
		panel.add(panel3, BorderLayout.NORTH);

		JPanel panel4 = new JPanel();
		panel4.setBorder(new LineBorder(new Color(255, 255, 255)));
		frame.getContentPane().add(panel4, BorderLayout.CENTER);

		panel4.setLayout(new GridLayout(0, 7, 0, 0));

		int j = calendar.get(Calendar.DAY_OF_WEEK);
		for (int i = 0; i<= calendar.getActualMaximum(Calendar.DATE) + j; i++) {
		if (i<= j) {
		JLabel label = new JLabel(" ");
		panel4.add(label);
		            } else {
		JLabel label = new JLabel(" " + (i - j));
		label.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel4.add(label);
		            }
		        }
		frame.setVisible(true);
		    }

}
