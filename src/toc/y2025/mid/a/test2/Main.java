package toc.y2025.mid.a.test2;

import toc.y2025.mid.a.test1.Student;

public class Main {

	public static void main(String[] args) {
		Student[] students = { 
				new Student("홍길동", 90, 85, 88), 
				new ScholarshipStudent("이몽룡", 95, 94, 97),
				new ScholarshipStudent("성춘향", 80, 85, 83) 
		};

		for (Student s : students) {
			System.out.println("이름: " + s.getName());
			System.out.printf("평균: %.2f\n", s.getAverage());
			System.out.println("등급: " + s.getGrade());
			if (s instanceof ScholarshipStudent) {
				System.out.println("장학금 대상 여부: " + ((ScholarshipStudent) s).isEligible());
			} else {
				System.out.println("장학금 대상 여부: false");
			}
			System.out.println("장학금 대상 여부: " + s.isEligible());
			System.out.println();
		}

	}

}
