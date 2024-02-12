package collections.circlelist;

public class MyCicleListMain {
    public static void main(String[] args) {
        MyCircleList cl = new MyCircleList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        cl.insertLastNode("월");
        cl.printList();
        cl.insertLastNode("수");
        cl.printList();
        cl.insertLastNode("일");
        cl.printList();
    }
}
