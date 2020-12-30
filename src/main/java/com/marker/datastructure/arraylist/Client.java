package com.marker.datastructure.arraylist;

public class Client {

  public static void main(String[] args) {

//    arrayListDemo();
    orderdArray();
  }

  static void arrayListDemo() {
    ArrayList<Integer> arrays = new ArrayList<>();
    arrays.add(0, 0);
    arrays.add(1, 1);
    arrays.add(2, 2);
    System.out.println(arrays.toString());
    arrays.remove(1);
    arrays.remove(1);
    System.out.println(arrays.toString());
  }


  static void orderdArray() {
    OrderdArray array = new OrderdArray(10);
    System.out.println(array.add(3));
    System.out.println(array.add(6));
    System.out.println(array.add(5));
    System.out.println(array.add(10));
    System.out.println(array.add(8));
    System.out.println(array.add(9));
    System.out.println(array.add(7));
    System.out.println(array.add(11));
    System.out.println(array.add(4));
    System.out.println(array.add(67));
    System.out.println(array.add(66));
    System.out.println(array.toString());
    System.out.println(array.remove(11));
    System.out.println(array.remove(4));
    System.out.println(array.remove(67));
    System.out.println(array.remove(66));
    System.out.println(array.toString());
    System.out.println("find:" + array.find(10));
    System.out.println("find:" + array.find(5));
    System.out.println("find:" + array.find(3));
    OrderdArray array2 = new OrderdArray(5);
    array2.add(44);
    array2.add(35);
    array2.add(100);
    array2.merge(array);
    System.out.println(array2.toString());
  }

}
