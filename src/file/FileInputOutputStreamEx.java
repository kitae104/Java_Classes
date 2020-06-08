package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamEx {

	public static void main(String[] args) {
		FileOutputStream fout = null; 
		FileInputStream fin = null;
		try {
			fout = new FileOutputStream("c:\\temp\\test.out");			
			for (int i=0; i<10; i++) {
				int n = 100-i; // 계산의 결과를 저장
				fout.write(n); // 파일에 결과값을 바이너리로 저장
			}
			fout.close();
			
			fin = new FileInputStream("c:\\temp\\test.out"); 
			int c; 
			while((c = fin.read()) != -1) {
				System.out.print(c + " ");
			}	
			fin.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
