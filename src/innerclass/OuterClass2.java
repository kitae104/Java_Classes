package innerclass;

public class OuterClass2
{
	public void someMethod() {
		// 지역 내부 클래스 
        class InnerClass2 {
            public void doSomething() {
                System.out.println("Doing something");
            }
        }

        InnerClass2 innerClass = new InnerClass2();
        innerClass.doSomething();
    }

    public static void main(String[] args) {
        OuterClass2 outerClass = new OuterClass2();
        outerClass.someMethod();
    }
}
