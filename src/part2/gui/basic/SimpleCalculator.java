package part2.gui.basic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalculator
{

	private JFrame frame;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfResult;

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
				} catch(Exception e)
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(51, 51, 116, 21);
		frame.getContentPane().add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(205, 51, 116, 21);
		frame.getContentPane().add(tfNum2);
		tfNum2.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(51, 100, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MINUS");
		btnNewButton_1.setBounds(205, 100, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		tfResult = new JTextField();
		tfResult.setBounds(205, 166, 116, 21);
		frame.getContentPane().add(tfResult);
		tfResult.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Result :");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel.setBounds(73, 169, 75, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
