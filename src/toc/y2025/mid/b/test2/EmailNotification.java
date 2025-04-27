package toc.y2025.mid.b.test2;

public class EmailNotification extends Notification {

    public EmailNotification(String recipient, int messageLength) {
        super(recipient, messageLength);
    }

    @Override
    public void send() {
        System.out.println("이메일로 " + recipient + "에게 알림을 전송합니다.");
    }

    @Override
    public String getType() {
        return "이메일 알림";
    }

    @Override
    public int getCost() {
        return 100;
    }
}