package test.y21_1_s;

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

public class SimpleCalcFrame extends JFrame implements ActionListener {	

	private JPanel upPanel;
	private JPanel cenPanel;
	private JPanel calcPanel;
	private JPanel downPanel;
	
	private JButton btnSend;
	private JButton btn2;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tfResult;
	private JComboBox<String> cb;
	private JButton btnResult;
	private MainFrame mf;
	
	public SimpleCalcFrame(String title, int width, int height, MainFrame mf) {
		this.mf = mf;
		setTitle(title);
		setSize(width, height);
		setLocation(600, 200); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpPanel();
		setCenPanel();
		setDownPanel();
		
		setVisible(true);
	}
		
	private void setUpPanel() {
		upPanel = new JPanel();		
		upPanel.setBackground(Color.YELLOW);
		
		JLabel lbl = new JLabel("학년 / 반 / 이름");		
		
		upPanel.add(lbl);
		
		add(upPanel, BorderLayout.NORTH);
	}

	private void setCenPanel() {
		cenPanel = new JPanel();	
		cenPanel.setLayout(new GridLayout(1, 5, 5, 0));
		cenPanel.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));

		//cenPanel.setBackground(Color.GREEN);
		
		Vector<String> op = new Vector<>();
		op.add("+");
		op.add("-");
		op.add("*");
		op.add("/");
		
		
		tf1 = new JTextField(5);
		tf1.setHorizontalAlignment(JTextField.CENTER);
		cb = new JComboBox<>(op);
		tf2 = new JTextField(5);
		tf2.setHorizontalAlignment(JTextField.CENTER);
		
		btnResult = new JButton(" = ");
		btnResult.addActionListener(this);
		
		tfResult = new JTextField(5);
		tfResult.setHorizontalAlignment(JTextField.CENTER);
		

		
		cenPanel.add(tf1);
		cenPanel.add(cb);		
		cenPanel.add(tf2);
		cenPanel.add(btnResult);		
		cenPanel.add(tfResult);
		
		add(cenPanel, BorderLayout.CENTER);
		
	}

	private void setDownPanel() {
		downPanel = new JPanel();
		//downPanel.setBackground(Color.PINK);
		
		btnSend = new JButton("결과 보내기");
		btnSend.addActionListener(this);
		
		btn2 = new JButton("닫기");
		
		downPanel.add(btnSend);
		downPanel.add(btn2);
		
		add(downPanel, BorderLayout.SOUTH);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnResult) {
			int val1 = Integer.parseInt(tf1.getText());
			int val2 = Integer.parseInt(tf2.getText());
			int result = 0;
			String op = (String) cb.getSelectedItem();
			switch(op) {
			case "+":
				result = val1 + val2;
				break;
			case "-":
				result = val1 - val2;
				break;
			case "*":
				result = val1 * val2;
				break;
			case "/":
				result = val1 / val2;
				break;
			}
			
			tfResult.setText(result+"");
		} else if(obj == btnSend) {
			mf.getTa().append("계산 결과 : " + tf1.getText() + cb.getSelectedItem() 
			                                 + tf2.getText() + " = " + tfResult.getText() + "\n");
		}
		
	}

}
