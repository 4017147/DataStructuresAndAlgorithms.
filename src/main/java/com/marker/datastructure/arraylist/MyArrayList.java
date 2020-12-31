package com.marker.datastructure.arraylist;

import java.util.Arrays;
import java.util.Objects;

/**
 * 数组列表的实现
 * @describe
 * @author marker.li lyl
 * @date 2021/12/30
 */
public class MyArrayList<E> {

  private int size;

  private Object[] elements;

  public static final Object[] EMPTY_ELEMENTDATA = {};

  public static final Object[] DEFAULTCAPATICY_EMPTY_ELEMENTDATA = {};

  public static final int DEFAULT_CAPACITY = 10;

  public MyArrayList() {
    elements = DEFAULTCAPATICY_EMPTY_ELEMENTDATA;
  }


  public MyArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
      elements = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
      elements = EMPTY_ELEMENTDATA;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
  }

  public int size() {
    return size;
  }

  public boolean constants(E element) {
    return false;
  }

  public void add(E element) {
    this.add(this.size, element);
  }

  public void add(int index, E element) {
    this.rangCheckForAdd(index);
    this.ensureCapacityInternal(this.size + 1);
    System.arraycopy(this.elements, index, this.elements, index + 1, this.size - index);
    this.elements[index] = element;
    this.size++;
  }

  public E remove(int index) {
    this.rangCheckForAdd(index);
    E e = this.element(index);
    int numMoved = size - index;
    if (numMoved > 0) {
      System.arraycopy(this.elements, index + 1, this.elements, index, numMoved);
    }
    elements[--size] = null; // clear to let GC do its work
    return e;
  }


  public void clear() {
    for (int i = 0; i < this.elements.length; i++)
      elements[i] = null;
    size = 0;
  }

  public int indexOf(E element) {
    for (int i = 0; i < this.elements.length; i++) {
      if (Objects.equals(element, elements[i])) {
        return i;
      }
    }
    return -1;
  }

  public E get(int index) {
    rangCheckForAdd(index);
    return (E) this.elements[index];
  }

  public E set(int index, E element) {
    rangCheckForAdd(index);
    E e = this.element(index);
    this.elements[index] = element;
    return e;
  }

  private E element(int index) {
    return (E) this.elements[index];
  }

  public void ensureCapacityInternal(int capacity) {
    this.ensureExplicitCapacity(this.calculateCapacity(this.elements, capacity));
  }

  private void ensureExplicitCapacity(int minCapacity) {
    if (minCapacity > this.elements.length) {
      this.grow(minCapacity);
    }
  }

  private void grow(int minCapacity) {
    int oldCapacity = this.elements.length;
    int newCapacity = oldCapacity + oldCapacity >> 1;
    if (newCapacity - minCapacity < 0) {
      newCapacity = minCapacity;
    }
    this.elements = Arrays.copyOf(this.elements, newCapacity);
  }

  public int calculateCapacity(Object[] elements, int capacity) {
    if (elements == DEFAULTCAPATICY_EMPTY_ELEMENTDATA) {
      return Math.max(DEFAULT_CAPACITY, capacity);
    }
    return capacity;
  }


  public void rangCheckForAdd(int index) {
    if (index < 0 || index > this.size) {
      this.indexOutOfBounds(index);
    }
  }


  public void indexOutOfBounds(int index) {
    throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + this.size);
  }

  @Override
  public String toString() {
    return "ArrayList [size=" + size + ", elements=" + Arrays.toString(elements) + "]";
  }

}
