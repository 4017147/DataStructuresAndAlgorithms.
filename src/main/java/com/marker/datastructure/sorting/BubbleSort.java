package com.marker.datastructure.sorting;

import java.util.Arrays;
import java.util.Optional;

/**
 * 
 * @describe 冒泡排序
 * @author marker.li lyl
 * @date 2020/03/24
 */
public class BubbleSort {

  public void sort(int[] array) throws Exception {
    for (int i = array.length; i > 0; i++) {
      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          flag = true;
        }
      }
      if (!flag) {
        break;
      }
    }

  }


  public static void main(String[] args) {
    BubbleSort sort = new BubbleSort();
    try {
      int array[] = new int[100000];
      for (int i = 0; i < 100000; i++) {
        array[i] = (int) (Math.random() * 1000000);
      }
      long begin = System.currentTimeMillis();
      sort.sort(array);
      Optional.of(array).map(Arrays::toString).ifPresent(System.out::println);
      System.out.println("总耗时=" + (System.currentTimeMillis() - begin));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
