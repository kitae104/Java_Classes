package part2.database.ex3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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

public class UserShow {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSearch;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table;
	private DefaultTableModel tableModel;
	private JComboBox cbSelect;

	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserShow window = new UserShow();
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
	public UserShow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("학생관리 시스템");
		frame.setBounds(100, 100, 497, 348);
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
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("D2Coding", Font.BOLD, 16));
		tfSearch.setColumns(10);
		tfSearch.setBounds(100, 45, 252, 25);
		panel_1.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectItem = cbSelect.getSelectedItem().toString();
				String searchText = tfSearch.getText();
				System.out.println(selectItem + " : " + searchText);
				
				String sql = "SELECT id, name, dept, code, grade, score, gender FROM member "
						+ "WHERE " + selectItem + " LIKE '%" + searchText + "%' "
						+ "ORDER BY id";
				loadTableData(sql);
				
			}
		});
		btnSearch.setFont(new Font("D2Coding", Font.BOLD, 16));
		btnSearch.setBounds(364, 45, 93, 25);
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 94, 455, 158);
		panel_1.add(scrollPane);
		
		tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		cbSelect = new JComboBox();
		cbSelect.setModel(new DefaultComboBoxModel(new String[] {"이름", "학과", "학번", "학년"}));
		cbSelect.setBounds(12, 47, 76, 23);
		panel_1.add(cbSelect);
		
		String sql = "SELECT id, name, dept, code, grade, score, gender FROM member ORDER BY id";
		loadTableData(sql); // 최초 로딩
	}
	
	private void loadTableData(String sql) {
        try {
            // 컬럼 설정 (예: id, name, email)
//            String[] columnNames = {"ID", "이름", "학과", "학번", "학년", "학점", "성별"};
//            tableModel.setColumnIdentifiers(columnNames);
//            tableModel.setRowCount(0); // 기존 데이터 삭제

            
            ResultSet rs = DB.getResultSet(sql);

            if(rs != null) {
            	ResultSetMetaData metaData = rs.getMetaData();	// 메타데이터 가져오기
                int columnCount = metaData.getColumnCount();	// 컬럼 개수 가져오기
                
                // 1. 메타데이터로부터 컬럼 이름 추출
                String[] columnNames = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
					columnNames[i] = metaData.getColumnName(i + 1);
				}
                
                // 2. 테이블 모델에 컬럼 이름 설정
				tableModel.setColumnIdentifiers(columnNames);
				
				// 3. 기존 데이터 삭제
				tableModel.setRowCount(0);
				
				while (rs.next()) {
					Object[] rowData = {
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("dept"),
							rs.getString("code"),
							rs.getInt("grade"),
							rs.getDouble("score"),
							rs.getString("gender")
					};
					tableModel.addRow(rowData);
            }
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "데이터 로딩 중 오류 발생", "에러", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
	}
}
