package part1.collections.hashmap;

import java.util.HashMap;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Integer b = map.get("B");
        System.out.println(b);
        System.out.println(map);

        Set<String> keyset = map.keySet();  // 지역변수 만들기 사용 
        for (String key : keyset) {
            System.out.println(key + " : " + map.get(key));
        }


        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "A");
        map2.put(2, "B");
        map2.put(3, "C");

        map2.remove(1);
        System.out.println(map2);

    }
}
