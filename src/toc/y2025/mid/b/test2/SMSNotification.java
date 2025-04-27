package toc.y2025.mid.b.test2;

public class SMSNotification extends Notification {

    public SMSNotification(String recipient, int messageLength) {
        super(recipient, messageLength);
    }

    @Override
    public void send() {
        System.out.println("문자로 " + recipient + "에게 알림을 전송합니다.");
    }

    @Override
    public String getType() {
        return "문자 알림";
    }

    @Override
    public int getCost() {
        return messageLength * 5;
    }
}