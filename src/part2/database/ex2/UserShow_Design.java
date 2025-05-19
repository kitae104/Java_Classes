package part2.database.ex2;

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
import javax.swing.JTable;

public class UserShow_Design {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSearch;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserShow_Design window = new UserShow_Design();
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
	public UserShow_Design() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("학생관리 시스템");
		frame.setBounds(100, 100, 497, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("학생 정보 확인");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_7 = new JLabel("학생 상세 정보 확인");
		lblNewLabel_1_7.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(12, 10, 153, 25);
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("학번 검색");
		lblNewLabel_1_7_1.setFont(new Font("D2Coding", Font.BOLD, 16));
		lblNewLabel_1_7_1.setBounds(12, 45, 91, 25);
		panel_1.add(lblNewLabel_1_7_1);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfSearch.setColumns(10);
		tfSearch.setBounds(100, 46, 234, 25);
		panel_1.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 16));
		btnSearch.setBounds(346, 41, 121, 35);
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 94, 455, 279);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
