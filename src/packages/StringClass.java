package packages;

public class StringClass {
    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = new String("Java");
        String s3 = "Java";
        String s4 = "Java";

        if(s1.equals(s2)){
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
        if(s1.equals(s3)){
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
        if(s3 == s4){
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
    }
}
