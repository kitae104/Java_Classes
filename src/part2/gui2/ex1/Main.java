package part2.gui2.ex1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
  private JPanel CalculatorForm;
  private JTextField txtName;
  private JLabel lblName;
  private JButton btnClick;

  public Main() {
    setTitle("Calculator");
    setContentPane(CalculatorForm);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 200);
    setLocationRelativeTo(null);
    setVisible(true);
    btnClick.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String firstName = txtName.getText();
        JOptionPane.showMessageDialog(Main.this, "Hello : " + firstName);
      }
    });
  }

  public static void main(String[] args) {
    new Main();
  }
}
