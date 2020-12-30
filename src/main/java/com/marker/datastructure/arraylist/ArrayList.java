package com.marker.datastructure.arraylist;

import java.util.Arrays;

public class ArrayList<E> {

  private int size;

  private E[] elements;

  private static final int DEFAULT_CAPACITY = 10;

  private static final int ELEMENT_NOT_FOUND = -1;

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }


  @SuppressWarnings("unchecked")
  public ArrayList(int capacity) {
    capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
    this.elements = (E[]) new Object[capacity];
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean constants(E e) {
    return this.indexOf(e) != ELEMENT_NOT_FOUND;
  }

  public void add(E element) {
    this.add(this.size, element);
  }

  public void add(int index, E element) {
    this.rangCheckForAdd(index);
    this.ensureCapacity(this.size + 1);
    for (int i = size; i > index; i--) {
      elements[i] = elements[i - 1];
    }
    elements[index] = element;
    size++;
  }

  public E remove(int index) {
    this.rangCheck(index);
    E old = this.elements[index];
    for (int i = index + 1; i < size; i++) {
      elements[i - 1] = elements[i];
    }
    elements[--size] = null;
    return old;
  }

  public int indexOf(E element) {
    if (element == null) {
      for (int i = 0; i < size; i++) {
        if (elements[i] == null) return i;
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (element.equals(elements[i])) return i;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  public void clear() {
    for (int i = 0; i < elements.length; i++) {
      this.elements[i] = null;
    }
    this.size = 0;
  }

  public E get(int index) {
    this.rangCheck(index);
    return this.elements[index];
  }


  public E set(int index, E element) {
    this.rangCheck(index);
    E old = elements[index];
    elements[index] = element;
    return old;
  }

  @SuppressWarnings("unchecked")
  public void ensureCapacity(int capacity) {
    int oldCapacity = this.elements.length;
    if (oldCapacity > capacity) return;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    E[] newElements = (E[]) new Object[newCapacity];
    for (int i = 0; i < this.size; i++) {
      newElements[i] = elements[i];
    }
    this.elements = newElements;
  }

  private void rangCheckForAdd(int index) {
    if (index < 0 || index > this.size) {
      this.indexOutOfBounds(index);
    }
  }

  private void rangCheck(int index) {
    if (index >= this.size) {
      this.indexOutOfBounds(index);
    }
  }


  private void indexOutOfBounds(int index) {
    throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
  }


  @Override
  public String toString() {
    return "ArrayList [size=" + size + ", elements=" + Arrays.toString(elements) + "]";
  }


}
