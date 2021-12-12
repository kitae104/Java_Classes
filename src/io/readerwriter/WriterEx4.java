package io.readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx4
{

	public static void main(String[] args)
	{	
		Writer writer = null;
		try
		{
			writer = new FileWriter("C:/Temp/test2.txt");
			
			String data = "안녕 자바 프로그램";
			writer.write(data);
			writer.write("\n");
			writer.write(data, 3, 2);
			
		} 
		catch (IOException e)
		{
			System.out.println("입출력 중 오류 발생.");
			e.printStackTrace();
		} 
		finally {
			try
			{
				writer.flush();
				writer.close();
			} 
			catch (IOException e)
			{
				System.out.println("파일을 닫는 과정에서 오류가 발생했습니다.");
				e.printStackTrace();
			}
			
		}
	}

}
