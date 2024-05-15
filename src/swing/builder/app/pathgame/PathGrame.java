package swing.builder.app.pathgame;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PathGrame
{

	private JFrame frmPathGame;
	
	String parent_dog = "\\/images/parent_dog.png";
	String puppy_dog = "\\/images/puppy_dog.png";
    String paw = "\\/images/paw.png";
    String thorns = "\\/images/thorns.png";
	
    Component[] comp1;
    Component[] comp2;
    Random random = new Random();
    String randomImage;
    JLabel[][] labels;								//
    String[][] imagesOrder = new String[5][2];		//
    ArrayList<String> list = new ArrayList<>();		//
    
    int count = 0;
    boolean win =true;

	private JLabel lblEnd;

	private JLabel lblMsg;
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PathGrame window = new PathGrame();
					window.frmPathGame.setLocationRelativeTo(null);
					window.frmPathGame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PathGrame()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmPathGame = new JFrame();
		frmPathGame.setTitle("Path Game");
		frmPathGame.setBounds(100, 100, 1313, 555);
		frmPathGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPathGame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 1275, 343);
		frmPathGame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(12, 10, 189, 323);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStart = new JLabel("New label");
		lblStart.setBounds(12, 79, 165, 159);
		panel_1.add(lblStart);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(128, 0, 0));
		panel_1_1.setBounds(1074, 10, 189, 323);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		lblEnd = new JLabel("");
		lblEnd.setBounds(12, 79, 165, 159);
		panel_1_1.add(lblEnd);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 128, 0));
		panel_1_2.setBounds(220, 10, 842, 152);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lbl_2_2 = new JLabel("");
		lbl_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_2_2, 1);
			}			
		});
		lbl_2_2.setBackground(new Color(0, 255, 0));
		lbl_2_2.setOpaque(true);
		lbl_2_2.setBounds(192, 10, 132, 132);
		panel_1_2.add(lbl_2_2);
		
		JLabel lbl_1_2 = new JLabel("");
		lbl_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_1_2, 1);
			}
		});
		lbl_1_2.setOpaque(true);
		lbl_1_2.setBackground(Color.GREEN);
		lbl_1_2.setBounds(30, 10, 132, 132);
		panel_1_2.add(lbl_1_2);
		
		JLabel lbl_3_2 = new JLabel("");
		lbl_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_3_2, 1);
			}
		});
		lbl_3_2.setOpaque(true);
		lbl_3_2.setBackground(Color.GREEN);
		lbl_3_2.setBounds(354, 10, 132, 132);
		panel_1_2.add(lbl_3_2);
		
		JLabel lbl_4_2 = new JLabel("");
		lbl_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_4_2, 1);
			}
		});
		lbl_4_2.setOpaque(true);
		lbl_4_2.setBackground(Color.GREEN);
		lbl_4_2.setBounds(516, 10, 132, 132);
		panel_1_2.add(lbl_4_2);
		
		JLabel lbl_5_2 = new JLabel("");
		lbl_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_5_2, 1);
			}			
		});
		lbl_5_2.setOpaque(true);
		lbl_5_2.setBackground(Color.GREEN);
		lbl_5_2.setBounds(678, 10, 132, 132);
		panel_1_2.add(lbl_5_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(0, 128, 0));
		panel_1_2_1.setBounds(220, 181, 842, 152);
		panel.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JLabel lbl_1_1 = new JLabel("");
		lbl_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_1_1, 0);				
			}
		});
		lbl_1_1.setOpaque(true);
		lbl_1_1.setBackground(Color.GREEN);
		lbl_1_1.setBounds(30, 10, 132, 132);
		panel_1_2_1.add(lbl_1_1);
		
		JLabel lbl_2_1 = new JLabel("");
		lbl_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_2_1, 0);	
			}
		});
		lbl_2_1.setOpaque(true);
		lbl_2_1.setBackground(Color.GREEN);
		lbl_2_1.setBounds(192, 10, 132, 132);
		panel_1_2_1.add(lbl_2_1);
		
		JLabel lbl_3_1 = new JLabel("");
		lbl_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_3_1, 0);	
			}
		});
		lbl_3_1.setOpaque(true);
		lbl_3_1.setBackground(Color.GREEN);
		lbl_3_1.setBounds(354, 10, 132, 132);
		panel_1_2_1.add(lbl_3_1);
		
		JLabel lbl_4_1 = new JLabel("");
		lbl_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_4_1, 0);
				
			}
		});
		lbl_4_1.setOpaque(true);
		lbl_4_1.setBackground(Color.GREEN);
		lbl_4_1.setBounds(516, 10, 132, 132);
		panel_1_2_1.add(lbl_4_1);
		
		JLabel lbl_5_1 = new JLabel("");
		lbl_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionCheck(lbl_5_1, 0);	
			}
		});
		lbl_5_1.setOpaque(true);
		lbl_5_1.setBackground(Color.GREEN);
		lbl_5_1.setBounds(678, 10, 132, 132);
		panel_1_2_1.add(lbl_5_1);
		
		displayImage(puppy_dog, lblStart);
		
		JButton btnPlay = new JButton("Play Game");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomImages();
				
				for(JLabel[] l : labels) {
					l[0].setIcon(null);
					l[1].setIcon(null);
				}
				
				lblEnd.setIcon(null);
				
				win = true;
				count = 0;
				
				enableLabels(count);
				
				lblMsg.setText("");
			}
		});
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setBackground(new Color(0, 0, 0));
		btnPlay.setFont(new Font("굴림", Font.BOLD, 20));
		btnPlay.setBounds(1004, 386, 283, 98);
		frmPathGame.getContentPane().add(btnPlay);
		
		lblMsg = new JLabel("");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("굴림", Font.BOLD, 36));
		lblMsg.setBounds(140, 400, 628, 75);
		frmPathGame.getContentPane().add(lblMsg);
		
		labels = new JLabel[][] {					// labels 배열 
			{lbl_1_1, lbl_1_2},
			{lbl_2_1, lbl_2_2},
			{lbl_3_1, lbl_3_2},
			{lbl_4_1, lbl_4_2},
			{lbl_5_1, lbl_5_2},
		};
		
		for (JLabel[] lbl : labels)
		{
			lbl[0].setEnabled(false);
			lbl[1].setEnabled(false);
		}
		
		list.add(paw);			// 발자국
		list.add(thorns);		// 덤블 
		
		randomImages();			// 랜덤 이미지 만들기 
	}
	
	public void displayImage(String imgPath, JLabel label) {
		
		ImageIcon img = new ImageIcon(getClass().getResource(imgPath));
		Image image = img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(image));
	}
	
	public void randomImages(){
		for (int i = 0; i < labels.length; i++)
		{
			randomImage = list.get(random.nextInt(list.size()));	// 랜덤 이미지 생성 
			imagesOrder[i][0] = randomImage;
			
			if(randomImage.equals(paw)) {
				imagesOrder[i][1] = thorns;			
			} else {
				imagesOrder[i][1] = paw;
			}
			
			System.out.println(imagesOrder[i][0]);
			System.out.println(imagesOrder[i][1]);
			System.out.println();
		}
	}
	
	private void actionCheck(JLabel label, int num)
	{
		enableLabels(count);
		if(label.isEnabled()) {
			displayImage(imagesOrder[count][num], label);
			
			if(imagesOrder[count][num].equals(thorns)) {
				win = false;
			}
			
			label.setEnabled(false);
			
			if(imagesOrder.length-1 == count && win == true) {
				displayImage(parent_dog, lblEnd);
				lblMsg.setText("Puppy meets Mummy!");
			} else if(win == false) {
				lblMsg.setText("OOPS! Puppy got TRAPPED!");
			}
			
			count++;
			enableLabels(count);
		}
	}	
	
	public void enableLabels(int i) {
		if(i <= labels.length -1 ) {
			JLabel[] l = labels[i];
			l[0].setEnabled(true);
			l[1].setEnabled(true);
		}
	}
}
