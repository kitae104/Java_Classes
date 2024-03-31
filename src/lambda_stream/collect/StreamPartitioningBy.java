package lambda_stream.collect;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 2분할 하여 그룹화
public class StreamPartitioningBy {
    public static void main(String[] args) {
        Student[] studentArr = {
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };

        System.out.println("1. 단순분할(성별로 분할)====================");
        System.out.println(" 남학생 리스트 : ");
        Map<Boolean, List<Student>> studentByGender = Stream.of(studentArr)
                .collect(Collectors.partitioningBy(Student::isMale));       // partitioningBy() : 분할

        List<Student> maleStudent = studentByGender.get(true);
        List<Student> femaleStudent = studentByGender.get(false);

        for(Student s : maleStudent) {
            System.out.println(s);
        }

        System.out.println("================================================================");
        System.out.println(" 여학생 리스트 : ");
        femaleStudent.forEach(System.out::println);

        System.out.println("2. 단순분할 + 통계(성별 학생수)====================");
        Map<Boolean, Long> studentNumByGender = Stream.of(studentArr)
                .collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));     // partitioningBy() : 분할 후 counting()

        //System.out.println(STR."남학생 수 : \{studentNumByGender.get(true)}");
        System.out.println("여학생 수 : " + studentNumByGender.get(false));

        System.out.println("3. 단순분할 + 통계(성별 1등 추출)====================");
        Map<Boolean, Optional<Student>> topScoreByGender = Stream.of(studentArr)
                .collect(Collectors.partitioningBy(Student::isMale,                             // partitioningBy() : 분할
                        Collectors.maxBy(Comparator.comparingInt(Student::getScore))));         // maxBy() : 최대값  // comparingInt() : 비교

        System.out.println("남학생 1등 : " + topScoreByGender.get(true).get());
        System.out.println("여학생 1등 : " + topScoreByGender.get(false).get());

        System.out.println("4. 다중분할 (성별 불합격자, 100 점 이하)====================");
        Map<Boolean, Map<Boolean, List<Student>>> failedStudentByGender = Stream.of(studentArr)
                .collect(Collectors.partitioningBy(Student::isMale,                         // partitioningBy() : 분할
                        Collectors.partitioningBy(s -> s.getScore() <= 100)));              // partitioningBy() : 분할

        List<Student> failedMaleStudent = failedStudentByGender.get(true).get(true);
        failedMaleStudent.forEach(System.out::println);
        System.out.println("================================================================");
        List<Student> failedFemaleStudent = failedStudentByGender.get(false).get(true);
        failedFemaleStudent.forEach(System.out::println);
    }
}
