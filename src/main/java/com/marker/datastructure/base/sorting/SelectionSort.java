package com.marker.datastructure.base.sorting;

import java.util.Arrays;
import java.util.Optional;

public class SelectionSort {

  public void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }
      }
      if (min != i) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
      }
    }
  }

  public static void main(String[] args) {
    SelectionSort sort = new SelectionSort();
//    int array[] = new int[100000];
//    for (int i = 0; i < 100000; i++) {
//      array[i] = (int) (Math.random() * 1000000);
//    }
    int[] array = new int[] {22, 32, 4, 34, 65};
    long begin = System.currentTimeMillis();
    sort.sort(array);
    System.out.println("总耗时=" + (System.currentTimeMillis() - begin));
    Optional.of(array).map(Arrays::toString).ifPresent(System.out::println);
  }
}
