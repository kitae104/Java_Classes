package statics.qna.params;

public class B  {
	
	private String name;
	private A a;
	public B(String name, A a) {
		super();
		this.name = name;
		this.a = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}	
	
	public void test(Object a, B b) {
		A aaa = (A)a;
		int c = aaa.getA();
		
		String s = b.getName();
		System.out.println(c + ", " + s);
	}
	
}
