package test.y23_1_m.cban;

import test.y22_1_m.Test_B_Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame implements ActionListener {

	private JPanel upPanel;
	private JPanel cenPanel;
	private JPanel btnPanel;


	private JButton btnSend;
	private JButton btn2;
	private Test_B_Frame mf;
	private JTextField tf;
	private JButton btn1;
	private JButton btn3;
	private JButton btnBack;
	private JButton btn4;
	private JButton btn5;
	private JButton btnOpen;
	private JButton btnResult;

	public FirstFrame(String title, int width, int height) {

		setTitle(title);
		setSize(width, height);
		setLocation(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setUpPanel();
		setCenPanel();

		setVisible(true);
	}

	private void setUpPanel() {
		upPanel = new JPanel();
		upPanel.setBackground(Color.YELLOW);

		JLabel lbl = new JLabel("202145000 / O반 / 홍길동");

		upPanel.add(lbl);

		add(upPanel, BorderLayout.NORTH);
	}

	private void setCenPanel() {
		cenPanel = new JPanel();
		cenPanel.setLayout(new BorderLayout());
		cenPanel.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		//cenPanel.setBackground(Color.GREEN);

		tf = new JTextField("0");
		tf.setHorizontalAlignment(JTextField.RIGHT);
		cenPanel.add(tf, BorderLayout.NORTH);

		setBtnPanel();
		cenPanel.add(btnPanel);

		add(cenPanel, BorderLayout.CENTER);

	}

	private void setBtnPanel() {
		btnPanel = new JPanel();
		//btnPanel.setBackground(Color.RED);
		btnPanel.setLayout(new GridLayout(2, 4, 5, 5));
		btnPanel.setBorder(BorderFactory.createEmptyBorder(10 , 5 , 10 , 5));

		btn1 = new JButton("1");
		btn1.addActionListener(this);

		btn2 = new JButton("2");
		btn2.addActionListener(this);

		btn3 = new JButton("3");
		btn3.addActionListener(this);

		btnBack = new JButton("C");
		btnBack.addActionListener(this);

		btn4 = new JButton("4");
		btn4.addActionListener(this);

		btn5 = new JButton("5");
		btn5.addActionListener(this);

		btnOpen = new JButton("열기");
		btnOpen.addActionListener(this);

		btnResult = new JButton("전송");
		btnResult.addActionListener(this);

		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		btnPanel.add(btnBack);
		btnPanel.add(btn4);
		btnPanel.add(btn5);
		btnPanel.add(btnOpen);
		btnPanel.add(btnResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj == btn1 || obj == btn2 || obj == btn3 || obj == btn4 || obj == btn5) {
			String str = tf.getText();
			if(str.equals("0")) {
				str = "";
			}
			str = str + ((JButton)obj).getText();
			tf.setText(str);
		} else if (obj == btnBack) {
			String str = tf.getText();
			str = str.substring(0, str.length()-1);
			if(str.isEmpty()) {
				str = "0";
			}
			tf.setText(str);
		} else if(obj == btnResult) {
			mf.getListModel().addElement(tf.getText());
			tf.setText("0");
		} else if (obj == btnOpen) {
			new SecondtFrame("두번째 프레임", 100, 200);
		}
	}

	public static void main(String[] args) {
		new FirstFrame("간단한 계산기", 300, 200);
	}

}
