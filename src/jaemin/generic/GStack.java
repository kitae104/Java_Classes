package jaemin.generic;

public class GStack<T> {
    private int top;
    private Object[] stack;

    public GStack() {
        top = 0;
        stack = new Object[10];
    }

    public void push(T item) {
        if(top == 10){
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        stack[top++] = item;
    }

    public T pop() {
        if(top == 0){
            System.out.println("스택이 비어있습니다.");
            return null;
        }
        return (T)stack[--top];
    }


    public int size() {
        return top;
    }
}
