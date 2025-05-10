package part2.iofile.ex1;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class InputReaderWriter {
  public static void main(String[] args) {
    InputStreamReader isr = new InputStreamReader(System.in);
    FileWriter fw = null;
    System.out.println("현재 작업 경로: " + System.getProperty("user.dir"));

    int data = 0;

    try {
      fw = new FileWriter("test.txt");
      while ((data = isr.read()) != -1) {
        fw.write(data);
      }
      System.out.println("입력한 내용을 test.txt에 저장했습니다.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (fw != null) {
          fw.close();
        }
        if (isr != null) {
          isr.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
