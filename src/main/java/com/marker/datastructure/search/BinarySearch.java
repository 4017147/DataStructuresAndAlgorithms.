package com.marker.datastructure.search;

public class BinarySearch {

  public static int search(int nums[], int value) {
    int right = nums.length - 1;
    int left = 0;
    while (left <= right) {
      if (nums[left] == value) {
        return left;
      }
      if (nums[right] == value) {
        return right;
      }
      int mid = (left + right) / 2;
      if (nums[mid] < value) {
        left = mid + 1;
      } else if (nums[mid] > value) {
        right = mid - 1;
      } else if (nums[mid] == value) {
        return mid;
      }
    }
    return -1;
  }

  public static int search2(int nums[], int value) {
    int right = nums.length - 1;
    int left = 0;
    while (left <= right) {
      if (nums[left] == value) {
        return left;
      }
      if (nums[right] == value) {
        return right;
      }
//      int mid = (left + right) / 2;
      // 插入二分查找mid的自适应，二分查找的一种优化
      int mid = left + (right - left) * (value - nums[left]) / (nums[right] - nums[left]);
      if (nums[mid] < value) {
        left = mid + 1;
      } else if (nums[mid] > value) {
        right = mid - 1;
      } else if (nums[mid] == value) {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {10, 12, 18, 29, 40, 55};
    int result = search2(nums, 12);
    System.out.println(result);
  }

}
