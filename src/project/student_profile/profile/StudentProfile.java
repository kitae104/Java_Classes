package project.student_profile.profile;

import java.util.Scanner;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

	private int id;
	private String name;
	private String dept;
	private String address;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 학생 프로필 포털 =====");
		ProfileAction action = new ProfileAction();

		while (true) {
			System.out.println(
				"\n###############################" +
				"\n 1. 프로파일 추가 " + 
				"\n 2. 프로파일 조회 " + 
				"\n 3. ID에 의한 프로파일 조회 " + 
				"\n 4. 프로파일 삭제 " + 
				"\n 5. 프로파일 수정 " + 
				"\n 6. 종료" +
				"\n###############################\n"
			);
			System.out.print("원하는 메뉴를 선택하세요 : ");
			int i = sc.nextInt(); // 사용자 입력
			sc.nextLine();
			switch (i) {
			case 1:
				System.out.println("프로파일 추가");
				System.out.print("이름 입력 : ");
				String name = sc.nextLine(); // 이름 입력
				System.out.print("학과 입력 : ");
				String dept = sc.nextLine(); // 도메인 입력
				System.out.print("주소 입력 : ");
				String address = sc.nextLine(); // 주소 입력
//                    sc.next(); // 개행 문자 제거

				StudentProfile sp = StudentProfile.builder().name(name).dept(dept).address(address).build();


				boolean valid = action.add(sp); // DB에 추가

				if (valid) {
					System.out.println("=== 프로파일 추가 성공");
				} else {
					System.out.println("=== 프로파일 추가 실패");
				}

				break;
			case 2:
				System.out.println("전체 프로파일 조회\n");
				action.display();
				break;
			case 3:
				System.out.println("ID에 의한 프로파일 조회");
				System.out.print("ID 입력 : ");
				int id = sc.nextInt(); // ID 입력
				boolean check = action.displayById(id);
				if(check == false) {
					System.out.println("해당 ID의 프로파일이 없습니다.");
				} 
				break;
			case 4:
				System.out.println("프로파일 삭제");
				System.out.print("삭제할 ID 입력 : ");
				int deleteId = sc.nextInt(); // 삭제할 ID 입력
				boolean deleteCheck = action.deleteById(deleteId); // DB에서 삭제
				if (deleteCheck) {
					System.out.println("프로파일 삭제 성공");
				} else {
					System.out.println("프로파일 삭제 실패");
				}
				break;
			case 5:
				System.out.println("프로파일 수정");
				System.out.print("수정할 ID 입력 : ");
				int updateId = sc.nextInt(); // 수정할 ID 입력
				sc.nextLine();
				System.out.println("1. 이름 수정, 2. 학과 수정, 3. 주소 수정");
				System.out.print("수정할 항목 선택 : ");
				int updateOption = sc.nextInt(); // 수정할 항목 선택
				sc.nextLine();
				boolean result = false;
				switch (updateOption) {
					case 1:
						System.out.print("수정할 이름 입력 : ");
						String updateName = sc.nextLine(); // 수정할 이름 입력
						result = action.updateName(updateId, updateName); // DB에서 이름 수정
						if (result) {
							System.out.println("이름 수정 성공");
						} else {
							System.out.println("이름 수정 실패");
						}
						break;
					case 2:
						System.out.print("수정할 학과 입력 : ");
						String updateDept = sc.nextLine(); // 수정할 학과 입력
						result = action.updateDept(updateId, updateDept); // DB에서 학과 수정
						if (result) {
							System.out.println("학과 수정 성공");
						} else {
							System.out.println("학과 수정 실패");
						}
						break;
					case 3:
						System.out.print("수정할 주소 입력 : ");
						String updateAddress = sc.nextLine(); // 수정할 주소 입력
						result = action.updateAddress(updateId, updateAddress); // DB에서 주소 수정
						if (result) {
							System.out.println("주소 수정 성공");
						} else {
							System.out.println("주소 수정 실패");
						}
						break;
					default:
						System.out.println("잘못된 입력입니다. 다시 시도하세요.");
						break;						
					
				}
				
				break;
			case 6:
				System.out.println("종료. 다음에 뵙겠습니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도하세요.");
			}
		}
	}

}
