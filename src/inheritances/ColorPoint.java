package inheritances;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColorPoint extends Point{

    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void printColorInfo(){
        this.printInfo();
        System.out.println("-" +color);
    }
}
