package com.marker.datastructure.search;

public class SeqSearch {

  public static boolean search(int nums[], int value) {
    boolean i = false;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == value) {
        i = true;
        break;
      }
    }
    return i;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3};
    boolean result = search(nums, 3);
    System.out.println(result);
  }

}
