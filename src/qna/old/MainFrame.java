package qna.old;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {
	
	private JPanel cenPanel;
	private JTextField tfID;
	private JButton btnOK;
	private JButton btnSet;
	private SubFrame sf;
	 
	public JTextField getTfID() {
		return tfID;
	}
	
	
	public void setTfID(JTextField tfID) {
		this.tfID = tfID;
	}


	public MainFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setCenterPanel();
		
		
		setVisible(true);
	}

	
	
	
	private void setCenterPanel() {
		cenPanel = new JPanel();
		cenPanel.setBackground(Color.YELLOW);
		
		JLabel lbl = new JLabel("���̵� : ");
		tfID = new JTextField(10);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		
		btnSet = new JButton("�����ϱ�");
		btnSet.addActionListener(this);
		
		cenPanel.add(lbl);
		cenPanel.add(tfID);
		cenPanel.add(btnOK);
		cenPanel.add(btnSet);
		
		add(cenPanel);
	}

	public static void main(String[] args) {
		new MainFrame("���� ������", 300, 150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnOK) {
		 sf = new SubFrame("테스트", 300, 300, this);
			//sf.setTitle("�����ִ� �����̳�~~");
		}
		
		else if(obj == btnSet) {
			sf.setTitle("타이틀 보기");
			sf.getTfID().setText("�����ִ� �����̳�~ ��¼��!!!");
		}
	}
}




	
