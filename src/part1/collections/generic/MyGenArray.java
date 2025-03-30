package part1.collections.generic;

import lombok.ToString;

@ToString
public class MyGenArray<T> {
    private T[] arr;

    // 생성자: 배열의 크기를 외부에서 받아 제네릭 배열 생성
    @SuppressWarnings("unchecked")
    public MyGenArray(int size) {
        arr = (T[]) new Object[size];  // 제네릭 배열 생성 (타입 캐스팅)
    }

    // 값 설정
    public void set(int index, T value) {
        arr[index] = value;
    }

    // 값 가져오기
    public T get(int index) {
        return arr[index];
    }

    // 배열 길이 반환
    public int length() {
        return arr.length;
    }
}
