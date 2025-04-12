package project.simple_chat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServerMain {

	private JFrame frmMychat;
	private JTextField tfChat;
	private JPanel messagePanel;
	private JPanel lowerPanel;
	private DataOutputStream out;
	private JLabel lblOut;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerMain window = new ServerMain();
					window.frmMychat.setVisible(true);
					
					// 별도의 스레드에서 수행 
					new Thread(() -> window.runChat()).start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void runChat() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(6001);
			
			while(true) {
				Socket socket = server.accept();
				DataInputStream in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                
                while(true) {
                	String chat = in.readUTF();
                	JPanel panel = formatLabel(chat);
                	lblOut.setBackground(Color.YELLOW);
                	JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    messagePanel.add(left);
                    
                    SwingUtilities.invokeLater(() -> {
    				    JScrollBar vertical = ((JScrollPane) lowerPanel.getComponent(0)).getVerticalScrollBar();
    				    vertical.setValue(vertical.getMaximum());
    				});
                    
                    frmMychat.revalidate();
                    frmMychat.repaint();
                    frmMychat.validate();
                }
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(server != null) {
					server.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Create the application.
	 */
	public ServerMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMychat = new JFrame();
		frmMychat.setTitle("MyChat_Server");
		frmMychat.setBounds(100, 100, 392, 505);
		frmMychat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMychat.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 378, 53);
		panel.setBackground(new Color(255, 255, 0));
		frmMychat.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("서버 사용자");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblName.setBounds(50, 7, 152, 36);
		panel.add(lblName);
		
		JButton btnExit = new JButton("나가기");
		btnExit.setBounds(254, 10, 91, 33);
		panel.add(btnExit);
		
		JLabel lblName_1 = new JLabel("(사용중)");
		lblName_1.setForeground(new Color(255, 0, 0));
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setFont(new Font("D2Coding", Font.BOLD, 10));
		lblName_1.setBounds(195, 7, 53, 18);
		panel.add(lblName_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 415, 378, 53);
		panel_1.setBackground(new Color(128, 255, 255));
		frmMychat.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tfChat = new JTextField();
		tfChat.setBounds(12, 10, 251, 33);
		panel_1.add(tfChat);
		tfChat.setColumns(10);
		
		JButton btnSend = new JButton("보내기");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msg = tfChat.getText();
					JPanel panelText = formatLabel(msg);	// 메시지 패널
					
					JPanel rightPanel = new JPanel(new BorderLayout());	// 오른쪽 정렬 패널
					//rightPanel.setBackground(new Color(128, 255, 128));
					rightPanel.add(panelText, BorderLayout.LINE_END);	// 오른쪽 정렬 패널에 메시지 패널 추가
					
					messagePanel.add(rightPanel);	// 메시지 패널을 스크롤 패널에 추가
					
					SwingUtilities.invokeLater(() -> {
					    JScrollBar vertical = ((JScrollPane) lowerPanel.getComponent(0)).getVerticalScrollBar();
					    vertical.setValue(vertical.getMaximum());
					});
					
					
					tfChat.setText("");	// 텍스트 필드 초기화
					out.writeUTF(msg);	// 서버에 메시지 전송
					
					frmMychat.revalidate();	// 패널 재배치
					frmMychat.repaint();	// 패널 다시 그리기
					frmMychat.validate();	// 프레임 재배치
					
				} catch (Exception e2) {
					System.out.println("전송 실패(보내기 버튼)");
					e2.printStackTrace();
				}
			}

			
		});
		btnSend.setBounds(275, 10, 91, 33);
		panel_1.add(btnSend);
		
		lowerPanel = new JPanel();
		lowerPanel.setBackground(new Color(192, 192, 192));
		lowerPanel.setBounds(10, 63, 356, 342);
		frmMychat.getContentPane().add(lowerPanel);
		lowerPanel.setLayout(new BorderLayout(0, 0));
		
		messagePanel = new JPanel();
//		messagePanel.setBackground(new Color(128, 255, 128));
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(messagePanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 향상
		
		lowerPanel.add(scrollPane, BorderLayout.CENTER);	
	}
	
	public JPanel formatLabel(String msg) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		lblOut = new JLabel("<html><p style=\"width:150px\">" + msg + "<p></html>");
		lblOut.setFont(new Font("", Font.PLAIN, 15));
		lblOut.setBackground(Color.PINK);
		lblOut.setOpaque(true);
		lblOut.setBorder(new EmptyBorder(15, 15, 15, 50));
     
        panel.add(lblOut);
        
        // 시간 표시
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        JLabel timeLabel = new JLabel(sdf.format(cal.getTime()));
        panel.add(timeLabel);
        
		return panel;
	}
}
