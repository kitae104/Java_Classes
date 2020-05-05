package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class CheckBoxEx extends JFrame implements ItemListener {

	private JCheckBox chk1, chk2, chk3;
	private JLabel lblSum;
	private int sum = 0;
	
	public CheckBoxEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		JLabel lbl1 = new JLabel("사과 100원, 배 500원, 체리 2000원");
		chk1 = new JCheckBox("사과");
		chk1.addItemListener(this);
		chk1.setBorderPainted(true);
		
		chk2 = new JCheckBox("배");
		chk2.addItemListener(this);
		chk2.setBorderPainted(true);
		
		chk3 = new JCheckBox("체리");
		chk3.addItemListener(this);
		chk3.setBorderPainted(true);
		
		lblSum = new JLabel("현재 0 원 입니다.");
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rbMan = new JRadioButton("남자");
		JRadioButton rbWoman = new JRadioButton("여자",true);
		bg.add(rbMan);
		bg.add(rbWoman);
		
		
		add(lbl1);
		add(chk1);
		add(chk2);
		add(chk3);
		add(lblSum);
		
		add(rbMan);
		add(rbWoman);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxEx("체크박스 연습", 250, 200);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {		
		int i = 1;
		if(e.getStateChange() == ItemEvent.SELECTED) {
			i = 1;
		} else {
			i = -1;
		}
		
		if(e.getItem() == chk1) {
			sum = sum + 100 * i;
		} else if (e.getItem() == chk2) {
			sum = sum + 500 * i;
		} else if (e.getItem() == chk3) {
			sum = sum + 2000 * i;
		} 
		
		lblSum.setText("현재 " + sum + " 원 입니다.");
	}

}
