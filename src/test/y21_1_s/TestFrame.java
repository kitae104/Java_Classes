package test.y21_1_s;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame implements ActionListener {	

	private JPanel basePanel;
	private JButton btn1;	
	private JButton btn3;
	private SimpleCalcFrame2 scf;
	private ResultFrame rf;

	public TestFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(450, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBasePanel();		
		
		setVisible(true);
	}
		
	private void setBasePanel() {
		
		basePanel = new JPanel();
		basePanel.setLayout(new GridLayout(2,1, 5, 10));		
		basePanel.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		
		btn1 = new JButton("프레임 열기");
		btn1.addActionListener(this);		
		btn3 = new JButton("종료");
		
		basePanel.add(btn1);		
		basePanel.add(btn3);
		
		add(basePanel);
	}

	public static void main(String[] args) {
		new TestFrame("내 프레임", 150, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn1) {
			scf = new SimpleCalcFrame2("간단한 계산기", 300, 150);
			rf = new ResultFrame("결과", 250, 250); 
			scf.setRf(rf);
		} 
		
	}

}
