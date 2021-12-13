package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx
{

	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("src/file/FileOutputStreamEx.java");
		int readCharNo;
		
		char[] cBuf = new char[100];
		
		while((readCharNo = fr.read(cBuf)) != -1) 
		{
			String data = new String(cBuf, 0, readCharNo);
			System.out.println(data);
		}
		
		fr.close();
	}

}
