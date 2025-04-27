package part2.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class CheckBoxEvent extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int sum;
	private JLabel lblResult;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	ImageIcon [] image = { 
			new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\src\\part2\\images\\apple.jpg"), 
			new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\src\\part2\\images\\pear.jpg"),
			new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\src\\part2\\images\\cherry.jpg")};
	
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
					CheckBoxEvent frame = new CheckBoxEvent();
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
	public CheckBoxEvent()
	{
		setTitle("과일값 계산하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("사과 100원, 배 500원, 체리 1000원");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 31, 274, 28);
		contentPane.add(lblNewLabel);
		
		sum = 0; 
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("사과");
		chckbxNewCheckBox.addItemListener(new ItemListener() {			

			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					sum += 100;
				} else {
					sum -= 100;
				}
				lblResult.setText("현재 " + sum + "원 입니다.");
			}
		});
		chckbxNewCheckBox.setBorderPainted(true);
		chckbxNewCheckBox.setBounds(28, 89, 107, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("배");
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					sum += 500;
				} else {
					sum -= 500;
				}
				lblResult.setText("현재 " + sum + "원 입니다.");
			}
		});
		chckbxNewCheckBox_1.setBorderPainted(true);
		chckbxNewCheckBox_1.setBounds(163, 89, 107, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("체리");
		chckbxNewCheckBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					sum += 1000;
				} else {
					sum -= 1000;
				}
				lblResult.setText("현재 " + sum + "원 입니다.");
			}
		});
		chckbxNewCheckBox_2.setBorderPainted(true);
		chckbxNewCheckBox_2.setBounds(298, 89, 107, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		lblResult = new JLabel("현재 0원 입니다.");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("굴림", Font.BOLD, 14));
		lblResult.setBounds(86, 149, 274, 28);
		contentPane.add(lblResult);
		
		
		
		JRadioButton rdbtnMan = new JRadioButton("남자");
		rdbtnMan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					lblResult.setText("남자 선택");
				} 
			}
		});
		rdbtnMan.setSelected(true);
		buttonGroup.add(rdbtnMan);
		rdbtnMan.setBounds(22, 204, 113, 23);
		contentPane.add(rdbtnMan);
		
		JRadioButton rdbtnWoman = new JRadioButton("여자");
		rdbtnWoman.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					lblResult.setText("여자 선택");
				} 
			}
		});
		buttonGroup.add(rdbtnWoman);
		rdbtnWoman.setBounds(163, 204, 113, 23);
		contentPane.add(rdbtnWoman);
		
		
	}
}
