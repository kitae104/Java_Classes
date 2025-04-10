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
    private String domain;
    private String address;
    
//    public StudentProfile(){
//        
//    }
//    public StudentProfile(int id, String name, String domain, String address){
//        this.id = id;
//        this.name = name;
//        this.domain = domain;
//        this.address = address;
//    }
//    public StudentProfile(String name, String domain, String address){
//        this.name = name;
//        this.domain = domain;
//        this.address = address;
//    }
    
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
			
			switch(i) {
				case 1:
					System.out.println("Add Profile");
                    System.out.println("Enter Name");
                    String name = sc.next();	// 이름 입력
                    System.out.println("Enter Domain");
                    String domain = sc.next(); // 도메인 입력
                    System.out.println("Enter Address");
                    String address = sc.next(); // 주소 입력
                    
                    StudentProfile sp = new StudentProfile(name, domain, address);
                    
                    
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
