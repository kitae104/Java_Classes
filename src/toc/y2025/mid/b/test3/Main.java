package toc.y2025.mid.b.test3;

import java.util.ArrayList;

import toc.y2025.mid.b.test2.EmailNotification;
import toc.y2025.mid.b.test2.Notification;
import toc.y2025.mid.b.test2.SMSNotification;

public class Main {

	public static void main(String[] args) {
		ArrayList<Notification> notifications = new ArrayList<>();

        notifications.add(new Notification("홍길동", 20));
        notifications.add(new EmailNotification("이몽룡", 50));
        notifications.add(new SMSNotification("성춘향", 40));

        for (Notification n : notifications) {
            System.out.println("알림 타입: " + n.getType());
            n.send();
            System.out.println("전송 비용: " + n.getCost() + "원");
            System.out.println();
        }

	}

}
