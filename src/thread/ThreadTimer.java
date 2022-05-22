package thread;

import javax.swing.JLabel;

public class ThreadTimer extends Thread
{
	@Override
	public void run()
	{
		int n = 0;
		
		while(true)
		{
			System.out.println(n);
			n++;
			
			try
			{
				sleep(5);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
				return;
			}
		}
	}
	
	
}
