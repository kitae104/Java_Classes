package toc.y2025.mid.a.test2;

import toc.y2025.mid.a.test1.Student;

public class ScholarshipStudent extends Student {

	public ScholarshipStudent(String name, int kor, int eng, int math) {
		super(name, kor, eng, math);
	}

	@Override
	public boolean isEligible() {
        return getAverage() >= 90.0;
    }
	
	@Override
    public String getGrade() {
        String baseGrade = super.getGrade();
        if (isEligible()) {
            return baseGrade + "(장학생)";
        } else {
            return baseGrade + "(일반)";
        }
    }
}
