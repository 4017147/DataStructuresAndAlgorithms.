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

    return target;
  }

  public static void main(String[] args) {
    System.out.println("\n----------------------\n");
    System.out.println("希尔排序 ： ");
    int[] nums = {12, 4, 13, 25, 92, 11, 9, 3, 2};
    System.out.println("原数组 ： " + Arrays.toString(nums));
    shellSort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
