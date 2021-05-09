package qna.kmj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//민주
public class MainPro extends JFrame implements ActionListener{

	private String mt[]  = {"열차","출발시간","도착역","도착시간"};
	private String contents[][]  = {
			{"새마을호", "10:41", "대전역", "12:31"},
			{"무궁화호", "15:48", "대전역", "16:11"},
			{"KTX", "15:48", "부산역", "19:08"},
			{"새마을호", "17:34", "부산역", "20:24"},
			{"무궁화호", "17:54", "부산역", "20:24"},
			{"새마을호", "20:20", "대구역", "22:20"},
	};
	private String []  station = {"서울역","대전역","대구역","부산역","광주역"};
	private JPanel jp1;
	private JPanel jp2;
	private JComboBox<String> cb;
	private JLabel lbl;
	private JTable table;
	private JScrollPane sp;
	private JPanel jp3;
	private JButton btn2;
	private JButton btn3;
	private JButton btn1;
	//private Reservation rs;


	public MainPro(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 수정 부분 1
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1,4, 5, 5));
		jp1.setBorder(BorderFactory.createEmptyBorder(10 , 20 , 10 , 20));
		
		cb = new JComboBox<String>(station);
		jp1.add(cb);
		jp1.add(new JLabel("   "));
		jp1.add(new JLabel("   "));
		jp1.add(new JLabel("   "));
		lbl = new JLabel("현재시각 : 12:22", JLabel.RIGHT);
		jp1.add(lbl);
		
		// 수정 부분 2
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2.setBorder(BorderFactory.createEmptyBorder(10 , 20 , 10 , 20));
		
		
		table = new JTable(contents, mt);
		table.setSize(500, 400);
		jp2.add(table);
		sp = new JScrollPane(table);
		jp2.add(sp);
	
		jp3 = new JPanel();
		jp3.setPreferredSize(new Dimension(180, 120));
		btn1 = new JButton("승차권예매");
		btn1.addActionListener(this);
		btn1.setPreferredSize(new Dimension(150, 35));
		btn1.setBounds(30, 30, 30, 30);
		jp3.add(btn1);
		
		btn2 = new JButton("승차권확인");
		btn2.addActionListener(this);
		btn2.setPreferredSize(new Dimension(150, 35));
		btn2.setBounds(30, 30, 30, 30);
		jp3.add(btn2);	
		
			
		btn3 = new JButton("로그아웃");
		btn3.addActionListener(this);
		btn3.setBounds(30, 30, 30, 30);
		btn3.setPreferredSize(new Dimension(150, 35));
		jp3.add(btn3);
		
		
		
		
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainPro("메인", 600, 500);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				
		if(obj == btn1) {
			//rs = new Reservation("승차권예매", 300, 460, this);
		}else if (obj == btn2) {
			
		}
		
	}




}
