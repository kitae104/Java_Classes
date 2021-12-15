package io.iostream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx
{

	public static void main(String[] args) throws Exception
	{
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("프린터 보조 스트림");
		ps.print("1123");
		ps.println("출력 테스트 중");
		
		ps.flush();
		ps.close();
		fos.close();
	}

}
