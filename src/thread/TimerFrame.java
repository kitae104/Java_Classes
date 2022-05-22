package thread;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import thread.stopwatch.TimerThread;

public class TimerFrame extends JFrame
{
	private JLabel timerLabel;
	
	public TimerFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);		 
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args)
	{
		new TimerFrame("타이머", 250, 150); 
	}
}
