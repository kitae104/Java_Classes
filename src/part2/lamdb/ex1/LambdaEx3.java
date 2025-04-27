package part2.lamdb.ex1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ddd", "bbb", "aaa", "eee", "ddd");
		System.out.println(list);
		
		// Collections 사용 
		Collections.sort(list);
		System.out.println(list);
		
		// 역순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		
		list = Arrays.asList("ddd", "bbb", "aaa", "eee", "ddd");
		// 기존의 방식 (익명 내부 클래스)
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        System.out.println(list);

        // 람다식(함수형 인터페이스 사용)
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
        System.out.println(list);
		
		// 오른차순 정렬
		list = Arrays.asList("ddd", "bbb", "aaa", "eee", "ddd");
		list.sort((s1, s2) -> s1.compareTo(s2));
		System.out.println(list);
				
		list.sort((s1, s2) -> s2.compareTo(s1)); // 역순 정렬
		System.out.println(list);

	}

}
