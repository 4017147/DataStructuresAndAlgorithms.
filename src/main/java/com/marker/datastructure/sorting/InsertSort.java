package com.marker.datastructure.sorting;

import java.util.Arrays;

public class InsertSort {

  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        for (int j = i; j >= 0; j--) {
          if (nums[j] > nums[j + 1]) {
            int temp = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = temp;
          }
        }
      }
    }
  }

  public static void sort2(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        for (int j = i; j >= 0; j--) {
          if (nums[j] > nums[j + 1]) {
            int temp = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = temp;
          }
        }
      }
    }
  }


  public static void main(String[] args) {
    int[] nums = {2, 12, 34, 1, 4, 5, 10, 33};
    sort2(nums);
    System.out.println(Arrays.toString(nums));
//    2, 12, 34, 1, 4, 5, 10, 33
  }

}
