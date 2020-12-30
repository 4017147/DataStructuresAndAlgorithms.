package com.marker.datastructure.base.tree.study;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

  private AVLNode<T> root;

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return root == null;
  }

  @Override
  public int size() {
    return this.size(this.root);
  }

  public int size(AVLNode<T> p) {
    return p == null ? 0 : this.size(p.left) + this.size(p.right) + 1;
  }

  @Override
  public int helight() {
    return this.helight(this.root);
  }

  public int helight(AVLNode<T> p) {
    return (p == null) ? 0 : p.height;
  }

  @Override
  public void insert(T data) {
    this.root = this.insert(data, this.root);
  }

  public AVLNode<T> insert(T data, AVLNode<T> p) {
    if (p == null) {
      p = new AVLNode<T>(data);
      return p;
    }
    int result = data.compareTo(p.data);
    if (result < 0) {
      p.left = this.insert(data, p.left);
      if ((this.helight(p.left) - this.helight(p.right)) == 2) {
        // ll 单次右旋转
        if (data.compareTo(p.left.data) < 0) {
          p = this.singleRotateLL(p);
        } else {
          // 左右旋转 先左后右边
          p = this.doubleRotateLR(p);
        }
      }
    } else if (result > 0) {
      p.right = this.insert(data, p.right);
      if ((this.helight(p.right) - this.helight(p.left)) == 2) {
        // rr 单次左旋转
        if (data.compareTo(p.right.data) > 0) {
          p = this.singleRotateRR(p);
        } else {
          // 左右旋转
          p = this.doubleRotateRight(p);
        }
      }

    } else {
      ;
    }
    // 更新高度值
    if (p != null) p.height = Math.max(helight(p.left), helight(p.right)) + 1;
    return p;
  }

  private AVLNode<T> doubleRotateLR(AVLNode<T> p) {
    p.left = this.singleRotateRR(p.left);
    return this.singleRotateLL(p);
  }

  private AVLNode<T> doubleRotateRight(AVLNode<T> p) {
    p.right = this.singleRotateLL(p.right);
    return this.singleRotateRR(p);
  }

  // 单旋转 rr
  private AVLNode<T> singleRotateRR(AVLNode<T> p) {
    AVLNode<T> w = p.right;
    p.right = w.left;
    w.left = p;
    p.height = Math.max(this.helight(p.left), this.helight(p.right)) + 1;
    w.height = Math.max(this.helight(w.left), this.helight(w.right)) + 1;
    return w;
  }

  // 单旋转 ll
  public AVLNode<T> singleRotateLL(AVLNode<T> p) {
    AVLNode<T> w = p.left;
    p.left = w.right;
    w.right = p;
    p.height = Math.max(this.helight(p.left), this.helight(p.right)) + 1;
    w.height = Math.max(this.helight(w.left), this.helight(w.right)) + 1;
    return w;
  }



  @Override
  public void remove(T data) {
    // TODO Auto-generated method stub

  }

  @Override
  public String preOrder() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String inOrder() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String postOrder() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String levelOrder() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T findMax() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T findMin() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BinaryNode<T> findNode(T data) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean constans(T data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

}
