package jaemin.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Map<K, V> {

    private final ArrayList<LinkedList<Pair<K, V>>> a;


    public HashMap(int capacity) {

        //makes a new ArrayList long as capacity and initialize all the entries with a new LinkedList//your code
        a = new ArrayList<>(capacity);      // 초기에 capacity만큼의 크기로 ArrayList를 생성
        for (int i = 0; i < capacity; i++) {    // capacity만큼의 크기로 LinkedList를 생성
            a.add(new LinkedList<>());          // ArrayList에 이후에 Pair<K,V>를 관리하기 위한 LinkedList를 추가
        }
    }

    private int indexOf(K key) {
        //returns the index of key in the HashTable using .hashCode function REMEMBER return index should be smaller than HashTable Size//your code
        // Map에서 키의 위치를 찾기 위한 함수(해시함수)
        int hashCode = key.hashCode();                  // key의 hashCode를 구함
        int index = hashCode % a.size();                // hashCode를 size로 나눈 나머지를 index로 사용
        return index >= 0 ? index : index + a.size();   // index가 음수일 경우 size를 더해줌
    }


    public void put(K key, V value) {

        //puts a new Pair key,value in the right linked list index// your code
        int index = indexOf(key);                       // key의 위치를 찾음
        LinkedList<Pair<K, V>> pairList = a.get(index);   // key의 위치에 해당하는 LinkedList를 가져옴
        if (pairList == null) {
            pairList = new LinkedList<>();
            a.set(index, pairList);       //  ArrayList a에 LinkedList가 없을 경우 새로 생성
        }

        // HashMap은 키가 기존에 있으면 내용만 업데이트하고, 없으면 추가하는 방식
        for (Pair<K, V> pair : pairList) {
            if (pair.first == key) {        // Pair에 first와 second가 public으로 선언되어 있어서 직접 접근
                pair.second = value;        // key가 이미 존재할 경우 value를 업데이트하고 return
                return;
            }
        }

        pairList.addFirst(new Pair<>(key, value));  // key가 존재하지 않을 경우 LinkedList에 추가
    }


    public V get(K key) throws KeyNotFoundException {

        //returns the value of Type V associated with the Key // your code
        int index = indexOf(key);                       // key의 위치를 찾음
        LinkedList<Pair<K, V>> pairList = a.get(index);   // key의 위치에 해당하는 LinkedList를 가져옴
        if (pairList != null) {
            for (Pair<K, V> pair : pairList) {
                if (pair.first == key) {                // key가 존재할 경우 value를 return
                    return pair.second;
                }
            }
        }
        throw new KeyNotFoundException("HashMap.get()");    // key가 존재하지 않을 경우 예외처리
    }

    public int size() {

        //returns the size of the HashTable // your code
        int count = 0;
        for (LinkedList<Pair<K, V>> pairList : a) {
            count += pairList.size();
        }
        return count;
    }

    public void remove(K key) {
        //removes the element with key key // your code
        int index = indexOf(key);
        LinkedList<Pair<K, V>> pairList = a.get(index);
        if (pairList == null) {
            return; // 키를 못찾은 경우
        }

        for (Iterator<Pair<K, V>> iter = pairList.iterator(); iter.hasNext();) {
            Pair<K, V> pair = iter.next();
            if (pair.first == key) {
                iter.remove();
                return;
            }
        }
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {

        return new Iterator<Pair<K, V>>() {
            private int i = 0, j = 0;

            @Override
            public boolean hasNext() {

                //returns whether the Linked List has a next element //your code
                while (i < a.size() && a.get(i).isEmpty()) {
                    i++;
                }
                return i < a.size() && j < a.get(i).size();
            }

            @Override
            public Pair<K, V> next() {

                //returns the next element of the linked List // your code
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Pair<K, V> current = a.get(i).get(j);
                j++;
                if (j == a.get(i).size()) {
                    i++;
                    j = 0;
                }
                return current;
            }
        };
    }

}
