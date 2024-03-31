package swing.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class BasicComponents extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDisplay;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
					BasicComponents frame = new BasicComponents();
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
	public BasicComponents()
	{
		setTitle("기본 컴포넌트 익히기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 805);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnButton = new JButton("버튼");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisplay.setText("버튼");
			}
		});
		btnButton.setBounds(85, 83, 122, 40);
		contentPane.add(btnButton);
		
		lblDisplay = new JLabel("");
		lblDisplay.setOpaque(true);
		lblDisplay.setBackground(new Color(192, 192, 192));
		lblDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplay.setBounds(239, 83, 136, 40);
		contentPane.add(lblDisplay);
		
		JCheckBox chckbxApple = new JCheckBox("사과(100)");
		chckbxApple.setBounds(85, 167, 94, 23);
		contentPane.add(chckbxApple);
		
		JCheckBox chckbxPear = new JCheckBox("배(500)");
		chckbxPear.setBounds(183, 167, 91, 23);
		contentPane.add(chckbxPear);
		
		JCheckBox chckbxCherry = new JCheckBox("체리(1000)");
		chckbxCherry.setBounds(278, 167, 97, 23);
		contentPane.add(chckbxCherry);
		
		JLabel lblResult = new JLabel("");
		lblResult.setOpaque(true);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBackground(Color.LIGHT_GRAY);
		lblResult.setBounds(85, 196, 290, 40);
		contentPane.add(lblResult);
		
		JRadioButton rdbtnWoman = new JRadioButton("여자");
		rdbtnWoman.setSelected(true);
		buttonGroup.add(rdbtnWoman);
		rdbtnWoman.setBounds(85, 267, 113, 23);
		contentPane.add(rdbtnWoman);
		
		JRadioButton rdbtnMan = new JRadioButton("남자");
		buttonGroup.add(rdbtnMan);
		rdbtnMan.setBounds(239, 267, 113, 23);
		contentPane.add(rdbtnMan);
	}
}
