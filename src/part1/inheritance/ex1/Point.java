package part1.inheritance.ex1;

import lombok.*;

@Getter
@Setter
@ToString
// 좌표를 관리하는 클래스
public class Point {
    //(10, 20)
    private int x;
    private int y;
    
	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
    
    
}
