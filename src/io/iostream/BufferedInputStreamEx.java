package io.iostream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamEx
{

	public static void main(String[] args)
	{
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		BufferedInputStream bis = null;
		try
		{
			fis1 = new FileInputStream("images/dog.jpg");
			start = System.currentTimeMillis();
			
			while(fis1.read() != -1) {}
			end = System.currentTimeMillis();
			System.out.println("사용하지 않았을 때 : " + (end - start));
			
			fis2 = new FileInputStream("images/dog.jpg");
			bis = new BufferedInputStream(fis2);			
			start = System.currentTimeMillis();
			
			while(bis.read() != -1) {}
			end = System.currentTimeMillis();
			System.out.println("사용했을 때 : " + (end - start));
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				bis.close();
				fis2.close();
				fis1.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
