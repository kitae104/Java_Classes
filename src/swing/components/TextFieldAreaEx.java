package swing.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldAreaEx extends JFrame implements ActionListener {
		
	private JPanel panCenter, panBottom;
	private JTextArea ta;
	private JTextField tf;
	private JButton btn;
	
	public TextFieldAreaEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		setPanCenter();
		setPanBottom();
		
		add(panCenter, BorderLayout.CENTER);
		add(panBottom, BorderLayout.SOUTH);
		
		setVisible(true);
		tf.requestFocus();
	}
	
	private void setPanBottom() {
		panBottom = new JPanel();
//		panBottom.setBackground(Color.YELLOW);	
		
		tf = new JTextField(18);
		tf.addActionListener(this);
		
		btn = new JButton("입력");
		btn.addActionListener(this);
		
		panBottom.add(tf);
		panBottom.add(btn);
	}

	private void setPanCenter() {
		panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
//		panCenter.setBackground(Color.RED);
		
		ta = new JTextArea(7, 20);
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		panCenter.add(sp);		
	}

	public static void main(String[] args) {
		new TextFieldAreaEx("My 채팅창", 300, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn || obj == tf) {
			String msg = tf.getText();			
			if(!msg.equals("")) {
				ta.append("[남자] : " + tf.getText() + "\n");
				tf.setText("");
			}
		} 		
	}

}
