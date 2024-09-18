package jaemin.generic;

import java.util.Stack;

public class GStackTest {
    public static void main(String[] args) {
        GStack<String> stack = new GStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        int size = stack.size();
        System.out.println(size);  //4

        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(100);
        stack2.push(200);
        stack2.push(300);

        int size2 = stack2.size();

        for (int i = 0; i < size2; i++) {
            System.out.println(stack2.pop());
        }

    }
}
