package list.simplelist;

public class SimpleNodeMain {
    public static void main(String[] args) {
        Node week = null;
        Node mon = new Node("월", null);
        Node fri = new Node("금", null);
        Node sun = new Node("일", null);

        week = mon;
        mon.link = fri;
        fri.link = sun;

        // 월
        System.out.println(week.getData());
        System.out.println(mon.data);

        // 금
        System.out.println(week.link.data);
        System.out.println(mon.link.data);
        System.out.println(fri.data);

        // 일
        System.out.println(week.link.link.data);
        System.out.println(mon.link.link.data);
        System.out.println(fri.link.data);
        System.out.println(sun.data);

        // week
        // while




    }
}
