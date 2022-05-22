package thread;

public class ThreadTest
{

	public static void main(String[] args)
	{
		int n = 0;
		ThreadTimer tt = new ThreadTimer();
		tt.start();
		for (int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tt.interrupt();
	}

}
