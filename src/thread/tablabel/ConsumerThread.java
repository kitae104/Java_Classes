package thread.tablabel;

public class ConsumerThread extends Thread
{
	private MyLabel bar;

	public ConsumerThread(MyLabel bar)
	{
		this.bar = bar;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				sleep(100);
				bar.consume(); // 0.1초마다 바를 1씩 줄인다.
			} catch (InterruptedException e)
			{
				return;
			}
		}
	}
}
