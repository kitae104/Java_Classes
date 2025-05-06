package part2.lambda.ex5;

public class LambdaTest {

	public static void main(String[] args) {
		Television tv = new Television();
		tv.volumnUp();	// TV 볼륨을 올립니다.
		tv.volumnDown();	// TV 볼륨을 내립니다.
		
		RemoteControl rc = new RemoteControl() {
			@Override
			public void volumnUp() {
				System.out.println("TV 볼륨을 올립니다.");
			}
			
			@Override
			public void volumnDown() {
				System.out.println("TV 볼륨을 내립니다.");
			}
		};

		rc.volumnUp();	// TV 볼륨을 올립니다.
		rc.volumnDown();	// TV 볼륨을 내립니다.
		
		Calculator cal = new Calculator() {
			@Override
			public int calc(int a, int b) {
				return a + b;
			}			
		};
		int result2 = cal.calc(30, 50);	// 80
		System.out.println("result2 = " + result2);
		
		// 람다식으로 구현
		Calculator cal2 = (a, b) -> a + b;	// 람다식으로 구현
		int result = cal2.calc(3, 5);	// 8
		System.out.println("result = " + result);
	}

}
