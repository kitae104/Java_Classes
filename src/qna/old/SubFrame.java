package qna.old;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubFrame extends JFrame implements ActionListener {
	
	private JPanel cenPanel;
	private JTextField tfID;
	private JButton btnOK;
	private MainFrame mainFrame;
	
	public JTextField getTfID() {
		return tfID;
	}


	public void setTfID(JTextField tfID) {
		this.tfID = tfID;
	}


	public SubFrame(String title, int width, int height, MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		mainFrame.setTitle("������ �����Ͽ� ����");
		setSize(width, height);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(700, 200);
		
		setCenterPanel();
		
		setVisible(true);
	}

	public SubFrame(String string, int i, int j) {
	}

	private void setCenterPanel() {
		cenPanel = new JPanel();
		cenPanel.setBackground(Color.PINK);
		
		JLabel lbl = new JLabel("���̵� : ");
		tfID = new JTextField(10);
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		
		cenPanel.add(lbl);
		cenPanel.add(tfID);
		cenPanel.add(btnOK);
		
		add(cenPanel);
		
	}

//	public static void main(String[] args) {
//		new SubFrame("���� ������", 300, 300);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnOK) {
//			mainFrame.setTitle("�̰� �ǳ�...");
			tfID.setText(mainFrame.getTfID().getText());
		}
	
	
	}

}	
