package io.console;

import java.io.Console;

public class ConsoleEx
{

	public static void main(String[] args)
	{
		Console console = System.console();
		
		System.out.print("아이디 : ");
		String id = console.readLine();
		
		System.out.print("패스워드 : ");
		char[] pw = console.readPassword();
		String strPassword = new String(pw);
		
		System.out.println("------------------------");
		System.out.println(id);
		System.out.println(strPassword);
	}

}
