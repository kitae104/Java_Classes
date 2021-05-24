package lambda.and_or_negate;

import java.util.function.Predicate;

public class PridicateIsEqualEx {

	public static void main(String[] args) {
		
		Predicate<String> predicate;
		
		predicate = Predicate.isEqual(null);
		System.out.println("null, null : " + predicate.test(null));
		
		predicate = Predicate.isEqual("Java");
		System.out.println("null, Java : " + predicate.test(null));
		
		predicate = Predicate.isEqual("Java");
		System.out.println("Java, Java : " + predicate.test("Java"));
		
	}
}
