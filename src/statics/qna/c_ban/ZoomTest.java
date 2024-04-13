package statics.qna.c_ban;

public class ZoomTest
{

	public static void main(String[] args)
	{
		Zoom.cnt = 1000;		
		
		
		Zoom z1 = new Zoom(1, "Java-C", true);
	
		
		Zoom z2 = new Zoom();
		
		int total = Zoom.cnt;
		
		System.out.println("전체 개설된 방의 개수 : " + total);

		ZoomTest zt = new ZoomTest();	
		zt.test();
		
	}

	
	public void test() {
		System.out.println("abc");
	}
	
}
