package io.iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx2
{
	public static void main(String[] args) throws IOException
	{
		OutputStream os = new FileOutputStream("C:/Temp/test1.txt");
		byte[] data = "ABC".getBytes();
		
		for(int i=0; i<data.length; i++)
		{
			os.write(data[i]);
		} 
		os.flush();		// 버퍼 내용 출력 
		os.close();		// 스트림 닫기 
	}
}
