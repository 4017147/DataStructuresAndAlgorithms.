package com.marker.datastructure.linkedlist.single;

import com.marker.datastructure.linkedlist.List;

public class Client {
  public static void main(String[] args) {



//    test(new SingleLinkedListDemo1<>());
    test(new SingleLinkedListDemo2<>());
  }

  public static void test(List demo1) {
    demo1.add("marker.1");
    demo1.add("marker.2");
    demo1.add("marker.3");
    demo1.add("marker.4");
    System.out.println(demo1.get(1));
    System.out.println(demo1.get(2));
    System.out.println(demo1.remove(1));
    System.out.println(demo1.toString());
    System.out.println(demo1.set(1, "marker.n2"));
    System.out.println(demo1.toString());
    demo1.add(1, "marker.n3");
    System.out.println(demo1.toString());
    System.out.println("===========================");
  }
}
