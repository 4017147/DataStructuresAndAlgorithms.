package com.marker.datastructure.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 了解其中思想就行了，不重要
 * @describe 
 * @author marker.li lyl
 * @date 2021/01/08
 */
public class BucketSort {

  public static void sort(int[] nums) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i : nums) {
      max = Math.max(i, max);
      min = Math.min(i, min);
    }
    int bucketNum = (max - min) / nums.length + 1;
//    System.out.println(bucketNum);

    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
      bucketArr.add(new ArrayList<Integer>());
    }

    // 将每个元素放入桶
    for (int i = 0; i < nums.length; i++) {
      int num = (nums[i] - min) / (nums.length);
      bucketArr.get(num).add(nums[i]);
    }

    // 对每个桶进行排序
    for (int i = 0; i < bucketArr.size(); i++) {
      Collections.sort(bucketArr.get(i));
    }

    System.out.println(bucketArr.toString());
  }


  public static void main(String[] args) {
    int[] nums = {3, 2, 4, 1, 4, 6, 17, 25};
    sort(nums);
  }
}
