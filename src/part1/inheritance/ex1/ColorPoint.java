package part1.inheritance.ex1;

import lombok.*;

@Getter
@Setter
//@ToString
public class ColorPoint extends Point{
    
	private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "ColorPoint(" + super.toString() + ", color=" + color + ")";	
	}

	    
    
}
