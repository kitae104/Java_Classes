package io.readerwriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderEx
{

	public static void main(String[] args)
	{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		
		int readCharNo;
		char[] cbuf = new char[100];
		
		try
		{
			while((readCharNo = reader.read(cbuf)) != -1) // ctrl + z 
			{
				String data = new String(cbuf, 0, readCharNo);
				System.out.println(data);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
				is.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}

}
