package collections.iter;

import java.util.Iterator;
import java.util.Vector;

public class IterEx {
    public static void main(String[] args) {
        Vector<Integer> iVector = new Vector<>();
        iVector.add(10);
        iVector.add(20);
        iVector.add(50);
        iVector.add(11);

        for (Integer i : iVector) {
            System.out.println(i);
        }

        int sum = 0;
        Iterator<Integer> iterator = iVector.iterator();

        while(iterator.hasNext()){
            Integer i = iterator.next();
            sum += i;
        }
        System.out.println("sum : " + sum);

        System.out.println(iterator.next());

    }
}
