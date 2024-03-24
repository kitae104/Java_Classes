package swing.builder.app.pathgame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PathGrame
{

	private JFrame frmPathGame;
	
	String parent_dog = "\\/images/parent_dog.png";
	String puppy_dog = "\\/images/puppy_dog.png";
    String paw = "\\/images/paw.png";
    String thorns = "\\/images/thorns.png";
	
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
		
		JLabel lblEnd = new JLabel("New label");
		lblEnd.setBounds(12, 79, 165, 159);
		panel_1_1.add(lblEnd);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 128, 0));
		panel_1_2.setBounds(220, 10, 842, 152);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(192, 10, 132, 132);
		panel_1_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setBounds(30, 10, 132, 132);
		panel_1_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.GREEN);
		lblNewLabel_2.setBounds(354, 10, 132, 132);
		panel_1_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.GREEN);
		lblNewLabel_3.setBounds(516, 10, 132, 132);
		panel_1_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.GREEN);
		lblNewLabel_4.setBounds(678, 10, 132, 132);
		panel_1_2.add(lblNewLabel_4);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(0, 128, 0));
		panel_1_2_1.setBounds(220, 181, 842, 152);
		panel.add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(Color.GREEN);
		lblNewLabel_5.setBounds(30, 10, 132, 132);
		panel_1_2_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.GREEN);
		lblNewLabel_6.setBounds(192, 10, 132, 132);
		panel_1_2_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(Color.GREEN);
		lblNewLabel_7.setBounds(354, 10, 132, 132);
		panel_1_2_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(Color.GREEN);
		lblNewLabel_8.setBounds(516, 10, 132, 132);
		panel_1_2_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBackground(Color.GREEN);
		lblNewLabel_9.setBounds(678, 10, 132, 132);
		panel_1_2_1.add(lblNewLabel_9);
		
		displayImage(puppy_dog, lblStart);
	}
	
	public void displayImage(String imgPath, JLabel label) {
		
		ImageIcon img = new ImageIcon(getClass().getResource(imgPath));
		Image image = img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(image));
	}
}
