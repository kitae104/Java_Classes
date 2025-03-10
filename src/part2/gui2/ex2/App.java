package part2.gui2.ex2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
  private JPanel panMain;
  private JTextField tfCelsius;
  private JLabel lblCelsius;
  private JButton btnConvert;
  private JLabel lblFahrenheit;

  public App(String title) {

    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(panMain);
//    setSize(400, 200);
    setLocationRelativeTo(null);
    pack();
    setVisible(true);

    btnConvert.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int tempFahr = (int) ((Double.parseDouble(tfCelsius.getText())) * 1.8 + 32);
        lblFahrenheit.setText("화씨 : " + tempFahr);
      }
    });
  }

  public static void main(String[] args) {
    new App("나의 GUI 프레임");
  }
}
