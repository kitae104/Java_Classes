package jaemin.oop.timetable;

import java.util.Calendar;
import java.util.Scanner;

public class HYTimeTableApp {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String[] weeks = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		Calendar cal = Calendar.getInstance();
		HYTimeTable timeTable = new HYTimeTable();
		int enter, period;
		String name, day, tutorName, roomName, sub, str;
		boolean check;
		boolean when = true;
		do {
			/* Write your code:
			 * Print time table 
			 * Print menu
			 * */
			System.out.println("===============Main Menu=================");
			System.out.println("(1) Add a class to my time table");
			System.out.println("(2) Delete a class from my time table");
			System.out.println("(3) View a class at specific time");
			System.out.println("(4) View schedule of specific class");
			System.out.println("(5) TimeTable corresponding to input date");
			System.out.println("(6) Exit the program");
			System.out.println("===============Main Menu=================");


			enter = keyboard.nextInt();
			switch (enter) {
			case 1: {
				System.out.println("Please enter the day to add the class");
				day = keyboard.next();
				day = day.toUpperCase();		// MONDAY
				System.out.println("Please enter the time to add the class");
				period = keyboard.nextInt();    // 16
				System.out.println("Please enter the name of the class");
				name = keyboard.next();			// Calculus
				System.out.println("Please enter the name of the tutor");
				tutorName = keyboard.next();     //name should have no space
				System.out.println("Please enter the name of the room ");
				roomName = keyboard.next();		// B303

				check = timeTable.setSchedule(day, period, name, tutorName, roomName);		// 추가 부분
				
				if (check == true) {
					System.out.println("Class successfully added");                            // 추가 부분(출력)
					System.out.println(timeTable.toString());
				}
				else
					{System.out.println("Class was NOT successfully added ");               // 추가 부분(출력)
					System.out.println("Please select a valid time for the lesson");}		// 추가 부분
				break;

			}
			case 2: {
				System.out.println("Please enter the day of the class to delete");
				day = keyboard.next();
				day = day.toUpperCase();
				System.out.println("Please enter the time of the class to delete");
				period = keyboard.nextInt();
				
				check = timeTable.deleteSchedule(day, period);								 /* Write your code*/;
				
				if (check == true) {
					System.out.println("Class successfully deleted");
					System.out.println(timeTable.toString());
				}
				else{
					System.out.println("Class was NOT deleted ");
					System.out.println("That time-slot is either not available or already empty.");
					System.out.println(timeTable.toString());
				}
				break;
				
			}
			case 3: {
				System.out.println("Please enter the day of the class");
				day = keyboard.next();
				day = day.toUpperCase();
				System.out.println("Please enter the time of the class");
				period = keyboard.nextInt();
				System.out.println(timeTable.getSchedule(day, period));

				break;

			}
			case 4: {
				System.out.println("Please enter the class name");
				sub = keyboard.next();					// Calculus
				str = timeTable.subjectSchedule(sub);	//
				
				if (str.isEmpty()) {
					System.out.println("There are no class");
					break;
				} else {
					System.out.println(str);
				}
				break;
			}
			case 5: {
			
				cal = timeTable.setInputDate();

				if (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7) {	// 일요일이나 토요일 이라면
					System.out.println("There is no schedule");
					break;
				} else {
					System.out.println();
					System.out.println(timeTable.oneDaySchedule(weeks[cal.get(Calendar.DAY_OF_WEEK) - 1]));
					System.out.println(timeTable.toString());
				}

				break;

			}
			case 6: {
				when = false;
				break;
			}
			default:
				System.out.println("Try again");
			}
		} while (when);

	}

}