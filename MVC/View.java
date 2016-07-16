/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Prerana
 */
public class View extends JFrame{
    
    
    private JTextField numberOne = new JTextField(10);
    private JTextField numberTwo = new JTextField(10);
    private JButton calculatebutton = new JButton("Add");
    private JLabel additionlable = new JLabel ("+");
    private JTextField displayresultlable = new JTextField(10);
    
    View()
    {
    
        JPanel panel = new JPanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        
        panel.add(numberOne);
        panel.add(additionlable);
        panel.add(numberTwo);
        panel.add(calculatebutton);
        panel.add(displayresultlable);
        
        this.add(panel);
        
    }
    
    public int getnumberOne()
    {
        return Integer.parseInt(numberOne.getText());
    }
    
    public int getnumberTwo()
    {
        return Integer.parseInt(numberTwo.getText());
    }
    
    public int getcalculatesolution()
    {
        return Integer.parseInt(displayresultlable.getText());
    }
    
    public void setresult( int finalvalue)
    {
        displayresultlable.setText(Integer.toString(finalvalue));
    }
    
    void calculationlistener(ActionListener listenerforbutton)
    {
        calculatebutton.addActionListener(listenerforbutton);
    }
    
    void errormessage(String errormsg)
    {
        JOptionPane.showMessageDialog(this, errormsg);
    }
  
}
