package com.marker.datastructure.sorting;

import java.util.Arrays;

public class SelectSort {

  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int min = i;
      for (int j = i + 1; j < nums.length; j++) {
        int temp = nums[min];
        if (temp > nums[j]) {
          nums[min] = nums[j];
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
