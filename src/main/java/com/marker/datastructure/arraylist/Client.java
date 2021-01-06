package com.marker.datastructure.arraylist;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Client {

  public static void main(String[] args) {
//    arrayListDemo();
    orderdArray();
//    int[] nums = {-1, 0, 1, 2, -1, -4};
//    int[] nums = {3, -2, 1, 0};
//    System.out.println(threeSum(nums));
  }


  static void arrayListDemo() {
    MyArrayList<Integer> arrays = new MyArrayList<>();
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
    OrderdArray array2 = new OrderdArray(3);
    array2.add(44);
    array2.add(35);
    array2.add(100);
    array2.merge(array);
    System.out.println(array2.toString());
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return new ArrayList<List<Integer>>(0);
    }
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      int a = nums[i], b = nums[i + 1];
      int indexA = i;
      int indexB = i + 1;
      for (int j = 0; j < nums.length; j++) {
        int c = nums[j];
        int indexC = j;
        if (a + b + c == 0 && (j != i && j != i + 1)) {
          List<Integer> integers = new ArrayList<Integer>();
          int[] temp = {a, b, c};
          Arrays.sort(temp);
          int low = temp[0], min = temp[1], height = temp[2];
          integers.add(low);
          integers.add(min);
          integers.add(height);
          String f = String.format("%s:%s:%s", low, min, height);
          if (map.get(f) == null) {
            map.put(f, integers);
          }
        }
      }
    }
    return new ArrayList<List<Integer>>(map.values());
  }
}
