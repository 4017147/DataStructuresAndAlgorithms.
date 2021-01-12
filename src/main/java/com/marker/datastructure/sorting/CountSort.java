package com.marker.datastructure.sorting;

import java.util.Arrays;

/**
 * 计数排序
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/01/08
 */
public class CountSort {

  public static void sort(int[] nums) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i : nums) {
      max = Math.max(i, max);
      min = Math.min(i, min);
    }
    int[] c = new int[max - min + 1];
    for (int i = 0; i < nums.length; i++)
      c[nums[i] - min]++;
    for (int i = 1; i < c.length; i++)
      c[i] = c[i] + c[i - 1];
    int[] p = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int pos = nums[i] - min;
      int index = c[pos] - 1;
      p[index] = nums[i];
      c[pos]--;
    }
    System.out.println(Arrays.toString(p));
  }

  public static void sort2(int[] nums) {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int i : nums) {
      max = Math.max(i, max);
      min = Math.min(i, min);
    }
    int c[] = new int[max - min + 1];
    for (int i = 0; i < nums.length; i++) {
      c[nums[i] - min]++;
    }
    for (int i = 1; i < c.length; i++) {
      c[i] += c[i - 1];
    }
    int[] p = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int pos = nums[i] - min;
      int ix = c[pos] - 1;
      p[ix] = nums[i];
      c[pos]--;
    }
    for (int i = 0; i < nums.length; i++)
      nums[i] = p[i];
  }

  public static void main(String[] args) {
    int[] nums = {101, 103, 104, 105, 103, 106, 103};
    sort2(nums);
    System.out.println("原数组 ： " + Arrays.toString(nums));
  }

}
