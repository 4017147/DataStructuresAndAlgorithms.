package com.marker.datastructure.linkedlist;

import com.marker.datastructure.linkedlist.SingleLinkedList.Node;

public class Client {

  public static void main(String[] args) {
    test1();
//    test2();
  }

  public static void test2() {

    CycleLinkedList list = new CycleLinkedList();
    list.add(2);
    list.add(11);
    list.add(5);
    list.add(3);
    list.add(4);
//    System.out.println(list.length());
//    list.printLink();
    list.delete(0);
//    list.printLink();
    list.delete(3);
//    list.printLink();
//    System.out.println(list.length());
   
  }

  public static void test1() {
    SingleLinkedList linkedList = new SingleLinkedList();
    linkedList.add(3);
    linkedList.add(6);
    linkedList.add(7);
    linkedList.add(7);
    linkedList.add(9);
    linkedList.add(54);
    linkedList.add(99);
    linkedList.add(7);
    linkedList.add(11);
    linkedList.add(11);
    linkedList.add(10);
    linkedList.add(88);
    linkedList.add(88);
    linkedList.printLink();
    linkedList.delete(2);
    linkedList.printLink();
    linkedList.delete(3);
    linkedList.printLink();
//    linkedList.sort();
    System.out.println("====");
    linkedList.sort2();
    linkedList.printLink();
//    linkedList.distinct();
    System.out.println("====");
    linkedList.distinct2();
    linkedList.printLink();
    linkedList.reserveLink();
    linkedList.printLink();
//    linkedList.reservePrint(linkedList.head);
//    Node m = linkedList.findMiddleNode();
//    System.out.println(m.e);

    // 链表是否相交
    // 新链表
    SingleLinkedList myLinkedList1 = new SingleLinkedList();
    myLinkedList1.add(1);
    myLinkedList1.add(2);
    myLinkedList1.printLink();
    System.out.println("链表一和链表二是否相交" + linkedList.isCross(linkedList.head, myLinkedList1.head));
    // 把第二个链表从第三个结点开始接在第二个链表的后面，制造相交的效果
    myLinkedList1.findNode(2).next = linkedList.findNode(3);
    myLinkedList1.printLink();
    System.out.println("链表一和链表二是否相交" + linkedList.isCross(linkedList.head, myLinkedList1.head));
    Node n = myLinkedList1.findCorssPoing(linkedList, myLinkedList1);
    if (n == null) {
      System.out.println("链表不相交");
    } else {
      System.out.println("两个链表相交，第一个交点的数值为：" + n.e);
    }
    
    
  }

}
