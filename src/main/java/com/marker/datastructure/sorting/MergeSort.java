package com.marker.datastructure.sorting;

import java.util.Arrays;

public class MergeSort {

  // 归并排序的实现
  public static void main(String[] args) {
    int[] nums = {12, 4, 13, 25, 92, 11, 9, 3, 2};
    MergeSort.sort2(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
//    int[] nums= {4, 12, 13, 25, 92, 2, 3, 9, 11};
//    merge(nums, 0, 4, 8);
  }

  public static void sort2(int[] nums, int left, int right) {
    if (left < right) {
      int mid = (right + left) / 2;
      sort2(nums, left, mid);
      sort2(nums, mid + 1, right);
      merge2(nums, left, mid, right);
    }
  }

  public static void merge2(int[] nums, int left, int mid, int right) {
    int l = left, r = mid + 1, index = 0;
    int[] t = new int[right - left + 1];
    while (l <= mid && r <= right) {
      if (nums[l] <= nums[r])
        t[index++] = nums[l++];
      else
        t[index++] = nums[r++];
    }
    while (l <= mid) {
      t[index++] = nums[l++];
    }
    while (r <= right) {
      t[index++] = nums[r++];
    }
    index = 0;
    while (left <= right) {
      nums[left++] = t[index++];
    }
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
      if (nums[l] <= nums[r])
        temp[index++] = nums[l++];
      else
        temp[index++] = nums[r++];
    }
    while (l <= mid)
      temp[index++] = nums[l++];
    while (r <= right)
      temp[index++] = nums[r++];
    index = 0;
    while (left <= right)
      nums[left++] = temp[index++];
    System.out.println(Arrays.toString(nums));
  }
}
