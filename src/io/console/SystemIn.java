package io.console;

import java.io.IOException;
import java.io.InputStream;

public class SystemIn
{

	public static void main(String[] args)
	{
		System.out.println("==메뉴==");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료하기");
		System.out.print("메뉴를 선택하세요 : ");
		
		InputStream is = System.in;
		try
		{
			char inputChar = (char)is.read();
			
			switch(inputChar)
			{
			case '1':
				System.out.println("예금 조회를 선택하셨습니다.");
				break;
			case '2':
				System.out.println("예금 출금을 선택하셨습니다.");
				break;
			case '3':
				System.out.println("예금 입금을 선택하셨습니다.");
				break;
			case '4':
				System.out.println("종료하기를 선택하셨습니다.");
				break;
			}
		} 
		catch (IOException e)
		{			
			e.printStackTrace();
		}		
	}
}
