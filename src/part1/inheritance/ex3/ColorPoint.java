package part1.inheritance.ex3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorPoint{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
