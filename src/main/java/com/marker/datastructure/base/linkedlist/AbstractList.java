package com.marker.datastructure.base.linkedlist;

public abstract class AbstractList<E> implements List<E> {

  protected int size;

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.size == 0;
  }

  @Override
  public boolean contains(E element) {
    // TODO Auto-generated method stub
    return this.indexOf(element) != ELEMENT_NOT_FOUND;
  }

  @Override
  public void add(E element) {
    this.add(this.size, element);
  }

  protected void indexOutOfBounds(int index) {
    throw new IndexOutOfBoundsException("size:" + this.size + "index:" + index);
  }

  protected void rangeCheckOfAdd(int index) {
    if (index < 0 || index > this.size) {
      this.indexOutOfBounds(index);
    }
  }

  protected void rangeCheck(int index) {
    if (index < 0 || index >= this.size) {
      this.indexOutOfBounds(index);
    }
  }


}
