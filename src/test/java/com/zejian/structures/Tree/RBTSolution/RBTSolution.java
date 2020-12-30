package com.zejian.structures.Tree.RBTSolution;

import java.util.HashMap;

public class RBTSolution<E extends Comparable<E>> {

  private RBTNode<E> root;

  private static final boolean RED = false;

  private static final boolean BLACK = true;

  public void insert(E key) {
    RBTNode<E> node = new RBTNode<E>(RED, key, null, null, null);
  }

  public void insert(RBTNode<E> node) {
    int result;
    RBTNode<E> p = this.root;
    RBTNode<E> temp = null;
    while (p != null) {
      temp = p;
      result = node.key.compareTo(p.key);
      if (result < 0) {
        p = p.left;
      } else if (result > 0) {
        p = p.right;
      } else {
        ;
      }
    }

    node.parent = temp;
    if (temp != null) {
      result = node.key.compareTo(temp.key);
      if (result < 0) {
        temp.left = node;
      } else if (result > 0) {
        temp.right = node;
      } else {
        ;
      }
    } else {
      this.root = node;
    }

    this.insertFixUp(node);

  }

  public void insertFixUp(RBTNode<E> node) {
    RBTNode<E> parent, gparent;
    while ((parent = this.parentOf(node)) != null && this.isRed(parent)) {
      gparent = this.parentOf(parent);
      // 父亲是祖父得左结点
      if (parent == gparent.left) {
        RBTNode<E> uncle = gparent.right;
        // 叔叔和父亲都是红颜色->改变颜色即可,向上递归循环改变
        if (uncle != null && this.isRed(uncle)) {
          parent.color = BLACK;
          uncle.color = BLACK;
          gparent.color = RED;
          node = gparent;
          continue;
        }
        // 当前的节点是父亲的左节点->进行右旋
        if (parent.left == node) {

        }

        // 当前的节点是父亲的左节点->先以父亲左旋->在以祖父右旋
        if (parent.right == node) {
          
        
        }
      }
    }

    this.root.color = BLACK;
  }



  private void leftRotate(RBTNode<E> x) {
    // 设置x的右孩子为y
    RBTNode<E> y = x.right;
    // 将 “y的左孩子” 设为 “x的右孩子”；
    // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
    x.right = y.left;

    if (y.left != null) y.left.parent = x;

    // 将 “x的父亲” 设为 “y的父亲”
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y; // 如果 “x的父亲” 是空节点，则将y设为根节点
    } else {
      if (x.parent.left == x)
        x.parent.left = y; // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
      else
        x.parent.right = y; // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
    }
    // 将 “x” 设为 “y的左孩子”
    y.left = x;
    // 将 “x的父节点” 设为 “y”
    x.parent = y;
  }

  /*
   * 对红黑树的节点(y)进行右旋转
   *
   * 右旋示意图(对节点y进行左旋)： py py / / y x / \ --(右旋)-. / \ # x ry lx y / \ / \ # lx rx rx ry
   *
   */
  private void rightRotate(RBTNode<E> y) {
    // 设置x是当前节点的左孩子。
    RBTNode<E> x = y.left;

    // 将 “x的右孩子” 设为 “y的左孩子”；
    // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
    y.left = x.right;
    if (x.right != null) x.right.parent = y;

    // 将 “y的父亲” 设为 “x的父亲”
    x.parent = y.parent;

    if (y.parent == null) {
      this.root = x; // 如果 “y的父亲” 是空节点，则将x设为根节点
    } else {
      if (y == y.parent.right)
        y.parent.right = x; // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
      else
        y.parent.left = x; // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
    }

    // 将 “y” 设为 “x的右孩子”
    x.right = y;

    // 将 “y的父节点” 设为 “x”
    y.parent = x;
  }

  private RBTNode<E> parentOf(RBTNode<E> node) {
    return node != null ? node.parent : null;
  }

  public boolean isRed(RBTNode<E> node) {
    return (node != null && node.color == RED) ? true : false;
  }

}
