package test.y23_1_m.cban;

import test.y21_1_s.ResultFrame;
import test.y21_1_s.SimpleButtonCalcFrame;
import test.y21_1_s.SimpleCalcFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame implements ActionListener {

	private JPanel basePanel;
	private JButton btn1;
	private JButton btn3;
	private SimpleCalcFrame2 scf;
	private ResultFrame rf;

	public StartFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(450, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBasePanel();

		setVisible(true);
	}

	private void setBasePanel() {

		basePanel = new JPanel();
		basePanel.setLayout(new GridLayout(2, 1, 10, 10));
		basePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		btn1 = new JButton("프레임 열기");
		btn1.addActionListener(this);
		btn3 = new JButton("종료");

		basePanel.add(btn1);
		basePanel.add(btn3);

		add(basePanel);
	}

	public static void main(String[] args) {
		new StartFrame("내 프레임", 150, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn1) {
			new FirstFrame("간단한 계산기", 300, 200);
		}

	}

}
