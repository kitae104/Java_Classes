package lambda.classmember;

public class UsingThis {
	public int outterField = 10;

	class Inner {
		int innerField = 20;

		void method() {
			//람다식
			MyFunctionalInterface fi= () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField + "\n"); // 외부에 있는 필드를 명확인 작성
				
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField + "\n");	// 현재 클래스에 있는 필드 
			};
			
			fi.method();
		}
	}
}