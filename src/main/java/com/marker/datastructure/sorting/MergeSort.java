package com.marker.datastructure.sorting;

import java.util.Arrays;

public class MergeSort {

  // 归并排序的实现
  public static void main(String[] args) {
    int[] nums = {12, 4, 13, 25, 92, 11, 9, 3, 2};
    MergeSort.sort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
//    int[] nums= {4, 12, 13, 25, 92, 2, 3, 9, 11};
//    merge(nums, 0, 4, 8);
  }

  private static void sort(int[] nums, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      sort(nums, left, mid);
      sort(nums, mid + 1, right);
      merge(nums, left, mid, right);
    }
  }

  private static void merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int l = left, r = mid + 1, index = 0;
    // 方法1
//    while (l <= mid || r <= right) {
//      if (l <= mid && r == right + 1) {
//        temp[index++] = nums[l++];
//      } else if (r <= right && l == mid + 1) {
//        temp[index++] = nums[r++];
//      } else if (nums[l] <= nums[r]) {
//        temp[index++] = nums[l++];
//      } else {
//        temp[index++] = nums[r++];
//      }
//    }
//    方法2
    while (l <= mid && r <= right) {
      if (nums[l] <= nums[r]) temp[index++] = nums[l++];
      else temp[index++] = nums[r++];
    }
    while (l <= mid) temp[index++] = nums[l++];
    while (r <= right) temp[index++] = nums[r++];
    index = 0;
    while (left <= right) nums[left++] = temp[index++];
    System.out.println(Arrays.toString(nums));
  }
}
