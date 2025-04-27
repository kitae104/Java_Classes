package toc.y2025.mid.a.test1;

public class Main {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 90, 85, 88);
		System.out.printf("%.2f\n",s.getAverage());  // 87.67
		System.out.println(s.getGrade());    // B
	}
}
