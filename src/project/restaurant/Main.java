package project.restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {

	private JFrame frmKitaesRestaurant;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmKitaesRestaurant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKitaesRestaurant = new JFrame();
		frmKitaesRestaurant.getContentPane().setBackground(new Color(240, 240, 240));
		frmKitaesRestaurant.setTitle("FOOD & FLUID");
		frmKitaesRestaurant.setBounds(100, 100, 1118, 707);
		frmKitaesRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKitaesRestaurant.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(12, 21, 152, 632);
		panel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 5, true));
		frmKitaesRestaurant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel.setBounds(26, 30, 100, 87);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_1.setBounds(26, 127, 100, 87);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_2.setBounds(26, 224, 100, 87);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("F");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_3.setBounds(26, 334, 100, 87);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("&");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_4.setBounds(26, 431, 100, 87);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("F");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_5.setBounds(26, 528, 100, 87);
		panel.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBounds(176, 21, 288, 308);
		panel_2.setBorder(new javax.swing.border.LineBorder(new Color(128, 0, 0), 5, true));
		frmKitaesRestaurant.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("HOT DOG");
		lblNewLabel_6.setForeground(new Color(128, 0, 0));
		lblNewLabel_6.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6.setBounds(23, 25, 161, 38);
		panel_2.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(180, 25, 85, 38);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("STEAK");
		lblNewLabel_6_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_1.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_1.setBounds(23, 73, 161, 38);
		panel_2.add(lblNewLabel_6_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 73, 85, 38);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("HAMBURGER");
		lblNewLabel_6_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_2.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_2.setBounds(23, 121, 161, 38);
		panel_2.add(lblNewLabel_6_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 121, 85, 38);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("PIZZA");
		lblNewLabel_6_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_3.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_3.setBounds(23, 169, 161, 38);
		panel_2.add(lblNewLabel_6_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 169, 85, 38);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("FOOD");
		lblNewLabel_6_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_6_3_1.setBounds(92, 243, 161, 38);
		panel_2.add(lblNewLabel_6_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(940, 21, 152, 632);
		panel_1.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 5, true));
		frmKitaesRestaurant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblS = new JLabel("S");
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		lblS.setForeground(Color.WHITE);
		lblS.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblS.setBounds(25, 2, 100, 87);
		panel_1.add(lblS);
		
		JLabel lblNewLabel_1_1 = new JLabel("E");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_1_1.setBounds(25, 91, 100, 87);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("R");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_2_1.setBounds(25, 180, 100, 87);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("V");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_3_1.setBounds(25, 269, 100, 87);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("I");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_4_1.setBounds(25, 358, 100, 87);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("C");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_5_1.setBounds(25, 447, 100, 87);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("E");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("D2Coding", Font.BOLD, 60));
		lblNewLabel_5_1_1.setBounds(25, 536, 100, 87);
		panel_1.add(lblNewLabel_5_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(240, 240, 240));
		panel_2_1.setBounds(176, 339, 288, 314);
		panel_2_1.setBorder(new javax.swing.border.LineBorder(new Color(128, 0, 0), 5, true));
		frmKitaesRestaurant.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_6_4 = new JLabel("MOJITO");
		lblNewLabel_6_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_4.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_4.setBounds(22, 32, 161, 38);
		panel_2_1.add(lblNewLabel_6_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(179, 32, 85, 38);
		panel_2_1.add(textField_4);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("MILKSHAKE");
		lblNewLabel_6_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_1_1.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_1_1.setBounds(22, 80, 161, 38);
		panel_2_1.add(lblNewLabel_6_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(179, 80, 85, 38);
		panel_2_1.add(textField_5);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("CAPPUCCINO");
		lblNewLabel_6_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_2_1.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_2_1.setBounds(22, 128, 161, 38);
		panel_2_1.add(lblNewLabel_6_2_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(179, 128, 85, 38);
		panel_2_1.add(textField_6);
		
		JLabel lblNewLabel_6_3_2 = new JLabel("ICE TEA");
		lblNewLabel_6_3_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_3_2.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_3_2.setBounds(22, 176, 161, 38);
		panel_2_1.add(lblNewLabel_6_3_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(179, 176, 85, 38);
		panel_2_1.add(textField_7);
		
		JLabel lblNewLabel_6_3_1_1 = new JLabel("FLUID");
		lblNewLabel_6_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_6_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_6_3_1_1.setBounds(91, 250, 161, 38);
		panel_2_1.add(lblNewLabel_6_3_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(255, 255, 255));
		panel_2_2.setBounds(784, 21, 144, 632);
		panel_2_2.setBorder(new javax.swing.border.LineBorder(new Color(128, 0, 0), 5, true));
		frmKitaesRestaurant.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JButton btnNewButton = new JButton("SUM");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnNewButton.setBounds(12, 80, 120, 57);
		panel_2_2.add(btnNewButton);
		
		JButton btnBill = new JButton("BILL");
		btnBill.setBackground(new Color(240, 240, 240));
		btnBill.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnBill.setBounds(12, 217, 120, 57);
		panel_2_2.add(btnBill);
		
		JButton btnNewBill = new JButton("NEW");
		btnNewBill.setBackground(new Color(240, 240, 240));
		btnNewBill.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnNewBill.setBounds(12, 354, 120, 57);
		panel_2_2.add(btnNewBill);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setBackground(new Color(240, 240, 240));
		btnClose.setFont(new Font("D2Coding", Font.BOLD, 25));
		btnClose.setBounds(12, 491, 120, 57);
		panel_2_2.add(btnClose);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(new Color(240, 240, 240));
		panel_2_3.setBounds(476, 21, 296, 172);
		panel_2_3.setBorder(new javax.swing.border.LineBorder(new Color(128, 0, 0), 5, true));
		frmKitaesRestaurant.getContentPane().add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JLabel lblNewLabel_6_2_2 = new JLabel("FOOD'S PRICE");
		lblNewLabel_6_2_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_2_2.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_2_2.setBounds(14, 21, 171, 38);
		panel_2_3.add(lblNewLabel_6_2_2);
		
		JLabel lblNewLabel_6_3_3 = new JLabel("FLUID'S PRICE");
		lblNewLabel_6_3_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_6_3_3.setFont(new Font("D2Coding", Font.BOLD, 25));
		lblNewLabel_6_3_3.setBounds(14, 69, 171, 38);
		panel_2_3.add(lblNewLabel_6_3_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(197, 21, 85, 38);
		panel_2_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(197, 69, 85, 38);
		panel_2_3.add(textField_9);
		
		JLabel lblNewLabel_6_3_1_2 = new JLabel("SUM");
		lblNewLabel_6_3_1_2.setForeground(Color.BLACK);
		lblNewLabel_6_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_6_3_1_2.setBounds(14, 116, 161, 38);
		panel_2_3.add(lblNewLabel_6_3_1_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(197, 117, 85, 38);
		panel_2_3.add(textField_10);
		
		JPanel panel_2_3_1 = new JPanel();
		panel_2_3_1.setBackground(new Color(240, 240, 240));
		panel_2_3_1.setBorder(new javax.swing.border.LineBorder(new Color(128, 0, 0), 5, true));
		panel_2_3_1.setBounds(476, 203, 296, 450);
		frmKitaesRestaurant.getContentPane().add(panel_2_3_1);
		panel_2_3_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 10, 272, 430);
		panel_2_3_1.add(textArea);
	}
}
