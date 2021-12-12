package io.readerwriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx1
{

	public static void main(String[] args)
	{
		Reader reader = null;
		try
		{
			reader = new FileReader("C:/Temp/test.txt");
			int readData;
			
			while((readData = reader.read()) != -1)
			{
				System.out.println((char)readData);
			}
			
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("파일을 찾는 중 오류 발생.");
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			System.out.println("입출력시 오류 발생.");
			e.printStackTrace();
		}
		finally {
			try
			{
				reader.close();
			} 
			catch (IOException e)
			{
				System.out.println("파일을 닫는 과정에서 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}
	}
}
