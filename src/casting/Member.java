package casting;

public class Member extends Saram{

    String grade;
    String department;

    public Member(String name) {
        super(name);
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
