package exception;

import java.util.Scanner;

public class ExceptionTest
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String[] db_id = {"java", "phoenix", "god"};
		
		System.out.println("다음 아이디중 입력하세요.");
		System.out.println("(java, phoenix, god)");
		
		String id = sc.nextLine();
		
		if(db_id[0].equals(id) || db_id[1].equals(id) || db_id[2].equals(id)) {
			System.out.println("로그인 성공");
		} else {
			try
			{
				throw new DuplicationException("예외발생");				
			} 
			catch (DuplicationException e)
			{
				System.out.println("예외 발생2");
				e.printStackTrace();
			}
			
		}
	}
}
