package io.scanner;

import java.util.Scanner;

public class ScannerEx
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력 > ");
		String inputString = scan.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("정수 입력 >");
		int inputInt = scan.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		System.out.print("실수 입력 >");
		int inputDouble = scan.nextInt();
		System.out.println(inputDouble);
		System.out.println();
	}

}
