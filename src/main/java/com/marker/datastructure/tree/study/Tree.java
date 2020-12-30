package com.marker.datastructure.tree.study;

public interface Tree<T extends Comparable<T>> {

  boolean isEmpty();

  int size();

  int helight();

  void insert(T data);

  void remove(T data);

  String preOrder();

  String inOrder();

  String postOrder();

  String levelOrder();

  T findMax();

  T findMin();

  BinaryNode<T> findNode(T data);

  boolean constans(T data);

  void clear();
}
