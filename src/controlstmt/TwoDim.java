package controlstmt;

public class TwoDim {
    public static void main(String[] args) {
        int arr[][] = new int[10][10];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = i * j;
            }
        }

L1:     for (int i = 0; i < 10; i++) {                  // 행(row)

            for (int j = 0; j < 10; j++) {              // 열(column)

                if(i == 5){
                    break L1;
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
