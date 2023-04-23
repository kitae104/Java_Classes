package test.y23_1_m.aban;

import test.y22_1_m.SimpleCalcFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test_C_Frame extends JFrame implements ActionListener {

	private JPanel basePanel;
	private JButton btn1;
	private JButton btn3;
	private SimpleCalcFrame2 scf;
	private ResultFrame rf;
	private JList<String> list;
	private DefaultListModel<String> model;

	public Test_C_Frame(String title, int width, int height) {
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
		
		model = new DefaultListModel<>();
		list = new JList<>(model);
		JScrollPane sp = new JScrollPane(list, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		basePanel.add(btn1);
		basePanel.add(sp);

		add(basePanel);
	}

	public static void main(String[] args) {
		new Test_C_Frame("내 프레임", 150, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn1) {
			new LayoutTest("간단한 계산기", 350, 250, this);
		}

	}

	public DefaultListModel<String> getModel() {
		return model;
	}	
}
