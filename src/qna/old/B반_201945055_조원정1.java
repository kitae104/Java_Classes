package swing.qna;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class B반_201945055_조원정1 extends JFrame {
	
	public B반_201945055_조원정1(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		
		setLocation(1800, 300);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//레이아웃
		setLayout(null);
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.black);
		p.setBounds(0, 0, 390, 366);
		add(p);
		
		JPanel pa = new JPanel();
		pa.setBackground(Color.yellow);
		pa.setBounds(30, 10, 150, 150);
		
		p.add(pa);
		
		JPanel pb = new JPanel();
		pb.setBackground(Color.green);
		pb.setBounds(180, 10, 150, 150);
		p.add(pb);
		
		JLabel jl1 = new JLabel("Type ID");		
		pa.add(jl1);
		
		JTextField T1 = new JTextField("                             ");
		pa.add(T1);
		
		JLabel jl3 = new JLabel("Type Password");
		pa.add(jl3);
		
		JTextField T2 = new JTextField("                       ");
		pa.add(T2);
		
		
		JLabel jl2 = new JLabel("Please Check!!");
		pb.add(jl2);
		
		JCheckBox box1 = new JCheckBox("C# JCheckBox");
		pb.add(box1);
		
		JCheckBox box2 = new JCheckBox("C++ JCheckBox");
		pb.add(box2);
		
		JButton Button = new JButton("OK");
		p.add(Button);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new B반_201945055_조원정1("B반_201945055_조원정", 400, 400);
	}

}
