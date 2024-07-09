package innerclass;

public class OuterClass1
{
	private int x = 10;
	
	// 멤버 내부 클래스 
    public class InnerClass1 {
        public void printX() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        OuterClass1 outerClass = new OuterClass1();
        OuterClass1.InnerClass1 innerClass = outerClass.new InnerClass1();
        innerClass.printX();
    }
}
