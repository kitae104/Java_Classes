package test.y23_1_m.aban;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class LayoutTest extends JFrame implements ActionListener {

	private final JButton btnStar;
	private final JButton btnRight;
	private JComboBox cb;
	private JButton btnCalc;
	private JLabel lblResult;
	private JTextField tf1;
	private JTextField tf2;
	private Test_C_Frame frame;
	private JButton btnOk;
	
	public LayoutTest(String title, int width, int height, Test_C_Frame frame) {
		this.frame = frame;
		setTitle(title);
		setSize(width, height);
		setLocation(600, 200); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		JPanel panelBase = new JPanel();
		panelBase.setLayout(new GridLayout(1, 2, 10, 10));
		panelBase.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.YELLOW);	
		
		JLabel lbl1 = new JLabel("숫자1");		
		panelLeft.add(lbl1);

		tf1 = new JTextField(10);
		panelLeft.add(tf1);

		JLabel lbl2 = new JLabel("숫자2");
		panelLeft.add(lbl2);

		tf2 = new JTextField(10);
		panelLeft.add(tf2);
				
		panelBase.add(panelLeft);
		
		JPanel panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(5, 1, 10, 10));
		panelRight.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		panelRight.setBackground(Color.GREEN);		
		
		JLabel lbl3 = new JLabel("연사자를 선택하세요.");	
		Vector<String> op = new Vector<>();
		op.add("+");
		op.add("-");
		op.add("*");
		op.add("/");
		
		cb = new JComboBox<>(op);
		
		JLabel lbl4 = new JLabel("결과를 확인하세요.");	
		
		btnCalc = new JButton("계산");
		btnCalc.addActionListener(this);
		
		lblResult = new JLabel("결과 : 0");
		
		
		panelRight.add(lbl3);
		panelRight.add(cb);
		panelRight.add(lbl4);
		panelRight.add(btnCalc);
		panelRight.add(lblResult);
		
		
		panelBase.add(panelRight);
		
		add(panelBase);
		
		JPanel panelButtom = new JPanel();
		panelButtom.setBorder(BorderFactory.createEmptyBorder(5 , 10 , 10 , 10));
		//panelButtom.setBackground(Color.GRAY);
		
		btnOk = new JButton("<<");
		btnOk.addActionListener(this);
		panelButtom.add(btnOk);
		
		btnStar = new JButton("별찍기 폼");
		btnStar.addActionListener(this);
		panelButtom.add(btnStar);
		
		btnRight = new JButton(">>");
		btnRight.addActionListener(this);
		panelButtom.add(btnRight);
		
		
		
		add(panelButtom, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LayoutTest("레이아웃 과제", 350, 250, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnCalc) {
			int val1 = Integer.parseInt(tf1.getText());
			int val2 = Integer.parseInt(tf2.getText());
			int result = 0;
			String op = (String) cb.getSelectedItem();
			switch(op) {
			case "+":
				result = val1 + val2;
				break;
			case "-":
				result = val1 - val2;
				break;
			case "*":
				result = val1 * val2;
				break;
			case "/":
				result = val1 / val2;
				break;
			}			
			lblResult.setText("결과 : " + result);
		} else if(obj == btnOk) {
			DefaultListModel<String> model = frame.getModel();
			model.addElement(lblResult.getText());
		} else if(obj == btnStar){
			new ResultFrame("별찍기 폼", 300, 250);
		}
		
	}

}
