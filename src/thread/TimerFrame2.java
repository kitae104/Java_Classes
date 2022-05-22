package thread;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimerFrame2 extends JFrame
{
	private JLabel timerLabel;
	
	public TimerFrame2(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);		 
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		add(timerLabel);
		
		TimerRunnable tr = new TimerRunnable(timerLabel);
		Thread th = new Thread(tr);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args)
	{
		new TimerFrame2("타이머 Runnable", 250, 150); 
	}
}
