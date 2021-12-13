package io.console;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOut
{

	public static void main(String[] args) throws IOException
	{
		OutputStream os = System.out;
		
		// 숫자 
		for (byte b = 48; b < 58; b++) // 0 ~ 9까지 출력 
		{
			os.write(b);
		}
		
		System.out.println();
		
		// 알파벳 
		for (byte b = 97; b < 123; b++)
		{
			os.write(b);
		}
		
		os.write(13);    // 개행 
		//한글 
		String hangul = "가나다라마바사아자차카타파하";
		byte[] hangulBytes = hangul.getBytes();
		
		os.write(hangulBytes);
		
		os.flush();
	}

}
