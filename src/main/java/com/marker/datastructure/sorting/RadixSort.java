package com.marker.datastructure.sorting;

import java.util.Arrays;

/**
 * Title: 分配排序中的基数排序 Description: 不是在对元素进行比较的基础上进行排序，而是采用 "分配 + 收集" 的办法
 * 
 * 首先，将目标序列各元素分配到各个桶中； 其次，将各个桶中的元素按先进先出的顺序再放回去 如此往复...
 * 
 * 时间复杂度：O(d*(r+n))或者 O(dn),d 的大小一般会受到 n的影响 空间复杂度：O(rd + n)或者 O(n) 稳 定 性：稳定 内部排序(在排序过程中数据元素完全在内存)
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/01/08
 */
public class RadixSort {

  public static int[] countSort(int a[], int exp) {
    int i, buckets[] = new int[10];
    for (i = 0; i < a.length; i++) {
      int cp = (a[i] / exp) % 10;
      buckets[cp]++;
    }

    for (i = 1; i < 10; i++)
      buckets[i] += buckets[i - 1];

    int p[] = new int[a.length];

    for (i = a.length - 1; i >= 0; i--) {
      int pos = (a[i] / exp) % 10;
      int num = buckets[pos];
      int index = num - 1;
      p[index] = a[i];
      buckets[pos]--;
    }
    return p;
  }

  public static int max(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i : nums) {
      max = Math.max(i, max);
    }
    return max;
  }

  public static int[] radixSort(int[] nums, int exp) {
    int[] c = new int[10];
 
    for (int i = 0; i < nums.length; i++) {
      int cp = (nums[i] / exp) % 10;
      c[cp]++;
    }
    for (int i = 1; i < c.length; i++) {
      c[i] += c[i - 1];
    }

    int p[] = new int[nums.length];

    for (int i = nums.length - 1; i >= 0; i--) {
      int pos = (nums[i] / exp) % 10;
      int index = c[pos] - 1;
      p[index] = nums[i];
      c[pos]--;
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = p[i];
    }
    return p;
  }

  public static void sort(int[] nums) {
    int max = maxNum(nums);
    for (int exp = 1; max / exp > 0; exp *= 10) {
      radixSort(nums, exp);
    }
    System.out.println("ss ： " + Arrays.toString(nums));
  }

  public static int maxNum(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i : nums) {
      max = Math.max(i, max);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] target8 = {53, 3, 542, 748, 14, 214, 154, 63, 616};
    sort(target8);
//    System.out.println("原数组 ： " + Arrays.toString(target8));
//    int exp; // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
//    int max = maxNum(target8); // 数组a中的最大值
//    // 从个位开始，对数组a按"指数"进行排序
//    for (exp = 1; max / exp > 0; exp *= 10) {
////      System.out.println(exp);
//      target8 = countSort(target8, exp);
//    }
//    System.out.println("原数组 ： " + Arrays.toString(target8));
  }
}
