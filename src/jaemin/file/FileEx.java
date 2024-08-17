package jaemin.file;

import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        File f1 = new File("src\\jaemin\\file\\역별일별_이용인원현황.csv");
        File f2 = new File("src\\jaemin\\file");
        File f3 = new File("src\\jaemin\\file\\abc");

        if(f1.isFile()){
            System.out.println("파일");
        } else {
            System.out.println("디렉토리");
        }

        if(f3.exists()){
            System.out.println("경로가 존재합니다.");
        } else {
            System.out.println("경로가 존재하지 않습니다.");
            f3.mkdir();
        }

        if(f2.isDirectory()){
            System.out.println("디렉토리");
            System.out.println(f2.getAbsolutePath());
            directoryInfo(f2);
        } else {
            System.out.println("파일");
        }
    }

    private static void directoryInfo(File info) {
        File[] files = info.listFiles();
        for (File file : files) {
            if(file.isFile()){
                long t = file.lastModified();
                System.out.printf("%-28s 파일 크기 : %6d  수정시간: %tb %td %ta %tT\n",file.getName(), file.length(), t, t, t, t);
            }

        }
    }
}
