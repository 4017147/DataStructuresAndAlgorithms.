package com.marker.datastructure.sorting;

import java.util.Arrays;

/**
 * Title: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行n-1次比较
 * Description:因为越大的元素会经由交换慢慢"浮"到数列的顶端(最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2) 空间复杂度：O(1) 稳 定 性：稳定 内部排序(在排序过程中数据元素完全在内存)
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/01/05
 */
public class BubbleSort {

  public void bubbleSort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i; j < n - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }

  public void optimizeBubbleSort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      boolean exchange = false;
      for (int j = i; j < n - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
          exchange = true;
        }
      }
      if (!exchange) {
        return;
      }
    }
  }

  public static void main(String[] args) {
    BubbleSort bubbleSort = new BubbleSort();
//    int[] nums = {2, 12, 34, 3, 4, 5, 10, 33};
//    bubbleSort.bubbleSort(nums);
//    System.out.println(Arrays.toString(nums));
    System.out.println("\n----------------------\n");
    System.out.println("优化冒泡排序 ： ");
    int[] nums = {1, 2, 3, 4, 5, 8, 7, 6};
    System.out.println("原数组 ： " + Arrays.toString(nums));
    bubbleSort.optimizeBubbleSort(nums);
    System.out.println(Arrays.toString(nums));
  }

}
