package test.y23_1_m.bban;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class B_SecondFrame extends JFrame implements ActionListener {

	private JPanel basePanel;
	private JPanel upPanel;
	private JTextField tf;
	private JButton btn;

	public JPanel getBasePanel() {
		return basePanel;
	}

	public JTextField getTf() {
		return tf;
	}

	public B_SecondFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(900, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setUpPanel();
		setBasePanel();

		setVisible(true);
	}

	private void setUpPanel() {
		upPanel = new JPanel();
		upPanel.setBackground(Color.PINK);

		JLabel lbl = new JLabel("별의 갯수 : ");
		tf = new JTextField("0", 4);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		btn = new JButton("그리기");
		btn.addActionListener(this);
		upPanel.add(lbl);
		upPanel.add(tf);
		upPanel.add(btn);

		add(upPanel, BorderLayout.SOUTH);
	}


	private void setBasePanel() {

		basePanel = new JPanel();
		basePanel.setLayout(null);
		add(basePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj == btn) {

			basePanel.removeAll();
			int cnt = Integer.parseInt(tf.getText());

			Random rand = new Random();
			for (int i = 0; i < cnt; i++) {
				int x = rand.nextInt(250);
				int y = rand.nextInt(250);
				System.out.println(x + ", " + y);
				JLabel lbl = new JLabel(" * ");
				lbl.setSize(15,15);
				lbl.setLocation(x, y);
				basePanel.add(lbl);
				basePanel.repaint();
			}
		}

	}

	public static void main(String[] args) {
		new B_SecondFrame("별찍기", 300, 300);
	}

}
