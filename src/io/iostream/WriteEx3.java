package io.iostream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx3
{
	public static void main(String[] args)
	{
		OutputStream os = null;
		try
		{
			os = new FileOutputStream("C:/Temp/test1.txt");
			
			byte[] data = "ABC".getBytes();
			os.write(data, 1, 2);		// 시작 인덱스와 크기 주어 바이트 배열 출력하기 
			
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("파일을 찾을 수 없습니다.");
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
				os.flush();		// 버퍼 내용 출력
				os.close();		// 스트림 닫기
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}		 
			
		}
	}
}
