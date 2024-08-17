package jaemin.exceptions;

public class Method {

    public static void main(String[] args) {
        try {
            methodTest();
        } catch (Exception e) {
            System.out.println("main에서 예외 처리중....");
        }
    }

    public static void methodTest() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("methodTest에서 예외 처리중....");
            throw e;
        }
    }
}
