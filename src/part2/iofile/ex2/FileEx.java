package part2.iofile.ex2;

import java.io.File;

public class FileEx {

  public static void main(String[] args) {
    File f1 = new File("C:/Temp1/");
    File f2 = new File("C:/Temp1/test.txt");

    String res = "";
    if (f2.isFile()) {
      res = "파일";
    } else {
      res = "폴더";
    }
    System.out.println("결과 : " + res);

    if (!f1.exists()) {
      f1.mkdir();
    }


    f2.renameTo(new File("C:/Temp1/abc.txt"));

    String[] fileList = f1.list();
    for (String name : fileList) {
      System.out.println(name);
    }
  }

}
