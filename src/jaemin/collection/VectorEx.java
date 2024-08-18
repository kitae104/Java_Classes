package jaemin.collection;

import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();
        v1.add("홍길동");
        v1.add("이순신");
        v1.add("유관순");
        v1.add(1, "강감찬");
        v1.remove(v1.indexOf("유관순"));

        System.out.println(v1.size());
        String s1 = v1.lastElement();
        System.out.println(s1);

        for (String s : v1) {
            System.out.println(s);
        }
    }
}
