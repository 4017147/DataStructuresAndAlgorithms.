package com.marker.datastructure.sorting;

import java.util.Arrays;

public class InsertSort {

  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (nums[j - 1] > nums[j]) {
          int temp = nums[j - 1];
          nums[j - 1] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }


  public static void optimizeSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int left = 0, mind, right = i - 1;
      int temp = nums[i];
      if (temp < nums[right]) {
        while (left <= right) {
          mind = (left + right) / 2;
          if (nums[mind] < temp) {
            left = mind + 1;
          } else if (nums[mind] > temp) {
            right = mind - 1;
          } else {
            left = left + 1;
          }
        }
        for (int j = i; j > left; j--) {
          nums[j] = nums[j - 1];
        }
        nums[left] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {12, 4, 13, 25, 92, 11, 9, 3, 2};
    InsertSort.sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}
