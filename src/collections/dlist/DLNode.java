package collections.dlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DLNode {
    private String data;
    private DLNode llink;
    private DLNode rlink;

    public DLNode(String data) {
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }
}
