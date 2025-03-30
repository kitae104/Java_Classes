package part1.collections.list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode {
    String day;
    ListNode link;

    public ListNode(String day) {
        this.day = day;
        this.link = null;
    }
}
