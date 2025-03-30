package part1.collections.generic;

public class MyGenArrayMain {

	public static void main(String[] args) {
		// 문자열 배열 생성
        MyGenArray<String> stringArray = new MyGenArray<>(3);
        stringArray.set(0, "Apple");
        stringArray.set(1, "Banana");
        stringArray.set(2, "Cherry");
        System.out.println(stringArray);

        System.out.println("문자열 배열 출력:");
        for (int i = 0; i < stringArray.length(); i++) {
            System.out.println(stringArray.get(i));
        }

        // 정수 배열 생성
        MyGenArray<Integer> intArray = new MyGenArray<>(4);
        intArray.set(0, 10);
        intArray.set(1, 20);
        intArray.set(2, 30);
        intArray.set(3, 40);
        System.out.println(intArray);

        System.out.println("\n정수 배열 출력:");
        for (int i = 0; i < intArray.length(); i++) {
            System.out.println(intArray.get(i));
        }
	}

}
