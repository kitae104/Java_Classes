package innerclass;

public class OuterClass1
{
	private int y = 10;
	
	// 멤버 내부 클래스 
    public class InnerClass1 {
    	private int x = 20;
        public void printX() {
            System.out.println(y);
        }
    }

    public static void main(String[] args) {
        OuterClass1 outerClass = new OuterClass1();
        OuterClass1.InnerClass1 innerClass = outerClass.new InnerClass1();
        innerClass.printX();
    }
}
