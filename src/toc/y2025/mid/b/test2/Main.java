package toc.y2025.mid.b.test2;

public class Main {

	public static void main(String[] args) {
		Notification[] notifications = new Notification[] {
	            new Notification("홍길동", 20),
	            new EmailNotification("이몽룡", 50),
	            new SMSNotification("성춘향", 40)
	        };

	        for (Notification n : notifications) {
	            System.out.println("알림 타입: " + n.getType());
	            n.send();
	            System.out.println("전송 비용: " + n.getCost() + "원");
	            System.out.println();
	        }

	}

}
