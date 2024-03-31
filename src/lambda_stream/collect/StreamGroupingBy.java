package lambda_stream.collect;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림을 n 분할하여 그룹화
public class StreamGroupingBy {
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

        System.out.println("1. 단순그룹화(반별로 그룹화)====================");
        Map<Integer, List<Student>> studentByClassNum = Stream.of(studentArr)
                .collect(Collectors.groupingBy(Student::getClassNum));       // groupingBy() : 그룹화

        // Map에서 정보를 가져와 출력
        for (List<Student> ban : studentByClassNum.values()) {
            for (Student s : ban) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println("================================================================");
        // Map에서 정보를 스트림 형태로 출력
        studentByClassNum.forEach((ban, students) -> {
            System.out.println("반 : " + ban);
            students.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("2. 단순그룹화(성적별로 그룹화)====================");
        Map<Level, List<Student>> studentByLevel = Stream.of(studentArr)
                .collect(Collectors.groupingBy(s -> {
                    if(s.getScore() >= 200) return Level.HIGH;
                    else if(s.getScore() >= 100) return Level.MID;
                    else return Level.LOW;
                }));

        // TreeSet을 이용하여 Map에서 정보를 가져와 출력
        TreeSet<Level> keySet = new TreeSet<>(studentByLevel.keySet());
        for(Level key : keySet) {
            //System.out.println(STR."[\{key}]");

            for(Student s : studentByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println("================================================================");
        // Map에서 정보를 가져와 출력
        for (Level level : studentByLevel.keySet()) {
            System.out.println("[" + level + "]");
            //System.out.println(STR."[\{level}]");

            for (Student s : studentByLevel.get(level)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.println("3. 단순그룹화 + 통계(성적별 학생 수)====================");
        Map<Level, Long> studentNumByLevel = Stream.of(studentArr)
                .collect(Collectors.groupingBy(s -> {
                    if(s.getScore() >= 200) return Level.HIGH;
                    else if(s.getScore() >= 100) return Level.MID;
                    else return Level.LOW;
                }, Collectors.counting()));     // groupingBy() : 그룹화 후 counting()

        // Map에서 정보를 가져와 출력
        for(Level key : studentNumByLevel.keySet()){
            System.out.println("[" + key + "] : " + studentNumByLevel.get(key) + "명");
        }

        System.out.println("4. 다중그룹화(학년별, 반별)====================");
        Map<Integer, Map<Integer, List<Student>>> studentByGradeAndClassNum = Stream.of(studentArr)
                .collect(Collectors.groupingBy(Student::getGrade,       // groupingBy() : 학년별 그룹화
                        Collectors.groupingBy(Student::getClassNum))); // groupingBy() : 반별 그룹화

        // Map에서 keySet을 이용하여 정보를 가져와 출력
        for(int grade : studentByGradeAndClassNum.keySet()){
            System.out.println("학년 : " + grade);
            for(int classNum : studentByGradeAndClassNum.get(grade).keySet()){
                System.out.println("  반 : " + classNum);
                for(Student s : studentByGradeAndClassNum.get(grade).get(classNum)){
                    System.out.println(s);
                }
            }
        }

        // Map에서 values()를 이용하여 정보를 가져와 출력
        for(Map<Integer, List<Student>> grade : studentByGradeAndClassNum.values()){
            for(List<Student> ban : grade.values()){
                for(Student s : ban){
                    System.out.println(s);
                }
                System.out.println();
            }
        }

        System.out.println("5. 다중그룹화 + 통계(학년별, 반별 1등)====================");
        Map<Integer, Map<Integer, Student>> topStudentByGradeAndClassNum = Stream.of(studentArr)
                .collect(Collectors.groupingBy(Student::getGrade,       // groupingBy() : 학년별 그룹화
                        Collectors.groupingBy(Student::getClassNum,    // groupingBy() : 반별 그룹화
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student::getScore)), // maxBy() : 최대값
                                        Optional::get))));     // collectingAndThen() : 최대값을 Optional에서 Student로 변환

        for(Map<Integer, Student> grade : topStudentByGradeAndClassNum.values()){
            for(Student s : grade.values()){
                System.out.println(s);
            }
        }

        System.out.println("6. 다중그룹화 + 통계(학년별, 반별 성적 그룹)====================");
        Map<String, Set<Level>> studentByScoreGroup = Stream.of(studentArr)
                .collect(Collectors.groupingBy(s -> s.getGrade() + " - " + s.getClassNum(), // groupingBy() : 학년별, 반별 그룹화
                        Collectors.mapping(s -> {
                            if(s.getScore() >= 200) return Level.HIGH;
                            else if(s.getScore() >= 100) return Level.MID;
                            else return Level.LOW;
                        }, Collectors.toSet())));     // mapping() : 변환 후 toSet()

        Set<String> keySet2 = studentByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("[" + key + "]" + studentByScoreGroup.get(key));
        }
    }
}
