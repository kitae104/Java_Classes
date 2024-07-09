package thread.basic;

public class MainThread
{
	public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("메인 스레드 실행 중");

        for (int i = 0; i < 10; i++) {
            System.out.println("메인 스레드: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
