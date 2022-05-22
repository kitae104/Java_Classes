package thread;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements Runnable, MouseListener{	

	private Thread th;
	private Container c;

	public MyFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);		
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.addMouseListener(this);
		
		setVisible(true);
		th = new Thread(this);
		th.start();
	}
		
	public static void main(String[] args) {
		new MyFrame("내 프레임", 300, 300);
	}

	@Override
	public void run()
	{
		Random rnd = new Random();
		while(true)
		{
			try
			{
				Thread.sleep(20);
			} 
			catch (InterruptedException e)
			{				
				return;				
			}
			int x = getX() + rnd.nextInt()%5;
			int y = getY() + rnd.nextInt()%5;
			setLocation(x, y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		try
		{
			if(th.isAlive()) {
				th.interrupt();
			} else {
				
			}
		} 
		catch (Exception e2)
		{
			// TODO: handle exception
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
