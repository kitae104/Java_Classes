package thread.basic;

public class MyThread extends Thread
{
	@Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("스레드 실행 중: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
