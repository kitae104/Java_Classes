package collections.generic;

import collections.vector.Family;

import java.util.Stack;

public class MyClassMain {
    public static void main(String[] args) {
        MyClass<Integer> iMyClass = new MyClass<>();
        iMyClass.setValue(10);
        System.out.println(iMyClass.getValue());

        MyClass<String> sMyClass = new MyClass<>();
        sMyClass.setValue("잼");
        System.out.println(sMyClass.getValue());

        Stack<String> stack = new Stack<>();
        stack.push("A");
    }
}
