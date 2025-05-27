package part2.chat.ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ServerChat {

	private JFrame frame;
	private JTextField tfInput;
	private JTextArea taChat;
	private BufferedReader in;
	private BufferedWriter out;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerChat window = new ServerChat();
					window.frame.setVisible(true);
					
					// 백그라운드 스레드에서 실행하기
					new Thread(() -> window.runServer()).start();
					
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
	public ServerChat() {		
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
		
		JLabel lblNewLabel = new JLabel("Chat Server");
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
				typeMsg();
			}

			
		});
		panel_1.add(tfInput);
		tfInput.setColumns(25);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeMsg();			
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
	
	private void typeMsg() {		
		
		try {
			String output = tfInput.getText();
			out.write(output + "\n");
			out.flush();
			
			taChat.append("[서버] : " + output + "\n");
			tfInput.setText("");
			tfInput.requestFocus();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runServer() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		
		try {
			serverSocket = new ServerSocket(9999);
			taChat.append("서버가 시작되었습니다.\n");
			
			socket = serverSocket.accept();
			taChat.append("클라이언트가 접속하였습니다.\n");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String inMsg = null;
			
			while(true) {
				inMsg = in.readLine();
				taChat.append("[클라이언트] : " + inMsg + "\n");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}