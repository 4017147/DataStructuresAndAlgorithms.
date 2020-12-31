package com.marker.datastructure.sorting;

import java.util.Arrays;

public class BubbleSort {


  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 12, 34, 1, 4, 5, 10, 33};
    sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
