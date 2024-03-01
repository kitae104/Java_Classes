package swing.builder.app.db;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentInfo extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private final DefaultTableModel tableModel = new DefaultTableModel();

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
					StudentInfo frame = new StudentInfo();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField tfUserName;
	private JTextField tfPassword;
	private JTextField tfAge;
	private JTextField tfDept;
	private JTextField tfGrade;
	private JComboBox cbName;
	private JTextField tfId;

	/**
	 * Create the frame.
	 */
	public StudentInfo()
	{
		setTitle("학생 정보 ");

		connection = DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refreshTable();
			}
			
		});
		btnLoadTable.setBounds(549, 22, 140, 23);
		contentPane.add(btnLoadTable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 64, 434, 392);
		contentPane.add(scrollPane);

		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {			    	
					
					int row = table.getSelectedRow();
					String id = table.getModel().getValueAt(row, 0).toString();
					
					String sql = "SELECT * FROM studentinfo WHERE id = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, id);
										
					ResultSet rs = pstmt.executeQuery();

					while(rs.next())
					{
						tfId.setText(rs.getString("id"));
						tfUserName.setText(rs.getString("username"));
						tfPassword.setText(rs.getString("password"));
						tfAge.setText(rs.getString("age"));
						tfDept.setText(rs.getString("dept"));
						tfGrade.setText(rs.getString("grade"));
					}			
					
					pstmt.close();
					rs.close();	
	
				} 
			    catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(23, 141, 68, 15);
		contentPane.add(lblNewLabel);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(106, 138, 137, 21);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(23, 176, 68, 15);
		contentPane.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(106, 173, 137, 21);
		contentPane.add(tfPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("age");
		lblNewLabel_1_1.setBounds(23, 214, 68, 15);
		contentPane.add(lblNewLabel_1_1);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(106, 211, 137, 21);
		contentPane.add(tfAge);
		
		JLabel lblNewLabel_1_2 = new JLabel("dept");
		lblNewLabel_1_2.setBounds(23, 255, 68, 15);
		contentPane.add(lblNewLabel_1_2);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		tfDept.setBounds(106, 252, 137, 21);
		contentPane.add(tfDept);
		
		JLabel lblNewLabel_1_3 = new JLabel("grade");
		lblNewLabel_1_3.setToolTipText("g");
		lblNewLabel_1_3.setBounds(23, 290, 68, 15);
		contentPane.add(lblNewLabel_1_3);
		
		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		tfGrade.setBounds(106, 287, 137, 21);
		contentPane.add(tfGrade);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String sql = "INSERT INTO studentinfo (username, password, age, dept, grade) VALUES (?,?,?,?,?)";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, tfUserName.getText());
					pstmt.setString(2, tfPassword.getText());
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());
					
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pstmt.close();		

				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
				
				refreshTable();
			}
		});
		btnNewButton.setBounds(65, 367, 91, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String id = JOptionPane.showInputDialog(this, "번호 선택");
					String sql = "UPDATE studentinfo SET username = ?, password = ?, age = ?, dept = ?, grade = ? WHERE id = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, tfUserName.getText());
					pstmt.setString(2, tfPassword.getText());					
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());
					pstmt.setString(6, id);
										
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					pstmt.close();

				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdate.setBounds(65, 400, 91, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			    	String id = JOptionPane.showInputDialog(this, "번호 선택");
					String sql = "DELETE FROM studentinfo WHERE id = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, id);
										
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pstmt.close();
	
				} 
			    catch (Exception e2)
				{
					e2.printStackTrace();
				}
			    
			    refreshTable();
			}
		});
		btnDelete.setBounds(65, 433, 91, 23);
		contentPane.add(btnDelete);
		
		cbName = new JComboBox();
		cbName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {			    	
					String username = (String) cbName.getSelectedItem();
					String sql = "SELECT * FROM studentinfo WHERE username = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, username);
										
					ResultSet rs = pstmt.executeQuery();

					while(rs.next())
					{
						tfId.setText(rs.getString("id"));
						tfUserName.setText(rs.getString("username"));
						tfPassword.setText(rs.getString("password"));
						tfAge.setText(rs.getString("age"));
						tfDept.setText(rs.getString("dept"));
						tfGrade.setText(rs.getString("grade"));
					}			
					
					pstmt.close();
					rs.close();	
	
				} 
			    catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		cbName.setFont(new Font("굴림", Font.BOLD, 16));
		cbName.setBounds(23, 60, 220, 23);
		contentPane.add(cbName);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(23, 106, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(106, 103, 137, 21);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		refreshTable();				// 테이블 정보 갱신
		fillComboBox();				// 콤보박스 정보 갱신
	}

	//====================================================
	// DB의 resultset을 이용하여 테이블 설정하기
	//====================================================
	private void setTablefromDB(ResultSet rs) throws SQLException
	{
		ResultSetMetaData metaData = rs.getMetaData();

		// Names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++)
		{
			columnNames.add(metaData.getColumnName(i));
		}

		// Data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next())
		{
			Vector<Object> vector = new Vector<Object>();
			for (int i = 1; i <= columnCount; i++)
			{
				vector.add(rs.getObject(i));
			}
			data.add(vector);
		}

		tableModel.setDataVector(data, columnNames);
	}
	
	//====================================================
	// 테이블 갱신하기
	//====================================================
	private void refreshTable()
	{
		try
		{
			String sql = "SELECT * From studentinfo";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// 데이터를 이용하여 테이블 설정하기
			setTablefromDB(rs);
			pstmt.close();
			rs.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//====================================================
	// 콤보 박스 채우기 
	//====================================================
	public void fillComboBox() 
	{
		try
		{
			String sql = "SELECT * FROM studentinfo";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next())
			{
				cbName.addItem(rs.getString("username"));
			}			
			
			pstmt.close();
			rs.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
