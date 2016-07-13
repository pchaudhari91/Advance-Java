package joinANDsyncro;


public class joinandsyncro {
	
	public static int count = 0;
	
	public static synchronized void incount()
	{
		count++;
	}
	
	public static void main (String[] args)
	{
	
		Thread newthread1 = new Thread (new Runnable() {
			
			public void run() 
			{
				
				for (int i=0; i<1000; i++)
					incount();
			}
		});
		
		Thread newthread2 = new Thread (new Runnable() {
			
			public void run() 
			{
				
				for (int i=0; i<1000; i++)
					incount();
			}
		});
		
		
		newthread1.start();
		newthread2.start();
		
		try {
			newthread1.join();
			newthread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);		
	}
}
