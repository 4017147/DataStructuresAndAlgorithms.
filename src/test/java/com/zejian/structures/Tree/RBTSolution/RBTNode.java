package com.zejian.structures.Tree.RBTSolution;

public class RBTNode<E extends Comparable<E>> {

  /**
   * 节点颜色
   */
  protected boolean color;

  protected E key;

  protected RBTNode<E> parent;

  protected RBTNode<E> left;

  protected RBTNode<E> right;

  public RBTNode(boolean color, E key, RBTNode<E> parent, RBTNode<E> left, RBTNode<E> right) {
    super();
    this.color = color;
    this.key = key;
    this.parent = parent;
    this.left = left;
    this.right = right;
  }

  public void changeColor(boolean color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "RBTNode [color=" + color + ", key=" + key + ", parent=" + parent + ", left=" + left
        + ", right=" + right + "]";
  }

}
