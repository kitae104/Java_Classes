package jaemin.file;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        File f1 = new File("c:\\windows\\explorer.exe");
        File f2 = new File("src\\jaemin\\file\\jaemin.exe");

        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(f2));
        int c = 0;
        while( (c = br.read()) != -1) {
            bw.write(c);
        }

        br.close();
        bw.close();
    }
}
