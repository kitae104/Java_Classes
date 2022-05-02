package exception;

import java.util.Scanner;

public class Score_Exception
{
	public static void main(String[] args) throws MinusException
	{
		int hakbun = 0, kor = 0, eng = 0, mat = 0, total = 0;
		double average;
		System.out.println("학번과 성적을 입력하세요...");
		
		Scanner sc = new Scanner(System.in);
		hakbun = sc.nextInt();

		kor = sc.nextInt();
		if(kor < 0) {
			throw new MinusException();
		}
		
		eng = sc.nextInt();
		if(eng < 0) {
			throw new MinusException();
		}
		
		mat = sc.nextInt();
		if(mat < 0) {
			throw new MinusException();
		}
		
		total = kor + eng + mat;
		average = (double)total/3;
		
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균" );
		System.out.println(hakbun + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total + "\t" + average);
	}
}
