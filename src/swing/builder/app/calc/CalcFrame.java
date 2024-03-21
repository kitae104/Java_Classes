package swing.builder.app.calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalcFrame extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNum;
	
	
	double number1 = 0;
	double number2 = 0; 
	String op = null;
	

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
					CalcFrame frame = new CalcFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalcFrame()
	{
		setTitle("계산기 ver 0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kitae's CALCULATOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 350, 541, 56);
		contentPane.add(lblNewLabel);
		
		tfNum = new JTextField();
		tfNum.setHorizontalAlignment(SwingConstants.RIGHT);
		tfNum.setFont(new Font("D2Coding", Font.PLAIN, 18));
		tfNum.setBounds(15, 10, 532, 56);
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.GRAY);
		btnAdd.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number1 = Double.parseDouble(tfNum.getText());
				tfNum.setText("");
				op = "+";
			}
		});
		btnAdd.setBounds(465, 76, 82, 132);
		contentPane.add(btnAdd);
		
		JButton btnAns = new JButton("=");
		btnAns.setBackground(Color.YELLOW);
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number2 = Double.parseDouble(tfNum.getText());
				double result = 0;
				
				if(op.equals("+")) {
					result = number1 + number2;
				} else if(op.equals("-")) {
					result = number1 - number2;
				} else if(op.equals("*")) {
					result = number1 * number2;
				} else if(op.equals("/")) {
					result = number1 / number2;
				} else {
					JOptionPane.showMessageDialog(null, "잘못된 연산입니다.");
				}
				
				tfNum.setText(result + "");
				op = null; 
			}
		});
		btnAns.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnAns.setBounds(465, 218, 82, 132);
		contentPane.add(btnAns);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(Color.WHITE);
		btn9.setBackground(Color.BLACK);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "9");
			}
		});
		btn9.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn9.setBounds(375, 76, 75, 61);
		contentPane.add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.WHITE);
		btn6.setBackground(Color.BLACK);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "6");
			}
		});
		btn6.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn6.setBounds(375, 147, 75, 61);
		contentPane.add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.WHITE);
		btn3.setBackground(Color.BLACK);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "3");
			}
		});
		btn3.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn3.setBounds(375, 218, 75, 61);
		contentPane.add(btn3);
		
		JButton btnDot = new JButton(".");
		btnDot.setBackground(Color.ORANGE);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + ".");
			}
		});
		btnDot.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnDot.setBounds(378, 289, 75, 61);
		contentPane.add(btnDot);
		
		JButton btn8 = new JButton("8");
		btn8.setForeground(Color.WHITE);
		btn8.setBackground(Color.BLACK);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "8");
			}
		});
		btn8.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn8.setBounds(285, 76, 75, 61);
		contentPane.add(btn8);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.WHITE);
		btn5.setBackground(Color.BLACK);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "5");
			}
		});
		btn5.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn5.setBounds(285, 147, 75, 61);
		contentPane.add(btn5);
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(Color.BLACK);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "2");
			}
		});
		btn2.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn2.setBounds(285, 218, 75, 61);
		contentPane.add(btn2);
		
		JButton btnSub = new JButton("-");
		btnSub.setForeground(Color.WHITE);
		btnSub.setBackground(Color.GRAY);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number1 = Double.parseDouble(tfNum.getText());
				tfNum.setText("");
				op = "-";
			}
		});
		btnSub.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnSub.setBounds(105, 76, 75, 80);
		contentPane.add(btnSub);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setForeground(Color.WHITE);
		btnDiv.setBackground(Color.GRAY);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number1 = Double.parseDouble(tfNum.getText());
				tfNum.setText("");
				op = "/";
			}
		});
		btnDiv.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnDiv.setBounds(105, 266, 75, 84);
		contentPane.add(btnDiv);
		
		JButton btnMul = new JButton("*");
		btnMul.setForeground(Color.WHITE);
		btnMul.setBackground(Color.GRAY);
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number1 = Double.parseDouble(tfNum.getText());
				tfNum.setText("");
				op = "*";
			}
		});
		btnMul.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnMul.setBounds(105, 166, 75, 84);
		contentPane.add(btnMul);
		
		JButton btnDel = new JButton("DEL");
		btnDel.setForeground(Color.WHITE);
		btnDel.setBackground(Color.DARK_GRAY);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText("");
			}
		});
		btnDel.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnDel.setBounds(15, 76, 75, 132);
		contentPane.add(btnDel);
		
		JButton btn0 = new JButton("0");
		btn0.setForeground(Color.WHITE);
		btn0.setBackground(Color.BLACK);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "0");
			}
		});
		btn0.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn0.setBounds(192, 289, 172, 61);
		contentPane.add(btn0);
		
		JButton btnClear = new JButton("C");
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(Color.DARK_GRAY);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tfNum.getText();
				tfNum.setText(str.substring(0, str.length() -1));
			}
		});
		btnClear.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btnClear.setBounds(15, 218, 75, 132);
		contentPane.add(btnClear);
		
		JButton btn7 = new JButton("7");
		btn7.setForeground(Color.WHITE);
		btn7.setBackground(Color.BLACK);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "7");
			}
		});
		btn7.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn7.setBounds(195, 76, 75, 61);
		contentPane.add(btn7);
		
		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(Color.BLACK);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "4");
			}
		});
		btn4.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn4.setBounds(195, 147, 75, 61);
		contentPane.add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(Color.BLACK);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText(tfNum.getText() + "1");
			}
		});
		btn1.setFont(new Font("D2Coding", Font.PLAIN, 16));
		btn1.setBounds(195, 218, 75, 61);
		contentPane.add(btn1);
	}
}
