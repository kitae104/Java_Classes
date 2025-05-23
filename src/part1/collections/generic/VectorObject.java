package part1.collections.generic;

import java.util.Iterator;
import java.util.Vector;

public class VectorObject {
    public static void main(String[] args) {

    	String[] sArr = {"A", "B"}; 
    	
        Vector<Object> vec = new Vector();
        vec.add(1);
        vec.add("A");
        vec.add(2);

        Iterator iterator = vec.iterator();
        while(iterator.hasNext()){
            Integer next = (Integer)iterator.next();
            System.out.println(next.intValue());
        }
    }
}
