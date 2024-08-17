package jaemin.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterEx {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            FileWriter fw = new FileWriter("src\\jaemin\\file\\test.txt");
            int c = 0;
            while( (c = isr.read()) != -1) {
                fw.write(c);
            }
            isr.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("파일 생성 실패");
        }
    }
}
