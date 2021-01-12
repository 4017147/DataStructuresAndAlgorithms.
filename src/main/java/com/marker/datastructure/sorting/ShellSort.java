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
  /**
   * 希尔排序 针对有序序列在插入时采用交换法
   * 
   * @param arr
   */
  public static void sort(int[] arr) {
    int gaps = 1;
    while (arr.length / 3 >= gaps) {
      gaps = gaps * 3 + 1;
    }
//    for (int gap = gaps; gap > 0; gap = (gap - 1) / 3) {
//      for (int i = gap; i < arr.length; i++) {
//        int j = i;
//        int temp = arr[j];
//        if (arr[j] < arr[j - gap]) {
//          while (j - gap >= 0 && temp < arr[j - gap]) {
//            arr[j] = arr[j - gap];
//            j -= gap;
//          }
//          arr[j] = temp;
//        }
//      }
//    }

    for (int gap = gaps; gap > 0; gap = (gap - 1) / 3) {
      for (int i = gap; i < arr.length; i++) {
        int j = i;
        while (j - gap >= 0 && arr[j] < arr[j - gap]) {
          int temp = arr[j - gap];
          arr[j - gap] = arr[j];
          arr[j] = temp;
          j -= gap;
        }
      }
    }

  }

  public static void sort2(int[] nums) {
    for (int gap = nums.length; gap > 0; gap /= 2) {
      for (int i = gap; i < nums.length; i++) {
        int j = i;
        int temp = nums[i];
        if (nums[j] < nums[j - gap]) {
          while (j - gap >= 0 && temp < nums[j - gap]) {
            nums[j] = nums[j - gap];
            j -= gap;
          }
          nums[j] = temp;
        }
//        while (j - gap >= 0 && nums[j] < nums[j - gap]) {
//          swap(nums, j, j - gap);
//          j -= gap;
//        }
      }
    }
  }

  /**
   * 交换数组元素
   * 
   * @param arr
   * @param a
   * @param b
   */
  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {12, 4, 13, 25, 92, 11, 9, 3, 2};
    sort2(nums);
    System.out.println(Arrays.toString(nums));
  }
}
