package part2.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatForm {

	private JFrame frame;
	private JTextField tfInput;
	private JTextArea taChat;
	private BufferedWriter out;	
	
	
	public JFrame getFrame() {
		return frame;
	}

	
	
	public JTextField getTfInput() {
		return tfInput;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatForm window = new ChatForm();
					window.frame.setVisible(true);
					window.serverRun(); // 서버 설정 메소드 호출	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param title 
	 * @param myEditor 
	 */
	public ChatForm() {		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Chat Server");
		frame.setBounds(100, 100, 450, 507);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("My Chat");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfInput = new JTextField();
		tfInput.setFont(new Font("굴림", Font.PLAIN, 14));
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					typeMsg();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		panel_1.add(tfInput);
		tfInput.setColumns(25);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					typeMsg();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		
		panel_1.add(btnSend);
		
		taChat = new JTextArea();
		taChat.setFont(new Font("Monospaced", Font.PLAIN, 16));
		taChat.setEditable(false);
		taChat.setLineWrap(true);
		
		JScrollPane sp = new JScrollPane(taChat);
		
		frame.getContentPane().add(sp, BorderLayout.CENTER);		
	}
	
	public void serverRun() throws IOException {
		System.out.println("서버 실행중...");
		ServerSocket serverSocket = new ServerSocket(9999);
		taChat.append("Server가 port 9999에서 실행중 입니다.\n");
		
//		Socket socket = serverSocket.accept();
//		taChat.append("클라이언트가 접속했습니다.\n");
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//		
//		String inMsg = null;
//		while(true) {
//			inMsg = in.readLine();
//			taChat.append("[client] : " + inMsg + "\n");
//		}	
		
	}



	private void typeMsg() throws IOException {		
		
		String outMsg = tfInput.getText();
		out.write(outMsg + "\n");	
		out.flush();		
		
		taChat.append("[server] : " + outMsg + "\n");
		tfInput.setText("");
		tfInput.requestFocus();		
		
	}

}