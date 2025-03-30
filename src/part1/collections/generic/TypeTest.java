package part1.collections.generic;

import java.util.Vector;

public class TypeTest {
    public static void main(String[] args) {

        // 타입 변수
        int i = 10;
        double d = 11.2;
        Vector<String> sVector = new Vector<>();
        System.out.println(i);
        System.out.println(d);
        System.out.println(sVector.capacity());

        // 타입 추론
        var inti = 10;
        var doubled = 11.2;
        var vecString = new Vector<String>();
        System.out.println(inti);
        System.out.println(doubled);
        System.out.println(vecString.capacity());


    }
}
