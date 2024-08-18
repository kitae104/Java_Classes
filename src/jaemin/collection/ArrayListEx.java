package jaemin.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("문자열을 입력하세요(종료를 원하면 exit).");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
            list.add(input);
        }

        list.forEach(System.out::println);

        String maxWord = "";
        int maxLength = 0;
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            int wordLength = word.length();
            if(wordLength > maxLength){
                maxWord = word;
                maxLength = wordLength;
            }
        }
        System.out.println("가장 긴 단어는 " + maxWord + "입니다.");

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            System.out.println(s);
        }

        iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            System.out.println(s);
        }

        sc.close();

    }
}
