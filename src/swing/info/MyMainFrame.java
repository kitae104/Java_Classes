package swing.info;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyMainFrame extends JFrame implements ActionListener {	

	private JTextField tfName;
	private JButton btnOk;
	private JButton btnNew;
	private MySubFrame msf;

	public MyMainFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		//setLocation(500, 300); 
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		btnNew = new JButton("새프레임");
		btnNew.addActionListener(this);
		
		JLabel lbl = new JLabel("이름은 : ");
		
		tfName = new JTextField(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		
		add(btnNew);
		add(lbl);
		add(tfName);
		add(btnOk);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new MyMainFrame("내 메인 프레임", 300, 150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnNew) {
			msf = new MySubFrame("내 보조 프레임", 300, 300, this);
		} else if(obj == btnOk) {
			tfName.setText(msf.getTfName().getText());
		}
		
	}

}
