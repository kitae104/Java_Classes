package test.y23_1_m.bban;

import test.y22_1_m.SimpleCalcFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B_MainFrame extends JFrame implements ActionListener {

	private JPanel basePanel;
	private JButton btn1;
	private JButton btn3;
	private SimpleCalcFrame2 scf;
	private B_SecondFrame rf;
	private JComboBox<String> combo;
	private DefaultComboBoxModel<String> model;

	public B_MainFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBasePanel();

		setVisible(true);
	}

	private void setBasePanel() {

		basePanel = new JPanel();
		basePanel.setLayout(new GridLayout(2, 1, 5, 10));
		basePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		btn1 = new JButton("프레임 열기");
		btn1.addActionListener(this);
		
		model = new DefaultComboBoxModel<>();
		model.addElement("30");
		model.addElement("20");
		combo = new JComboBox<>(model);

		basePanel.add(btn1);
		basePanel.add(combo);

		add(basePanel);
	}

	public static void main(String[] args) {
		new B_MainFrame("내 프레임", 150, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn1) {
			new B_FirstFrame("FirstFrame", 350, 170, this);
		}

	}

	public DefaultComboBoxModel<String> getModel() {
		return model;
	}	
}
