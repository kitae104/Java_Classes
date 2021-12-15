package io.console;

public class PrintfEx
{

	public static void main(String[] args)
	{
		System.out.printf("상품의 가격:%d원\n", 123);
		System.out.printf("상품의 가격:%6d원\n", 123);
		System.out.printf("상품의 가격:%-6d원\n", 123);
		System.out.printf("상품의 가격:%06d원\n", 123);

		System.out.printf("%6d | %-10s | %10s", 1, "홍길동", "도적");
	}

}
