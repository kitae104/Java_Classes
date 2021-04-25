package swing.info;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MySubFrame extends JFrame implements ActionListener {	
	
	private MyMainFrame myMainFrame;
	private JTextField tfName;
	private JButton btnOk;
	
	public MySubFrame(String title, int width, int height, MyMainFrame myMainFrame) {
		
		this.myMainFrame = myMainFrame;
		
		setTitle(title);
		setSize(width, height);
		setLocation(500, 300); 
		//setLocationRelativeTo(this);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JLabel lbl = new JLabel("이름은 : ");
		
		tfName = new JTextField(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		
		add(lbl);
		add(tfName);
		add(btnOk);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();

		if(obj == btnOk){
			this.setTitle(myMainFrame.getTitle());
		}
	}
		
	public JTextField getTfName() {
		return this.tfName;
	}
	
}