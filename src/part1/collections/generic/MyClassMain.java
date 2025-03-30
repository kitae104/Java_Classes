package part1.collections.generic;

import part1.collections.vector.Family;

import java.util.Stack;
import java.util.Vector;

public class MyClassMain {
    public static void main(String[] args) {
    	    	    	
        MyClass<Integer> iMyClass = new MyClass<>();
        iMyClass.setValue(Integer.valueOf(10));
        System.out.println(iMyClass.getValue());

        MyClass<String> sMyClass = new MyClass<>();
        sMyClass.setValue("잼");
        System.out.println(sMyClass.getValue());

        Stack<String> stack = new Stack<>();
        stack.push("A");
    }
}
