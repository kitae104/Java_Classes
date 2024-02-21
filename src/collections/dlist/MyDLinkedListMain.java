package collections.dlist;

import collections.list.ListNode;
import collections.list.MyLinkedList;

public class MyDLinkedListMain {
    public static void main(String[] args) {
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        MyDLinkedList week = new MyDLinkedList();
        week.insertNode("월");
        week.printDList();
    }

//    MyLinkedList list = new MyLinkedList();
//        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
//        list.insertLastNode("월");
//        list.insertLastNode("수");
//        list.insertLastNode("일");
//        list.printList();
//
//        System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기 ");
//    ListNode pre = list.searchNode("수");
//
//
//        if(pre == null){
//        System.out.println("검색 실패 : 찾는 데이터가 없습니다");
//    } else {
//        list.insertMiddleNode(pre, "금");
//        list.printList();
//    }
//
//        System.out.println("(3) 첫번째 위치에 '시작' 이라는 단어를 삽입하세요.");
//        list.insertFirstNode("시작");
//        list.printList();
//
//        System.out.println("(4) 수 노드를 삭제하세요.");
//    ListNode deleteNode = list.searchNode("수");
//        list.deleteNode(deleteNode);
}
