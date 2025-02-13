package app.db;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login
{

	private JFrame frmLogin;

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
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login()
	{
		initialize();
		connection = DbConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 473, 253);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(139, 57, 74, 15);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(139, 102, 74, 15);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(248, 48, 179, 33);
		frmLogin.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("images\\run.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String sql = "SELECT * FROM studentinfo WHERE username=? and password=? ";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, textFieldUserName.getText());
					pstmt.setString(2, passwordField.getText()); 
					
					ResultSet rs = pstmt.executeQuery();
					int count = 0;
					
					while(rs.next()) {
						String userName = rs.getString(1);
						String password = rs.getString(2);
						System.out.println(userName + ", " + password);
						
						count += 1;
					}
					
					if(count == 1) {
						
						JOptionPane.showMessageDialog(null, "사용자 이름과 패스워드가 일치합니다.");
						frmLogin.dispose();
						StudentInfo studentInfo = new StudentInfo();
						studentInfo.setLocationRelativeTo(null);
						studentInfo.setVisible(true);
						
					} else if(count > 1) {
						JOptionPane.showMessageDialog(null, "사용자 이름과 패스워드가 중복된 사용자가 존재합니다.");						
					} else {
						JOptionPane.showMessageDialog(null, "사용자 이름 또는 패스워드가 틀립니다. 다시 시도하세요... ");			
					}
					
					rs.close();
					pstmt.close();
					
				} 
				catch (Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnLogin.setBounds(232, 143, 158, 44);
		frmLogin.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 94, 179, 31);
		frmLogin.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("images\\logo.png"));
		
		// image 폴더를 소스 폴더로 만든 경우라면 아래처럼 처리 할 수 있음 
		//Image image = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		//label.setIcon(new ImageIcon(img));
		
		lblNewLabel_2.setBounds(30, 48, 97, 118);
		frmLogin.getContentPane().add(lblNewLabel_2);
	}
}
