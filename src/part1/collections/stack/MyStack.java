package part1.collections.stack;

public interface MyStack<T> {
    boolean isEmpty();
    void push(T item);
    T pop();
    void delete();
    T peek();
}
