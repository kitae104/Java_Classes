package swing.builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TextAreaEx extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfInput;

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
					TextAreaEx frame = new TextAreaEx();
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
	public TextAreaEx()
	{
		setTitle("텍스트 영역 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea taChat = new JTextArea();
		taChat.setFont(new Font("Monospaced", Font.PLAIN, 16));
		taChat.setBounds(12, 10, 412, 458);
		contentPane.add(taChat);
		
		tfInput = new JTextField();
		tfInput.setFont(new Font("굴림", Font.PLAIN, 14));
		tfInput.setBounds(12, 478, 288, 44);
		contentPane.add(tfInput);
		tfInput.setColumns(10);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(312, 483, 112, 34);
		contentPane.add(btnAdd);
	}
}
