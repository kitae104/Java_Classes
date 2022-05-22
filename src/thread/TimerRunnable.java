package thread;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable
{
	private JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel)
	{
		this.timerLabel = timerLabel;
	}

	@Override
	public void run()
	{
		int n = 0;
		
		while(true)
		{
			timerLabel.setText(n + "");
			n++;
			
			try
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
				return;
			}
		}
	}
	
	
}
