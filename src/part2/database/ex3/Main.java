package part2.database.ex3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		DB.init(); // DB 연결 초기화
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("데이터 입력");
		btnNewButton.addActionListener((e) -> {
				UserInfo userInfo = new UserInfo();
				userInfo.getFrame().setVisible(true);				
			}
		);
		btnNewButton.setBounds(36, 34, 253, 120);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("데이터 확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserShow userShow = new UserShow();
				userShow.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(36, 180, 253, 120);
		contentPane.add(btnNewButton_1);
	}
}
