package project.simple_chat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DesignChat {

	private JFrame frmMychat;
	private JTextField tfChat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignChat window = new DesignChat();
					window.frmMychat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesignChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMychat = new JFrame();
		frmMychat.setTitle("MyChat");
		frmMychat.setBounds(100, 100, 392, 505);
		frmMychat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMychat.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 378, 53);
		panel.setBackground(new Color(255, 255, 0));
		frmMychat.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("사용자1");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblName.setBounds(58, 10, 136, 33);
		panel.add(lblName);
		
		JButton btnExit = new JButton("나가기");
		btnExit.setBounds(254, 10, 91, 33);
		panel.add(btnExit);
		
		JLabel lblName_1 = new JLabel("(사용중)");
		lblName_1.setForeground(new Color(255, 0, 0));
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setFont(new Font("D2Coding", Font.BOLD, 10));
		lblName_1.setBounds(176, 10, 70, 18);
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
		btnSend.setBounds(275, 10, 91, 33);
		panel_1.add(btnSend);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setBackground(new Color(192, 192, 192));
		lowerPanel.setBounds(10, 63, 356, 342);
		frmMychat.getContentPane().add(lowerPanel);
		lowerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel messagePanel = new JPanel();
		messagePanel.setBackground(new Color(128, 255, 128));
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		lowerPanel.add(new JScrollPane(messagePanel), BorderLayout.PAGE_START);		
	
	}
}
