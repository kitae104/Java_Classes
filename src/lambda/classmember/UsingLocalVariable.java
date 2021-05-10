package lambda.classmember;

public class UsingLocalVariable {		
	void method(final int arg) {		// 매개변수 변경 불가 
		final int localVar = 40;		// 지역 변수 변경 불가 
		
		// arg = 31; 					// 수정 불가 
		// localVar = 41; 				// 수정 불가 
		
		MyFunctionalInterface fi = () -> {
			System.out.println("arg: " + arg);
			System.out.println("localVar : " + localVar);
		};
		
		fi.method();
	}
}
