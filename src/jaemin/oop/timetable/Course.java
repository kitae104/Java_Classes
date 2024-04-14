package jaemin.oop.timetable;

public class Course {
	public String name;				// 과목명
	public String professor;		// 교수명
	public String roomNumber;		// 강의실 이름
	public boolean isValid = true;			// 유효성 여부(기본적으로 ture로 설정)

	// 기본 생성자
	public Course() {
		this.name = null;
		this.professor = null;
		this.roomNumber = null;
	}

	// 과목명, 교수명, 강의실 이름을 받아서 초기화 (except isValid)
	public Course(String name, String tutor, String room) {
		this.name = name;
		this.professor = tutor;
		this.roomNumber = room;
	}

	public Course(String name) {
		this.name = name;
	}

	// 복사 생성자
	public Course(Course copy) {
		this.name = copy.name;
		this.professor = copy.professor;
		this.roomNumber = copy.roomNumber;
		this.isValid = copy.isValid;
	}
	public void setName(String name) {
		this.name = name;
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
		return "\nProfessor : " + professor + "\nRoom : " + roomNumber;
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
		return "\nName : " + name;
	}

	public String getDetails() {
		return toString() + getState();
		//return "\nName : " + name + "\nProfessor : " + professor + "\nRoom : " + roomNumber;
	}


	// 과목이 설정될 때 해당 필드를 false로 변경하여 해당 위치에 다른 과목을 등록하지 못하게 함
	public void setValid(boolean b) {
		this.isValid = b;
	}

	// 현재 시간표가 유효한지 확인(일반적으로는 true이고 해당 위치에 과목이 있는 경우 false 반환)
	public boolean isValid() {
		return isValid;
	}


}