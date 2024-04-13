package swing.builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Frame1
{

	private JFrame frmGui;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Frame1 window = new Frame1();
					window.frmGui.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmGui = new JFrame();
		frmGui.setTitle("첫번째 GUI 프로그램");
		frmGui.setBounds(100, 100, 674, 486);
		frmGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGui.getContentPane().setLayout(null);
		frmGui.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Show Message");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmGui, "첫번째 자바 Swing 프로그램");
				lblMessage.setText("첫번째 자바 Swing 프로그램");
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.setBounds(250, 190, 159, 38);
		frmGui.getContentPane().add(btnNewButton);
		
		lblMessage = new JLabel("Message : ");
		lblMessage.setBounds(155, 89, 350, 15);
		frmGui.getContentPane().add(lblMessage);
	}
}
