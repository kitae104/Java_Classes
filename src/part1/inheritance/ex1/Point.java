package part1.inheritance.ex1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// 좌표를 관리하는 클래스
public class Point {
    //(10, 20)
    private int x;
    private int y;

    public void printInfo() {
        System.out.print("Point(" + x + ", " + y + ")");
    }
}
