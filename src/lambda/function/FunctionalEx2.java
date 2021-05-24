package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionalEx2 {

	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 90, 96), 
			new Student("최길동", 95, 93) );
	
	public static double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for (Student student : list) {
			sum += function.applyAsInt(student);
		}
		double avg = sum / list.size();
		return avg;
	}
	
	public static void main(String[] args) {
		double engAvg = avg(t -> t.getEngScore());
		System.out.println("영어 평균 점수 : " + engAvg);
		
		double mathAvg = avg(t -> t.getMathScore());
		System.out.println("수학 평균 점수 : " + engAvg);
	}

}
