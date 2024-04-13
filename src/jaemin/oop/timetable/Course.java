package jaemin.oop.timetable;

public class Course {
	public String name;				// 과목명
	public String professor;		// 교수명
	public String roomNumber;		// 강의실 이름
	public boolean isValid;			// 유효성 여부(기본적으로 ture로 설정)

	public Course() {
		/* Write your code*/
	}

	public Course(String name, String tutor, String room) {
		this.name = name;
		this.professor = tutor;
		this.roomNumber = room;
		this.isValid = true;
	}

	public Course(String name) {
		this.name = name;
	}

	public Course(Course copy) {
		this.name = copy.name;
		this.professor = copy.professor;
		this.roomNumber = copy.roomNumber;
		this.isValid = copy.isValid;
	}

	public String getName() {
		return name;
	}

	public String getProfessor() {
		return professor;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getState() {
		/* Write your code*/
		return "";
	}

	public void setState(String tutor, String room) {
		this.professor = tutor;
		this.roomNumber = room;
	}

	public boolean equals(Course s) {
		// 과목명, 교수명, 강의실 이름이 같으면 true 반환
		if(this.name.equals(s.name) && this.professor.equals(s.professor) && this.roomNumber.equals(s.roomNumber))
			return true;
		return false;
	}

	public String toString() {
		return "Name : " + name;
	}

	public String getDetails() {
		return "\nName : " + name + "\nProfessor : " + professor + "\nRoom : " + roomNumber;
	}


	public void setValid(boolean b) {
		this.isValid = b;
	}

	public boolean isValid() {
		return isValid;
	}
}