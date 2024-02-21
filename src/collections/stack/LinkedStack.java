package collections.stack;

import java.util.Stack;

public class LinkedStack implements MyStack<String> {

    private StackNode<String> top = null;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(String item) {
        StackNode<String> newNode = new StackNode<>(item);

        if(top == null) {
            top = newNode;
        } else {
            newNode.setLink(top);
            top = newNode;
        }

    }

    @Override
    public String pop() {
        if(top == null){
            System.out.println("더이상 진행할 수 없습니다.");
            return null;
        }
        String data = top.getItem();
        top = top.getLink();
        return data;
    }

    @Override
    public void delete() {

    }

    @Override
    public String peek() {
        return null;
    }

    public void printStack() {
        System.out.print("Stack = [");

    }
}
