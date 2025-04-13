package part2.components;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class LabelEx extends JFrame
{

	private static final long serialVersionUID = 1L;
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
					LabelEx frame = new LabelEx();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public LabelEx()
	{
		setResizable(false);
		setTitle("레이블 예");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 600);
		getContentPane().setLayout(new FlowLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인하공전 컴퓨터시스템공학과");
		lblNewLabel.setBounds(115, 10, 197, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 35, 400, 400);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\beauty.jpg"));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("보고싶으면 전화하세요");
		btnNewButton.setIcon(new ImageIcon("images\\normalIcon.gif"));
		btnNewButton.setRolloverIcon(new ImageIcon("images\\rolloverIcon.gif"));
		btnNewButton.setPressedIcon(new ImageIcon("images\\pressedIcon.gif"));
		btnNewButton.setBounds(83, 459, 229, 80);
		contentPane.add(btnNewButton);
	}
}
