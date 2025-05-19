package part2.database.ex3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfo {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfDept;
	private JTextField tfNum;
	private JTextField tfScore;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo window = new UserInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("학생관리 시스템");
		frame.setBounds(100, 100, 343, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("학생 데이터 입력");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("이름");
		lblNewLabel_1_1.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(44, 73, 99, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("학과");
		lblNewLabel_1_2.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(44, 108, 99, 25);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("학번");
		lblNewLabel_1_3.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(44, 143, 99, 25);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("학년");
		lblNewLabel_1_4.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(44, 178, 99, 25);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("학점");
		lblNewLabel_1_5.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(44, 219, 99, 25);
		panel_1.add(lblNewLabel_1_5);
		
		tfName = new JTextField();
		tfName.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfName.setBounds(155, 73, 135, 25);
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		tfDept = new JTextField();
		tfDept.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfDept.setColumns(10);
		tfDept.setBounds(155, 108, 135, 25);
		panel_1.add(tfDept);
		
		tfNum = new JTextField();
		tfNum.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfNum.setColumns(10);
		tfNum.setBounds(155, 143, 135, 25);
		panel_1.add(tfNum);
		
		tfScore = new JTextField();
		tfScore.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfScore.setColumns(10);
		tfScore.setBounds(155, 219, 135, 25);
		panel_1.add(tfScore);
		
		JComboBox cbGrade = new JComboBox();
		cbGrade.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cbGrade.setFont(new Font("D2Coding", Font.BOLD, 16));
		cbGrade.setBounds(155, 180, 135, 25);
		panel_1.add(cbGrade);
		
		JRadioButton rdWoman = new JRadioButton("여성");
		rdWoman.setFont(new Font("D2Coding", Font.BOLD, 16));
		buttonGroup.add(rdWoman);
		rdWoman.setBounds(232, 266, 58, 23);
		panel_1.add(rdWoman);
		
		JRadioButton rdMan = new JRadioButton("남성");
		rdMan.setFont(new Font("D2Coding", Font.BOLD, 16));
		buttonGroup.add(rdMan);
		rdMan.setBounds(155, 266, 58, 23);
		panel_1.add(rdMan);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("성별");
		lblNewLabel_1_6_2.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_6_2.setBounds(44, 265, 99, 25);
		panel_1.add(lblNewLabel_1_6_2);
		
		JButton btnAdd = new JButton("정보 추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String insertSQL = "INSERT INTO member (name, dept, code, grade, score, gender) VALUES (?, ?, ?, ?, ?, ?)";
				int result = DB.executeUpdate(insertSQL, 
						tfName.getText(), 
						tfDept.getText(), 
						tfNum.getText(), 
						Integer.parseInt(cbGrade.getSelectedItem().toString()), 
						Double.parseDouble(tfScore.getText()), 
						rdMan.isSelected() ? "남성" : "여성");
				if (result > 0) {
					JOptionPane.showMessageDialog(frame, "데이터 입력 성공");
					tfName.setText("");
					tfDept.setText("");
					tfNum.setText("");
					tfScore.setText("");
					cbGrade.setSelectedIndex(0);
					rdMan.setSelected(true);
				} else {
					JOptionPane.showMessageDialog(frame, "데이터 입력 실패");
				}
			}
		});
		btnAdd.setFont(new Font("D2Coding", Font.BOLD, 16));
		btnAdd.setBounds(44, 313, 234, 53);
		panel_1.add(btnAdd);
	}
}
