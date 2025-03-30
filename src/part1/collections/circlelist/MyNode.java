package part1.collections.circlelist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyNode {
    private String data;
    private MyNode link;

    public MyNode(String data) {
        this.data = data;
        this.link = null;
    }
}
