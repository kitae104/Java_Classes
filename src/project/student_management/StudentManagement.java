package project.student_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
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

public class StudentManagement {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfDept;
	private JTextField tfNum;
	private JTextField tfScore;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSearch;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement window = new StudentManagement();
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
	public StudentManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("학생관리 시스템");
		frame.setBounds(100, 100, 871, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("학생 관리 시스템");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("추가 / 수정 ");
		lblNewLabel_1.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1.setBounds(44, 38, 99, 25);
		panel_1.add(lblNewLabel_1);
		
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
		
		JLabel lblNewLabel_1_6 = new JLabel("상태");
		lblNewLabel_1_6.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(44, 254, 99, 25);
		panel_1.add(lblNewLabel_1_6);
		
		JCheckBox ckScholarship = new JCheckBox("장학생");
		ckScholarship.setFont(new Font("D2Coding", Font.BOLD, 16));
		ckScholarship.setBounds(155, 337, 107, 23);
		panel_1.add(ckScholarship);
		
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
		
		JComboBox cbState = new JComboBox();
		cbState.setModel(new DefaultComboBoxModel(new String[] {"재학", "휴학", "졸업"}));
		cbState.setFont(new Font("D2Coding", Font.BOLD, 16));
		cbState.setBounds(155, 256, 135, 25);
		panel_1.add(cbState);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("특이사항");
		lblNewLabel_1_6_1.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_6_1.setBounds(44, 335, 99, 25);
		panel_1.add(lblNewLabel_1_6_1);
		
		JCheckBox ckDormitory = new JCheckBox("기숙사");
		ckDormitory.setFont(new Font("D2Coding", Font.BOLD, 16));
		ckDormitory.setBounds(155, 373, 107, 23);
		panel_1.add(ckDormitory);
		
		JRadioButton rdWoman = new JRadioButton("여성");
		rdWoman.setFont(new Font("D2Coding", Font.BOLD, 16));
		buttonGroup.add(rdWoman);
		rdWoman.setBounds(232, 295, 58, 23);
		panel_1.add(rdWoman);
		
		JRadioButton rdMan = new JRadioButton("남성");
		rdMan.setFont(new Font("D2Coding", Font.BOLD, 16));
		buttonGroup.add(rdMan);
		rdMan.setBounds(155, 295, 58, 23);
		panel_1.add(rdMan);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("성별");
		lblNewLabel_1_6_2.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_6_2.setBounds(44, 294, 99, 25);
		panel_1.add(lblNewLabel_1_6_2);
		
		JButton btnAdd = new JButton("정보 추가");
		btnAdd.setFont(new Font("D2Coding", Font.BOLD, 16));
		btnAdd.setBounds(54, 417, 234, 35);
		panel_1.add(btnAdd);
		
		JLabel lblNewLabel_1_7 = new JLabel("학생 상세 정보 확인");
		lblNewLabel_1_7.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(369, 38, 153, 25);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("학번 검색");
		lblNewLabel_1_7_1.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_7_1.setBounds(369, 73, 91, 25);
		panel_1.add(lblNewLabel_1_7_1);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfSearch.setColumns(10);
		tfSearch.setBounds(457, 74, 234, 25);
		panel_1.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 16));
		btnSearch.setBounds(703, 69, 121, 35);
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 122, 455, 330);
		panel_1.add(scrollPane);
		
		JTextArea taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
		
		JRadioButton rdInsert = new JRadioButton("추가");
		buttonGroup_1.add(rdInsert);
		rdInsert.setFont(new Font("D2Coding", Font.BOLD, 16));
		rdInsert.setBounds(155, 40, 58, 23);
		panel_1.add(rdInsert);
		
		JRadioButton rdUpdate = new JRadioButton("수정");
		buttonGroup_1.add(rdUpdate);
		rdUpdate.setFont(new Font("D2Coding", Font.BOLD, 16));
		rdUpdate.setBounds(232, 40, 58, 23);
		panel_1.add(rdUpdate);
	}
}
