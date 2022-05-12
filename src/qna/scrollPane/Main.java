package qna.scrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Main extends JFrame {
private static JMenuBar mb;
private static JLabel lbl,logoLabel,imageLabel1,imageLabel2,imageLabel3
,imageLabel01,newItemText,rcmdItemText;
private static JMenu menu,menuCategory,menuSearch,menuMyPage,menuCart;
private static JMenuItem menuItemLogIn,menuItemJoinUs,menuItemMyPage;
private static ImageIcon logo,newitem1,newitem2,newitem3,rcmdItem;
private static JFrame jf;
private static JPanel container,newPanel,newPanel2;

   public Main(String title, int width, int height) {
      
      jf = new JFrame();
      jf.setTitle(title);
      jf.setSize(width,height);
      jf.setLocationRelativeTo(this);
      jf.setLayout(new BorderLayout());
      jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
      jf.setVisible(true);
      
      Container c = getContentPane();
      
      JScrollPane sp = new JScrollPane(container,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      JScrollBar scroll = new JScrollBar();
         
      jf.add(sp,BorderLayout.EAST);
      jf.add(scroll,BorderLayout.EAST);
      
       newPanel = new JPanel();
      newPanel.setLayout(new BorderLayout());
      newPanel.setBackground(Color.yellow);
      newPanel.setSize(1000, 300);
      newPanel.setLocation(500, 300);
      newPanel.setVisible(true);
      
      newPanel2 = new JPanel();
      newPanel2.setLayout(new BorderLayout());
      newPanel2.setBackground(Color.pink);
      newPanel2.setSize(1000, 300);
      newPanel2.setLocation(500, 700);
      newPanel2.setVisible(true);
      
       container = new JPanel();
       container.setLayout(new FlowLayout());
       container.setBackground(Color.WHITE);
       
       makeMenu();
       
       jf.add(newPanel);
       jf.add(newPanel2);
       jf.add(container);
       jf.setPreferredSize(new Dimension(1000,800));
       jf.setLocation(400, 200);
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jf.setVisible(true);
       jf.pack();
       
       
       newItem();
       
       rcmdItem();
       
       
       }
   

   private void rcmdItem() {
      rcmdItemText = new JLabel("추천 상품");
      rcmdItemText.setLayout(new BorderLayout());
      
      rcmdItem = new ImageIcon("images/향수추천.PNG");
       imageLabel01 = new JLabel(rcmdItem);
       imageLabel01.setPreferredSize(new Dimension(200,200));
            
       newPanel2.add(rcmdItemText,BorderLayout.NORTH);
       newPanel2.add(imageLabel01,BorderLayout.CENTER);
}


private void newItem() {
      newItemText = new JLabel("이번 달 신상품");
      newItemText.setLayout(new BorderLayout());
      
      newitem1 = new ImageIcon("images/pf01.jpg");
       imageLabel1 = new JLabel(newitem1);
       imageLabel1.setPreferredSize(new Dimension(250,250));
       
       newitem2 = new ImageIcon("images/pf02.jpg");
       imageLabel2 = new JLabel(newitem2);
       imageLabel2.setPreferredSize(new Dimension(250,250));
       
       newitem3 = new ImageIcon("images/pf03.jpg");
       imageLabel3 = new JLabel(newitem3);
       imageLabel3.setPreferredSize(new Dimension(250,250));
       
       newPanel.add(newItemText,BorderLayout.NORTH);
       newPanel.add(imageLabel1,BorderLayout.WEST);
       newPanel.add(imageLabel2,BorderLayout.CENTER);
       newPanel.add(imageLabel3,BorderLayout.EAST);
}


   private static void makeMenu() {
     logo = new ImageIcon("images/javacoco.png");
      logoLabel = new JLabel(logo);
      logoLabel.setHorizontalAlignment(JLabel.CENTER);
      //lbl = new JLabel("JAVA COCO");
      //lbl.setFont(new Font("Gramond", Font.BOLD, 100));
      //lbl.setHorizontalAlignment(JLabel.CENTER);
      
      mb = new JMenuBar();
      mb.setLayout(new FlowLayout(FlowLayout.CENTER, 265, 20));
      mb.setBackground(Color.WHITE);
      
      Font font = new Font("HY견명조", Font.BOLD, 25);
      Font font2 = new Font("HY견명조", Font.PLAIN, 18);
      menuCategory = new JMenu("category");
      
      menuCategory.setFont(font);
     
         
      menuSearch = new JMenu("search");
      menuSearch.setFont(font);
         
      menuMyPage = new JMenu("MyPage");
      menuMyPage.setFont(font);
      menuItemLogIn = new JMenuItem("Log In");
      menuItemLogIn.setFont(font2);
      menuMyPage.add(menuItemLogIn);
      menuItemJoinUs = new JMenuItem("Join Us");
      menuItemJoinUs.setFont(font2);
      menuMyPage.add(menuItemJoinUs);
      menuItemMyPage = new JMenuItem("My Page");
      menuItemMyPage.setFont(font2);
      menuMyPage.add(menuItemMyPage);
         
      menuCart = new JMenu("cart");
      menuCart.setFont(font);

       mb.add(menuCategory);
       mb.add(menuSearch);
       mb.add(menuMyPage);
       mb.add(menuCart);
       
       container.add(logoLabel);
       container.add(mb);
   }
   
   public static void main(String[] args) {
      Main mp = new Main("JavaCoco",1000,1000);
   }

}