package com.marker.datastructure.sorting;

import java.util.Arrays;


/**
 * Title: 插入排序中的希尔排序 Description: 分别对间隔为gap的gap个子序列进行直接插入排序，不断缩小gap,直至为 1
 * 刚开始时，gap较大，每个子序列元素较少，排序速度较快； 待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。 时间复杂度：O(n) ~ O(n^2)
 * 空间复杂度：O(1) 稳 定 性：不稳定 内部排序(在排序过程中数据元素完全在内存)
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/01/08
 */
public class ShellSort {


  public static int[] shellSort(int[] target) {
    // gap为步长，每次减为原来的一半。
    for (int gap = target.length / 2; gap > 0; gap /= 2) {
//      // 共gap个组，对每一组都执行直接插入排序
      for (int i = 0; i < gap; i++) {
        group_sort(target, i, gap);
      }
      System.out.println(gap);
    }
    return target;
  }

  static void group_sort(int a[], int i, int gap) {
    for (int j = i + gap; j < a.length; j += gap) {
      // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
      if (a[j] < a[j - gap]) {
        int tmp = a[j];
        int k = j - gap;
        while (k >= 0 && a[k] > tmp) {
          a[k + gap] = a[k];
          k -= gap;
        }
        a[k + gap] = tmp;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {12, 4, 13, 25, 92, 11, 9, 3, 2};
    shellSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
