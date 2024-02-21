package collections.stack;

import lombok.Getter;
import lombok.Setter;

public class StackNode<T> {
    private T item;
    private StackNode<T> link;

    public StackNode(T item) {
        this.item = item;
        this.link = null;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public StackNode<T> getLink() {
        return link;
    }

    public void setLink(StackNode<T> link) {
        this.link = link;
    }
}
