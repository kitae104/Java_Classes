package io.console;

import java.io.IOException;
import java.io.InputStream;

public class SystemIn2
{

	public static void main(String[] args)
	{
		InputStream is = System.in;
		byte[] datas = new byte[100];
		
		System.out.print("이름 : ");
		try
		{
			int nameBytes = is.read(datas);
			String name = new String(datas, 0, nameBytes - 2);	// cr, lf 제외
			
			System.out.println("하고 싶은 말 : ");
			int commentBytes = is.read(datas);
			String comment = new String(datas, 0, commentBytes - 2);
			
			System.out.println("입력한 이름 : " + name);
			System.out.println("하고 싶은 말 : " + comment);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				is.close();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
