package jaemin.linkedlist;
public class MainNode {

    public static void main(String[] args) {
        Node start;
        Node a = new Node("AAA");
        Node b = new Node("BBB");
        Node c = new Node("CCC");
        Node d = new Node("DDD");
        Node e = new Node("EEE");

        start = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(start.data);
        System.out.println(start.next.data);
        System.out.println(start.next.next.data);

        while(start != null){
            System.out.println(start.data);
            start = start.next;
        }
    }




}
