package test.y23_1_m.cban;

import test.y21_1_s.ResultFrame;
import test.y21_1_s.SimpleButtonCalcFrame;
import test.y21_1_s.SimpleCalcFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondtFrame extends JFrame implements ActionListener {

	private JPanel basePanel;



	public SecondtFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(900, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBasePanel();

		setVisible(true);
	}

	private void setBasePanel() {

		basePanel = new JPanel();
		basePanel.setLayout(new GridLayout(1,1));
		basePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JList<String> list = new JList<String>(new String[] {"23", "33"});
		JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		basePanel.add(scrollPane);
		add(basePanel);
	}

	public static void main(String[] args) {
		new SecondtFrame("내 프레임", 100, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

	}

}
