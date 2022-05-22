package thread.stopwatch;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerButton extends JFrame implements ActionListener
{
	private JLabel timerLabel;
	private JPanel buttonPanel;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread th;
	
	public TimerButton(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);		 
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		add(timerLabel);
		
		setButtonPanel();
		
		setVisible(true);		
	}

	private void setButtonPanel()
	{
		buttonPanel = new JPanel();
		
		btnStart = new JButton("START");
		btnStart.addActionListener(this);
		
		btnStop = new JButton("STOP");
		btnStop.addActionListener(this);
		
		buttonPanel.add(btnStart);
		buttonPanel.add(btnStop);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args)
	{
		new TimerButton("타이머", 250, 200); 
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object obj = e.getSource();
		
		if(obj == btnStart) {
			th = new TimerThread(timerLabel);
			th.start();
		} else if(obj == btnStop) {
			th.interrupt();
		}
		
	}
}
