package lambda_stream.collect;
public class Student {
    String name;        // 이름
    boolean isMale;     // 성별
    int grade;          // 학년
    int classNum;       // 반
    int score;          // 점수

    public Student(String name, boolean isMale, int grade, int classNum, int score) {
        this.name = name;
        this.isMale = isMale;
        this.grade = grade;
        this.classNum = classNum;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale ? "남":"여" +
                ", grade=" + grade +
                ", classNum=" + classNum +
                ", score=" + score +
                '}';
    }

}
