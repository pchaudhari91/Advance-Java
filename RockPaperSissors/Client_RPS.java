package RockPaperSissors;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_RPS extends JFrame
implements Runnable, Constants_RPS {

	
	int choice =0;
	private DataInputStream fromServer;
    private DataOutputStream toServer;
    private String host = "localhost";
    
    Scanner fromserver ;
	
	PrintStream toserver ;
    
    
    
    
	Client_RPS()
	{
	
		JFrame frame = new JFrame();
		//frame.setLayout(new GridLayout(2,10));
		// frame = new JFrame("Java Swing Examples");
	      frame.setSize(300,150);
	    //  frame.setLayout(new GridLayout(3, 1));
		
		
		final JLabel statusLable = new JLabel ("");
		
		JPanel panel = new JPanel();
		
		final JRadioButton rock = new JRadioButton("Rock");
		final JRadioButton paper = new JRadioButton("Paper");
		final JRadioButton sissors = new JRadioButton("Sissors");
		final JLabel rock_label = new JLabel("You selected rock!");
		final JLabel paper_label = new JLabel("You selected paper!");
		final JLabel sissors_label = new JLabel("You selected sissors!");
		
		
		 ButtonGroup group = new ButtonGroup();
	      group.add(rock);
	      group.add(paper);
	      group.add(sissors);
		
		
		
		panel.add(rock);
		panel.add(paper);
		panel.add(sissors);
		panel.add(statusLable);
		
		
		frame.add(panel);
		
	//	final int choice;
		
		
		//------------------------------------------------Rock-----------------------------------------------------
		
		
		rock.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent event) 
			{
				
				statusLable.setText("You selected rock");
				choice =1;
			}
		});
		
		
		//------------------------------------------------Paper-----------------------------------------------------
		
		paper.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent event) 
			{
				
				statusLable.setText("You selected paper");
				choice =2;
			}
		});
		
		//------------------------------------------------Sissors-----------------------------------------------------
		
		sissors.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent event) 
			{
						
				statusLable.setText("You selected paper");
				choice = 3;
			}
		});
		
		
		
		
		//setLayout(new BorderLayout());
	//	add(panel, BorderLayout.WEST);
		//add(jlbPicture, BorderLayout.CENTER);
	//	setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		 
		
		
		
		
	//	frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   	frame.setVisible(true);	
		
	    connectToServer();
		
	}
	
	
	private void connectToServer() {
        try {
            // Create a socket to connect to the server
            Socket socket;
            socket = new Socket(host, 8000);

            fromserver = new Scanner (socket.getInputStream());
            
            toserver = new PrintStream(socket.getOutputStream());
            
            // Create an input stream to receive data from the server
        //    fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
        //    toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.err.println(ex);
        }

        // Control the game on a separate thread
        Thread thread = new Thread(this);
        thread.start();
    }
	
	
	public void run()
	{
		
		switch (choice)
		{
			case 1 : // Rock
				//	System.out.println("\nYou entered Rock ");
					//print.println(1);
					toserver.write(1);
					break;
		
			case 2 : // Paper
					//System.out.println("\nYou entered Paper ");
					//print.println(2);
					toserver.write(2);
					break;
					
			case 3 : // Sissors
					//System.out.println("\nYou entered Sissors ");
					//print.println(3);
					toserver.write(3);
					break;
					
			default : break;
					
		}
	}
	
	
}
