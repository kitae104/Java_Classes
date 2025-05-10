package io.readerwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterEx {

  public static void main(String[] args) {
    FileOutputStream fos = null;
    Writer writer = null;
    try {
      fos = new FileOutputStream("C:/Temp/file.txt");
      writer = new OutputStreamWriter(fos);

      String str = "바이트 출력 스트림을 문자열 출력 스트림으로 변환";
      writer.write(str);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        writer.flush();
        writer.close();
        fos.close();
        System.out.println("파일 저장이 끝났습니다.");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
