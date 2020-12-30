package com.marker.datastructure.arraylist;

import java.util.Arrays;

/**
 * marker.有序数组的增删改查
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/12/30
 */
public class OrderdArray {

  private int size;

  private int capacity;

  private Integer[] elements;

  public OrderdArray(int capacity) {
    super();
    this.elements = new Integer[capacity];
    this.capacity = capacity;
  }

  public int find(int value) {
    int low = 0, height = size - 1, mid;
    while (low <= height) {
      mid = (low + height) / 2;
      if (elements[mid] == value) {
        return mid;
      }
      if (value > elements[mid]) {
        low = mid + 1;
      } else {
        height = mid - 1;
      }
    }
    return -1;
  }

  public boolean add(int value) {
    if (this.size >= capacity) return false;
    if (this.size == 0) {
      this.elements[size++] = value;
      return true;
    }
    if (this.size > 0 && value > this.elements[size - 1]) {
      this.elements[size++] = value;
      return true;
    }
    for (int i = 0; i < this.size; i++) {
//      System.out.println(this.elements[i] + ",i=" + i + "value:" + value);
      if (this.elements[i] == value) {
        return false;
      }
      if (this.elements[i] > value) {
        System.arraycopy(this.elements, i, this.elements, i + 1, size - i);
        this.elements[i] = value;
        this.size++;
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "OrderdArray [size=" + size + ", capacity=" + capacity + ", elements="
        + Arrays.toString(elements) + "]";
  }

  public boolean remove(int value) {
    int index = 0;
    boolean flag = false;
    index: for (int i = 0; i < size; i++) {
      if (value == this.elements[i]) {
        flag = true;
        index = i;
        break index;
      }
    }
    if (!flag) {
      return false;
    }
    System.out.println("index:" + index + ",size:" + size);
    int length = size - 1;
    System.arraycopy(this.elements, index + 1, this.elements, index, length - index);
    this.elements[length] = null;
    size--;
    return flag;
  }


  public int set(int value, int newValue) {
    int index = this.find(value);
    this.elements[index] = newValue;
    return index;
  }


  public void merge(OrderdArray array) {
    int size = array.size;
    Integer[] es = array.elements;
    this.capacity += size;
    this.elements = Arrays.copyOf(this.elements, this.capacity);
    for (int i = 0; i < size; i++)
      this.add(es[i]);
  }

}
