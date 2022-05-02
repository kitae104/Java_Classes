package test.y22_1_m;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleButtonCalcFrame extends JFrame implements ActionListener {	

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
	private JButton btn6;
	private JButton btnResult;
	
	public SimpleButtonCalcFrame(String title, int width, int height, Test_B_Frame mf) {
		this.mf = mf;
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
		
		JLabel lbl = new JLabel("202145000 / A반 / 홍길동");		
		
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
		btnPanel.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		
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
		
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		
		btnResult = new JButton("전송");
		btnResult.addActionListener(this);
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		btnPanel.add(btnBack);
		btnPanel.add(btn4);
		btnPanel.add(btn5);
		btnPanel.add(btn6);
		btnPanel.add(btnResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn1 || obj == btn2 || obj == btn3 || obj == btn4 || obj == btn5 || obj == btn6 ) {
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
		}		
	}

}
