package io.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx
{

	public static void main(String[] args) throws IOException
	{
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		int readByte;
		
		while((readByte = is.read()) != -1){
			System.out.println((char)readByte);  	// 숫자로 읽어옴 -> 형변환 후 문자로 출력  
		}
		is.close();
	}

}
