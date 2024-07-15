package collections.generic;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class VectorGeneric {
    public static void main(String[] args) {
    	
        Vector<Integer> vec = new Vector<>();
        vec.add(1);
        vec.add(3);
        vec.add(2);

        Iterator<Integer> iterator = vec.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next.intValue());
        }

        System.out.println("====================================");

        Vector<String> vecStr = new Vector<>(3);
        vecStr.add("A");
        vecStr.add("B");
        vecStr.add("1");

        vecStr.add(1, "홍길동");
        System.out.println("capacity : " + vecStr.capacity());
        System.out.println("size : " + vecStr.size());

        for (String s : vecStr) {
            System.out.println(s);
        }

        System.out.println("====================================");
        // Stream
        vecStr.stream().forEach(System.out::println);
        System.out.println("====================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("찾고 싶은 단어를 입력하세요 : ");
        String findWord = scanner.next();

        if(vecStr.contains(findWord)){
            int index = vecStr.indexOf(findWord);
            System.out.println(findWord + "은 " + index + "번째 존재합니다.");
        } else {
            System.out.println(findWord + "은 존재하지 않습니다.");
        }

    }
}
