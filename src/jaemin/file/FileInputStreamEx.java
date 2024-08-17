package jaemin.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) throws Exception {
        FileReader fis = new FileReader("src\\jaemin\\file\\역별일별_이용인원현황.csv");
        int c = 0;
        while ((c = fis.read()) != -1) {
            System.out.print((char) c);
        }
        fis.close();
    }
}

