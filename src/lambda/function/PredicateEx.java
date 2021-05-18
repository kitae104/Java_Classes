package lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {

	private static List<PredicateData> list = Arrays.asList(
				new PredicateData("홍길동", "남자", 90),
				new PredicateData("김순희", "여자", 90),
				new PredicateData("감자바", "남자", 95),
				new PredicateData("박한나", "여자", 92)
			);
	
	public static double avg(Predicate<PredicateData> predicate) {
		
		int count = 0, sum = 0; 
		for (PredicateData data : list) {
			if(predicate.test(data)) {		// 내용을 조사해서 true 인 경우 동작 
				count++;
				sum += data.getScore();
			}
		}
		
		return (double)sum / count;
	}
	
	public static void main(String[] args) {
		
		// 남자 평균 점수 
		double maleAvg = avg(t -> t.getSex().equals("남자"));
		System.out.println("남자 평균 점수 : " + maleAvg);
		
		// 여자 평균 점수 
		double femaleAvg = avg(t -> t.getSex().equals("여자"));
		System.out.println("남자 평균 점수 : " + femaleAvg);
	}
}
