package part2.gui.gugudan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame
{

	private JPanel contentPane;

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
					MainFrame frame = new MainFrame();
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
	public MainFrame()
	{
		setTitle("프로그램 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("첫번째 버튼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1111");
				GuGuDan gugudan = new GuGuDan();
				gugudan.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(151, 48, 161, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("두번째 버튼");
		btnNewButton_2.setBounds(151, 119, 161, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("세번째 버튼");
		btnNewButton.setBounds(151, 190, 161, 23);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
	}

}
