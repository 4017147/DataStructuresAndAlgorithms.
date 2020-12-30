package com.marker.datastructure.base.tree.study;

import java.io.Serializable;

public class AVLNode<T extends Comparable<T>> implements Serializable {

  private static final long serialVersionUID = 1L;

  protected AVLNode<T> left;

  protected T data;

  protected AVLNode<T> right;

  protected int height;

  public AVLNode(AVLNode<T> left, T data, AVLNode<T> right, int height) {
    super();
    this.left = left;
    this.data = data;
    this.right = right;
    this.height = height;
  }

  public AVLNode(AVLNode<T> left, T e, AVLNode<T> right) {
    this(left, e, right, 0);
  }

  public AVLNode(T e) {
    this(null, e, null);
  }

  @Override
  public String toString() {
    return "AVLNode [left=" + left + ", data=" + data + ", right=" + right + ", height=" + height
        + "]";
  }

}
