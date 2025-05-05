package part2.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TextAreaEx extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfInput;
	private JTextArea taChat;
	private JScrollPane scrollPane;

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
					TextAreaEx frame = new TextAreaEx("타이틀");
					frame.setLocationRelativeTo(null);
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
	public TextAreaEx(String title)
	{
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 412, 458);
		contentPane.add(scrollPane);
		
		taChat = new JTextArea();
		taChat.setLineWrap(true);
		
		scrollPane.setViewportView(taChat);
		taChat.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		tfInput = new JTextField();
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		tfInput.setFont(new Font("굴림", Font.PLAIN, 14));
		tfInput.setBounds(12, 478, 288, 44);
		contentPane.add(tfInput);
		tfInput.setColumns(10);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}			
		});
		btnAdd.setBounds(312, 483, 112, 34);
		contentPane.add(btnAdd);
	}
	
	private void sendMessage()
	{
		String msg = tfInput.getText();
		taChat.append(msg + "\n");
		tfInput.setText("");
		tfInput.setFocusable(true);
		tfInput.requestFocus();
	}
}
