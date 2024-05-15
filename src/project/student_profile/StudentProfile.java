package project.student_profile;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    private int id;
    private String name;
    private String domain;
    private String address;

    public static void main(String[] args) {
        System.out.println("da");
    }
}
