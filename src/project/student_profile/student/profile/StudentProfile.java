package project.student_profile.student.profile;

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
		
		while(true) {
			System.out.println(
				"\n 1. 프로파일 추가 "+
				"\n 2. 프로파일 조회 "+
				"\n 3. ID에 의한 프로파일 조회 "+
				"\n 4. 프로파일 삭제 "+
				"\n 5. 프로파일 수정 "+
				"\n 6. 종료 \n"
			);			
			
			int i = sc.nextInt(); // 사용자 입력
			sc.nextLine(); 
			switch(i) {
				case 1:
					System.out.println("프로파일 추가");
                    System.out.print("이름 입력 : ");
                    String name = sc.nextLine();	// 이름 입력
                    System.out.print("학과 입력 : ");
                    String dept = sc.nextLine(); // 도메인 입력
                    System.out.print("주소 입력 : ");
                    String address = sc.nextLine(); // 주소 입력                    
//                    sc.next(); // 개행 문자 제거
                    
                    
                    StudentProfile sp = StudentProfile.builder()
                    		.name(name)
                    		.dept(dept)
                    		.address(address)
                    		.build();
                    
                    AddAction addAction = new AddAction();
                    
                    boolean valid = addAction.add(sp); // DB에 추가
                    
                    if(valid) {
						System.out.println("=== 프로파일 추가 성공");
					} else {
						System.out.println("=== 프로파일 추가 실패");
					}
                    
					break;
				case 2:
					System.out.println("Show");
					break;
				case 3:
					System.out.println("Display");
					break;
				case 4:
					System.out.println("Delete");
					break;
				case 5:
					System.out.println("Update");
					break;
				case 6:
					System.out.println("Exit");
					System.exit(0);
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 시도하세요.");
			}
		}
	}
    
}
