package toc.y2025.mid.a.test1;

public class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public double getAverage() {
        return (kor + eng + math) / 3.0;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else {
            return "F";
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}	
	
    
	public boolean isEligible() {
        return false;
    }
}
