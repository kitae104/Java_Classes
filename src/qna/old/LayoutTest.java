package qna.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTest extends JFrame {

	public LayoutTest(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		JPanel panelBase = new JPanel();
		panelBase.setLayout(new GridLayout(1, 2, 10, 10));
		panelBase.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.YELLOW);	
		
		JLabel lbl1 = new JLabel("Type ID");		
		panelLeft.add(lbl1);

		JTextField tf1 = new JTextField(10);
		panelLeft.add(tf1);

		JLabel lbl2 = new JLabel("Type Password");
		panelLeft.add(lbl2);

		JTextField tf2 = new JTextField(10);
		panelLeft.add(tf2);
				
		panelBase.add(panelLeft);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.GREEN);		
		
		JLabel lbl3 = new JLabel("Please Check!!");
		panelRight.add(lbl3);

		JCheckBox chkBox1 = new JCheckBox("C# JCheckBox");
		panelRight.add(chkBox1);

		JCheckBox chkBox2 = new JCheckBox("C++ JCheckBox");
		panelRight.add(chkBox2);
		
		panelBase.add(panelRight);
		
		add(panelBase);
		
		JPanel panelButtom = new JPanel();
		panelButtom.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 10 , 10));
		//panelButtom.setBackground(Color.GRAY);
		
		JButton btn = new JButton("OK");
		panelButtom.add(btn);
		
		add(panelButtom, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LayoutTest("레이아웃 과제", 350, 250);
	}

}
