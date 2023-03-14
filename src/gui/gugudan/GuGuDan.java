package gui.gugudan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuGuDan extends JFrame
{

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea textArea;

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
					GuGuDan frame = new GuGuDan();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuGuDan()
	{
		setTitle("구구단 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(33, 37, 199, 38);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btnNewButton = new JButton("구구단");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText();
				int dan = Integer.parseInt(str);
				textArea.setText("");
				textArea.append("=================================\n");
				textArea.append("\t" + dan + " 단\n");
				textArea.append("=================================\n");
				
				
			}
		});
		btnNewButton.setBounds(244, 36, 102, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnNewButton_1.setBounds(358, 37, 91, 38);
		contentPane.add(btnNewButton_1);
		
		textArea = new JTextArea();
		textArea.setBounds(35, 98, 414, 229);
		//contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(33, 121, 416, 208);
		contentPane.add(scrollPane);
		
		setLocationRelativeTo(null);
		
	}
}
