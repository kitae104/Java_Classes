package io.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx3
{

	public static void main(String[] args) throws IOException
	{
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		int readByteNo;
		byte[] readBytes = new byte[3];
		String data = "";
		
		while((readByteNo = is.read(readBytes)) != -1) 
		{
			System.out.println(readByteNo);
			data += new String(readBytes, 0, readByteNo);
			System.out.println(data);
			
		}
		is.close();
	}

}
