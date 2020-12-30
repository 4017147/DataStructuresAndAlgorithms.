package com.marker.datastructure.base.sorting;

/**
 * 
 * @describe 插入排序
 * @author marker.li lyl
 * @date 2020/03/24
 */
public class InsertSort {

  public void sort(int[] array) throws Exception {
    int temp;
    for (int i = 1; i < array.length; i++) {
      // 待排元素小于有序序列的最后一个元素时，向前插入
      if (array[i] < array[i - 1]) {
        temp = array[i];
        for (int j = i; j >= 0; j--) {
          if (j > 0 && array[j - 1] > temp) {
            array[j] = array[j - 1];
          } else {
            array[j] = temp;
            break;
          }
        }
      }
    }

  }

  public static void main(String[] args) {
    InsertSort sort = new InsertSort();
    try {
      int array[] = new int[100000];
      for (int i = 0; i < 100000; i++) {
        array[i] = (int) (Math.random() * 1000000);
      }
      long begin = System.currentTimeMillis();
      sort.sort(array);
      System.out.println("总耗时=" + (System.currentTimeMillis() - begin));
//      Optional.of(array).map(Arrays::toString).ifPresent(System.out::println);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
