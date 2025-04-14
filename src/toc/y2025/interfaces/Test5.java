package toc.y2025.interfaces;

abstract class Employee {
    String name;
    int baseSalary;

    Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract int getSalary();

    void printInfo() {
        System.out.println("이름: " + name + ", 월급: " + getSalary() + "만원");
    }
}

class Manager extends Employee {
    Manager(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    int getSalary() {
        return baseSalary + 100;
    }
}

class Developer extends Employee {
    Developer(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    int getSalary() {
        return (int)(baseSalary * 1.1);  // 10% 인센티브
    }
}

public class Test5 {
    public static void main(String[] args) {
        Employee[] emps = {
            new Manager("김부장", 300),
            new Developer("이개발", 300)
        };

        for (Employee e : emps) {
            e.printInfo();  // 동적 바인딩
        }
    }
}
