package jaemin.file;

import java.io.*;

public class BufferedReaderEx {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("src\\jaemin\\file\\역별일별_이용인원현황.csv"));
            bw = new BufferedWriter(new FileWriter("src\\jaemin\\file\\station.csv"));
            String line = null;
            while( (line = br.readLine()) != null) {
//                System.out.println(line);
                String[] arr = line.split(",");
                System.out.println(arr[2] + "," + arr[3]);
                bw.write(arr[2] + "," + arr[3] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br != null ) {
                    br.close();
                }
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
