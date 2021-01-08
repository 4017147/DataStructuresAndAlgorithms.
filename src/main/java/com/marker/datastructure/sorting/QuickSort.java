package com.marker.datastructure.sorting;

import java.util.Arrays;

/**
 * Title: 交换排序中的快速排序，目前应用最为广泛的排序算法，是一个递归算法 Description:快速排序包括两个过程：划分 和 快排 "划分"是指将原序列按基准元素划分两个子序列
 * "快排"是指分别对子序列进行快排
 * 
 * 就平均计算时间而言，快速排序是所有内部排序方法中最好的一个
 * 
 * 对大规模数据排序时，快排是快的；对小规模数据排序时，快排是慢的，甚至慢于简单选择排序等简单排序方法
 * 
 * 快速排序依赖于原始序列，因此其时间复杂度从O(nlgn)到O(n^2)不等 时间复杂度：最好情形O(nlgn)，平均情形O(nlgn)，最差情形O(n^2)
 * 
 * 递归所消耗的栈空间 空间复杂度：O(lgn)
 * 
 * 可选任一元素作为基准元素 稳 定 性：不稳定
 * 
 * 
 * 内部排序(在排序过程中数据元素完全在内存)
 * @describe 
 * @author marker.li lyl
 * @date 2021/01/08
 */
public class QuickSort {

  /**
   * @description 快排算法(递归算法)：在递去过程中就把问题解决了
   * @author marker.li lyl
   * @created 2021/01/08
   * @param target
   * @param left
   * @param right
   * @return
   */
  public static int[] quickSort(int[] target, int left, int right) {
    if (right > left) { // 递归终止条件
      int base_index = partition(target, left, right); // 原序列划分后基准元素的位置
      System.out.println("base_index:" + base_index);
      quickSort(target, left, base_index - 1); // 对第一个子序列快速排序，不包含基准元素！
      quickSort(target, base_index + 1, right); // 对第二个子序列快速排序，不包含基准元素！
    }
    return target;
  }


  /**
   * @description 序列划分，以第一个元素为基准元素
   * @author marker.li lyl
   * @created 2021/01/08
   * @param target 序列
   * @param left 序列左端
   * @param right 序列右端
   * @return
   */
  public static int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    int leftIndex = left + 1;
    int rightIndex = right;

    while (leftIndex <= rightIndex) {
      while (leftIndex <= rightIndex && nums[rightIndex] > pivot)
        rightIndex--;
      while (leftIndex <= rightIndex && nums[leftIndex] <= pivot)
        leftIndex++;
      if (leftIndex < rightIndex) swap(nums, leftIndex, rightIndex);
    }

    System.out.println(leftIndex + "," + rightIndex);

    swap(nums, rightIndex, left);
//    int pivot = nums[right];
//    int leftIndex = left;
//    int rightIndex = right - 1;
//
//    while (leftIndex <= rightIndex) {
//      while (leftIndex <= rightIndex && nums[leftIndex] <= pivot)
//        leftIndex++;
//      while (leftIndex <= rightIndex && nums[rightIndex] > pivot)
//        rightIndex--;
//      if (leftIndex < rightIndex) swap(nums, leftIndex, rightIndex);
//      System.out.println("left:" + leftIndex + ",right:" + rightIndex);
//      System.out.println("arr:" + Arrays.toString(nums));
//    }
//    
//    swap(nums, leftIndex, right);
//    System.out.println("arr:" + Arrays.toString(nums));
    return rightIndex;
  }

  public static void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public static void main(String[] args) {
//    int[] target6 = {2, 12, 34, 3, 4, 5, 10, 33};
    int[] target6 = {12, 2, 3, 17};
    System.out.println("原数组 ： " + Arrays.toString(target6));
    QuickSort.quickSort(target6, 0, target6.length - 1);
    System.out.println("排序后 ： " + Arrays.toString(target6));
  }
}
