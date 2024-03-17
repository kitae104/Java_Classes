package inheritances.basic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    //(10, 20)
    private int x;
    private int y;

    public void printInfo() {
        System.out.print("Point(" + x + ", " + y + ")");
    }
}
