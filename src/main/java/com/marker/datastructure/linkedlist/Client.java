package com.marker.datastructure.linkedlist;

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

    LinkedList<String> list = new LinkedList<>();
    try {
      list.add("marker");
      list.add("marker2");
      list.add("marker3");
      list.add("marker4");
    } catch (Exception e) {
      // TODO Auto-generated catch block
       e.printStackTrace();
    }


  }

}
