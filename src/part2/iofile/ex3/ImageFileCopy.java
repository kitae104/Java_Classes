package part2.iofile.ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileCopy {

  public static void main(String[] args) {
    String originalFileName = "images/dog.jpg";
    String targetFileName = "./test.jpg";

    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      fis = new FileInputStream(originalFileName);
      fos = new FileOutputStream(targetFileName);

      int readByteNo;
      byte[] readBytes = new byte[100];

      while ((readByteNo = fis.read(readBytes)) != -1) {
        fos.write(readBytes, 0, readByteNo);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fos.flush();
        fis.close();
        fos.close();
        System.out.println("복사가 잘 되었습니다.");
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
  }

}
