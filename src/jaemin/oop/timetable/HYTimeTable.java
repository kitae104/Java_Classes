package jaemin.oop.timetable;
import java.util.Calendar;
import java.util.Scanner;

public class HYTimeTable {
	Course[][] timeTable = new Course[5][11];		// 시간표 배열 (5일 11교시)
	Course subject = new Course();					// 과목 객체 생성
	
	public enum DAYS {								// 요일 enum
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public HYTimeTable() {
		// 배열 초기화 하라고 하지만 특별히 안해도 initailize 메소드에서 초기화를 해주기 때문에
		// 따로 초기화는 하지 않아도 됨(이건 사람들한테 물어봐).
		initialize();
	}

	private void initialize() {
		for (int i = 0; i < timeTable.length; i++) {
			for (int j = 0; j < timeTable[0].length; j++) {
				if(j == 3) {    										// 12시는 점심시간으로 고정
					timeTable[i][j] = new Course("LUNCH");
					timeTable[i][j].setValid(false);
				} else if(j == 8){										// 6시는 저녁시간으로 고정
					timeTable[i][j] = new Course("DINNER");
					timeTable[i][j].setValid(false);
				} else {
					timeTable[i][j] = new Course("----");
					timeTable[i][j].setValid(true);
				}
			}
		}
	}

	public String getSchedule(String day, int period) {
		int col = DAYS.valueOf(day).ordinal();			// 요일 enum을 이용하여 index값을 가져옴
		int row = period -9;							// 9교시부터 시작하기 때문에 9를 빼줌

		return "At that time you have : "  + timeTable[col][row].getDetails() + "\n" + toString();
 	}

	public boolean setSchedule(String day, int period, String name, String tutor, String room) {
		// 원본 행렬은 5 X 11 인데 출력할때와 입력할 때 행과 열이 바뀌어서 출력되기 때문에 col과 row를 바꿔줌
		int col = DAYS.valueOf(day).ordinal();			// 요일 enum을 이용하여 index값을 가져옴
		int row = period -9;							// 9교시부터 시작하기 때문에 9를 빼줌

		if(timeTable[col][row].isValid()) {				// 해당 시간에 과목이 없을 경우(해당 슬롯이 비었는지 확인 필요!!!)

			timeTable[col][row] = new Course(name, tutor, room);	// 간단히 생성자를 사용하면 편하지만 이렇게 하면 쓰레기 발생
//			timeTable[col][row].setName(name);			// 과목명 설정 - 이렇게 하기 위해서는 따로 setter를 추가해야 함
//			timeTable[col][row].setState(tutor, room);	// 교수명, 강의실 이름 설정
			timeTable[col][row].setValid(false);		// 값을 채워 넣었기 때문에 유효성을 false로 변경
			return true;
		}
		return false;
	}
	public boolean deleteSchedule(String day, int period) {
		int col = DAYS.valueOf(day).ordinal();			// 요일 enum을 이용하여 index값을 가져옴
		int row = period -9;							// 9교시부터 시작하기 때문에 9를 빼줌
		if(!timeTable[col][row].isValid()) {			// 해당 시간에 과목이 없을 경우
			if(row == 3 || row == 8) {					// 12시와 17시는 점심시간과 저녁시간으로 고정되어 있기 때문에 삭제 불가능
				return false;
			}
			timeTable[col][row] = new Course("----");		// 과목 객체 생성 - 이렇게 하면 쓰레기 발생(위와 같은 이유)
			timeTable[col][row].setValid(true);						// 값을 지웠기 때문에 입력 가능하다는 의미로 유효성을 true로 변경
			return true;
		}
		return false;
	}

	// 전체 시간표를 출력하는 메소드(보통 위에서 필요한 내용 출력후 시간표 상태를 확인하기 위해 마지막에 호출)
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String[] weeks = { "  ", "\tMONDAY", "\tTUESDAY", "\tWEDNESDAY", "THURSDAY", "FRIDAY"};
		for (int i = 0; i < timeTable[0].length + 1; i++) {
			for (int j = 0; j < timeTable.length+ 1; j++) {
				if (i == 0) {
					sb.append(String.format("%20s", weeks[j]));
				}
				else if(j == 0) {
					sb.append((i+8) + "\t\t");
				}
				else
					sb.append(String.format("%20s", timeTable[j-1][i-1].getName()));
					//sb.append(timeTable[j-1][i-1].getName() + "\t\t");

			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public String oneDaySchedule(String day) {
		int index = DAYS.valueOf(day).ordinal();			// 요일 enum을 이용하여 index값을 가져옴
		StringBuilder sb = new StringBuilder();
		String[] weeks = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
		sb.append(weeks[index] + "\n");
		for (int i = 0; i < timeTable[0].length; i++) {
			sb.append(timeTable[index][i].getName() + "\n");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public String subjectSchedule(String sub)
	{
		String str = "";
		for (int i = 0; i < timeTable.length; i++) {
			for (int j = 0; j < timeTable[0].length; j++) {
				if(timeTable[i][j].getName().equals(sub)) {
					str = "Subject : " + sub
							+ "\nDay : " + DAYS.values()[i]
							+ "\nLecture time : " + (j+9)
							+ "\nProfessor : " + timeTable[i][j].getProfessor()
							+ "\nRoom No : " + timeTable[i][j].getRoomNumber()
							+ "\n\n" + toString();
				}
			}
		}
		return str;
	}
	
	public Calendar setInputDate()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the year(YYYYMMDD) :");
		String inputDay = keyboard.next();

		String strYear = inputDay.substring(0, 4);
		int year = Integer.parseInt(strYear);

		String strMonth = inputDay.substring(4, 6);
		int month = Integer.parseInt(strMonth);

		String strDay = inputDay.substring(6, 8);
		int day = Integer.parseInt(strDay);

		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		return cal;
	}
}