package jaemin.map;

import jaemin.map.Map.KeyNotFoundException;

import java.awt.*;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws KeyNotFoundException {
        HashMap<String,Object> b = new HashMap<String, Object> (5);
        HashMap<Integer, String> a =new HashMap<Integer, String>(5);
        
        //use this space to check your functions with a and b//
        // b에 대한 테스트
        b.put("a", new Point(1, 2));
        b.put("b", 2);
        b.put("c",  new Point(10, 20));
        b.put("d", 4);
        b.put("e",  new Point(100, 200));

        int bSize = b.size();
        System.out.println("b size: " + bSize);

        Point a1 = (Point) b.get("a");
        System.out.println("a1: " + a1);

        b.remove("a");
        bSize = b.size();
        System.out.println("b size: " + bSize);

        Iterator<Pair<String, Object>> iterator = b.iterator();
        while (iterator.hasNext()) {
            Pair<String, Object> pair = iterator.next();
            System.out.println(pair.first + " : " + pair.second);   // 맵이라 순서는 임의로 출력됨
        }

        // a에 대한 테스트
        a.put(1, "aa");
        a.put(2, "bb");
        a.put(3, "cc");
        a.put(4, "dd");
        a.put(5, "ee");
        a.put(6, "ff");
        a.put(7, "gg");

        int aSize = a.size();
        System.out.println("a size: " + aSize);

        String a2 = a.get(1);
        System.out.println("a2: " + a2);

        a.remove(4);
        aSize = a.size();
        System.out.println("a size: " + aSize);

        Iterator<Pair<Integer, String>> iterator2 = a.iterator();
        while (iterator2.hasNext()) {
            Pair<Integer, String> pair = iterator2.next();
            System.out.println(pair.first + " : " + pair.second);   // 맵이라 순서는 임의로 출력됨
        }

    }

}