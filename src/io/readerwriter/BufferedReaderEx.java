package io.readerwriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderEx
{

	public static void main(String[] args) throws IOException
	{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		System.out.print("입력 : ");
		String lineString = br.readLine();
		System.out.println("출력 : " + lineString);
		
		br.close();
		reader.close();
		is.close();		
	}

}
