package jaemin.array;

public class Array2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] bbb;

        bbb = arr;

        bbb[0] = 100;

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

        int[] kor = new int[10];
        kor[0] = 100;
    }
}
