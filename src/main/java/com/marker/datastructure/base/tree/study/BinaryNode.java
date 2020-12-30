package com.marker.datastructure.base.tree.study;

import java.io.Serializable;

public class BinaryNode<T extends Comparable<T>> implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  protected BinaryNode<T> left;

  protected T data;

  protected BinaryNode<T> right;

  protected BinaryNode(BinaryNode<T> left, T data, BinaryNode<T> right) {
    super();
    this.left = left;
    this.data = data;
    this.right = right;
  }

  protected BinaryNode(T data) {
    this(null, data, null);
  }

  protected boolean isLeaf() {
    return this.left != null && this.right != null;
  }

}
