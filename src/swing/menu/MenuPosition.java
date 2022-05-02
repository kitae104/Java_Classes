package swing.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPosition {
	public static void main(String[] args) {
	    JFrame jf = new JFrame();

	    JPanel container = new JPanel();
	    container.setLayout(new BorderLayout());

	    JLabel label = new JLabel("North");
	    JMenuBar menuBar = new JMenuBar();

	    JMenu menu = new JMenu("A south menu");
	    menu.add(new JMenuItem("A south item"));

	    menuBar.add(menu);

	    container.add(label, BorderLayout.NORTH);
	    container.add(menuBar, BorderLayout.SOUTH);

	    jf.add(container);
	    jf.setPreferredSize(new Dimension(200,100));
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setVisible(true);
	    jf.pack();
	}
}
