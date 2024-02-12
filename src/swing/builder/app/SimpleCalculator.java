package swing.builder.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalculator
{

	private JFrame frame;
	private JTextField textFieldNum1;
	private JTextField textFieldNum2;
	private JTextField textFieldAnswer;

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
					SimpleCalculator window = new SimpleCalculator();
					window.frame.setVisible(true);
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
	public SimpleCalculator()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("단순 게산기");
		frame.setBounds(100, 100, 432, 283);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldNum1 = new JTextField();
		textFieldNum1.setFont(new Font("굴림", Font.PLAIN, 15));
		textFieldNum1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum1.setBounds(28, 31, 164, 46);
		frame.getContentPane().add(textFieldNum1);
		textFieldNum1.setColumns(10);
		
		textFieldNum2 = new JTextField();
		textFieldNum2.setFont(new Font("굴림", Font.PLAIN, 15));
		textFieldNum2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum2.setColumns(10);
		textFieldNum2.setBounds(218, 31, 164, 46);
		frame.getContentPane().add(textFieldNum2);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, answer;
				
				num1 = Integer.parseInt(textFieldNum1.getText());
				num2 = Integer.parseInt(textFieldNum2.getText());
				answer = num1 + num2;
				textFieldAnswer.setText(answer+"");
				
			}			
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(64, 100, 91, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, answer;
				
				num1 = Integer.parseInt(textFieldNum1.getText());
				num2 = Integer.parseInt(textFieldNum2.getText());
				answer = num1 - num2;
				textFieldAnswer.setText(answer+"");
				
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1.setBounds(248, 100, 91, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("The Answer is : ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 172, 151, 28);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setFont(new Font("굴림", Font.BOLD, 15));
		textFieldAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAnswer.setBounds(218, 164, 164, 46);
		frame.getContentPane().add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
	}
}
