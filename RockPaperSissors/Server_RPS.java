package RockPaperSissors;

import java.awt.Panel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import tuctactoe.Constants;
//import tuctactoe.HandleASession;

public class Server_RPS extends JFrame implements Constants_RPS{
		
		
	public static void main(String[] args)
	{
		new Server_RPS();
		
	}
	
	
	Server_RPS()
	{
		
		JFrame frame = new JFrame();
		Panel newpanel = new Panel();
		
	//	JLabel textlabel = new JLabel("Server started");
		JTextArea Log = new JTextArea();
		
		newpanel.add(Log);
		frame.add(newpanel);
		
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   	frame.setVisible(true);	
	   	
	   	
	   	//----------------------------------------------------------------------------
	   	
	   	try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            Log.append(new Date()
                    + ": Server started at socket 8000\n");

            // Number a session
            int sessionNo = 1;

            // Ready to create a session for every two players
            while (true) {
                Log.append(new Date()
                        + ": Wait for players to join session " + sessionNo + '\n');

                // Connect to player 1
                Socket player1 = serverSocket.accept();

                Log.append(new Date() + ": Player 1 joined session "
                        + sessionNo + '\n');
                Log.append("Player 1's IP address"
                        + player1.getInetAddress().getHostAddress() + '\n');

                // Notify that the player is Player 1
                new DataOutputStream(
                        player1.getOutputStream()).writeInt(PLAYER1);
                
               

                // Connect to player 2
                Socket player2 = serverSocket.accept();

                Log.append(new Date()
                        + ": Player 2 joined session " + sessionNo + '\n');
                Log.append("Player 2's IP address"
                        + player2.getInetAddress().getHostAddress() + '\n');

                // Notify that the player is Player 2
                new DataOutputStream(
                        player2.getOutputStream()).writeInt(PLAYER2);

                // Display this session and increment session number
                Log.append(new Date() + ": Start a thread for session "
                        + sessionNo++ + '\n');

                // Create a new thread for this session of two players
                HandleASession task = new HandleASession(player1, player2);

                // Start the new thread
                new Thread(task).start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

	 
	
	//-------------------------------------------------------------------------------------
	
	class HandleASession implements Runnable, Constants {

	    private Socket player1;
	    private Socket player2;

	    // Create and initialize cells
	    private char[][] cell = new char[3][3];

	    private DataInputStream fromPlayer1;
	    private DataOutputStream toPlayer1;
	    private DataInputStream fromPlayer2;
	    private DataOutputStream toPlayer2;

	    
	    public HandleASession(Socket player1, Socket player2) {
	        this.player1 = player1;
	        this.player2 = player2;

	       
	    }
	    
	    
	    public void run() {
	        try {
	            // Create data input and output streams
	        	
	            DataInputStream fromPlayer1 = new DataInputStream(
	                    player1.getInputStream());
	            DataOutputStream toPlayer1 = new DataOutputStream(
	                    player1.getOutputStream());
	            DataInputStream fromPlayer2 = new DataInputStream(
	                    player2.getInputStream());
	            DataOutputStream toPlayer2 = new DataOutputStream(
	                    player2.getOutputStream());
	        	
//	        	Scanner fromplayer1 = new Scanner (player1.getInputStream());
	//            Scanner fromplayer2 = new Scanner (player2.getInputStream());
	            
//	            PrintStream toplayer1 = new PrintStream (player1.getOutputStream());
	//            PrintStream toplayer2 = new PrintStream (player2.getOutputStream());
	            
	            int temp = 0;
	            
	            String choice = null;
	    		
	    		switch(temp)
	    		{
	    		case 1: 
	    				choice = "rock";
	    				break;
	    				
	    		case 2: 
	    				choice = "paper";
	    				break;
	    			
	    		case 3: 
	    				choice = "sissors";
	    				break;
	    				
	    		default:
	    				break;
	    		
	    		}
	    		
	            
	            if (isValid(choice))
		        {
		            int player1 = getVal(choice);
		         
		           // System.out.print(aichoice+"\n");
		            
		            int player2 = getVal(choice);
		            
		           // System.out.print(personal_choice+"\n");
		            
		            int result = ifWin(player1, player2);
		            
		            //toplayer2.println(result);
		            toPlayer2.write(result);
		        }
		        else
		        {
		            int result = 5; // 5= wrong input
		            
		            //toplayer2.print(result);
		            toPlayer2.writeInt(result);
		        }
	
	
	        }
	        catch(Exception e)
	        {}
	    
	        }
	    }
	   	
	        
	        public static boolean isValid(String choice)
		    {
		        if (choice.equalsIgnoreCase("rock"))
		        
		            return true;
		        if (choice.equalsIgnoreCase("paper"))
		            return true;
		        if (choice.equalsIgnoreCase("sissors"))
		            return true;
		        else 
		            return false;
		        
		    }
		    
		    public static int getVal(String choice)
		    {
		        if (choice.equalsIgnoreCase("rock"))
		            return 0;
		        if (choice.equalsIgnoreCase("paper"))
		            return 1;
		        else 
		            return 2;
		    }
		    
		    
		    public static int ifWin(int p_choice, int c_choice)
		    {
		    	
		    	
		    	int result =0;
		    	
		        if (p_choice == 0)
		        {
		            if (c_choice != 1)
		            {
		                if (c_choice != 0)
		                {
		                    return 1; // win =1;
		                }
		                    return 2; // tie =2
		            }
		            return 3; // loose =3
		        }
		        
		        
		        // 
		        
		        if (p_choice == 1)
		        {
		            if (c_choice != 0)
		            {
		                if (c_choice != 1)
		                {
		                    return 1;
		                }
		                    return 2;
		            }
		            return 3;
		        }
		        
		        //
		        
		        if (p_choice == 2)
		        {
		            if (c_choice != 0)
		            {
		                if (c_choice != 2)
		                {
		                    return 1;
		                }
		                    return 2;
		            }
		            return 3;
		        }
		        
		        return 4; // 4 = unknown
		        
		    }

		
	}
	

