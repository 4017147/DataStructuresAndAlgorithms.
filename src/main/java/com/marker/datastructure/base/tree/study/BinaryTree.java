package com.marker.datastructure.base.tree.study;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

  protected BinaryNode<T> root;
  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.root == null;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return this.size(root);
  }

  public int size(BinaryNode<T> p) {
    return p == null ? 0 : this.size(p.left) + 1 + this.size(p.right);
  }

  @Override
  public int helight() {
    return this.helight(this.root);
  }

  public int helight2() {
    if (this.root == null) return 0;
    int height = 0;
    Queue<BinaryNode<T>> queue = new LinkedList<>();
    queue.add(this.root);
    int levelSize = 1;
    while (!queue.isEmpty()) {
      BinaryNode<T> node = queue.poll();
      levelSize--;
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
      if (levelSize == 0) {
        levelSize = queue.size();
        height++;
      }
    }
    return height;
  }


  public int helight(BinaryNode<T> p) {
    return (p == null) ? 0 : Math.max(this.helight(p.left), this.helight(p.right)) + 1;
  }

  @Override
  public void insert(T data) {
    this.root = this.insert(data, this.root);
  }

  public void insert2(T data) {
    if (this.root == null) {
      this.root = new BinaryNode<T>(null, data, null);
    }
    BinaryNode<T> p = null;
    BinaryNode<T> c = this.root;
    while (c != null) {
      int result = data.compareTo(c.data);
      if (result < 0) {
        c = c.left;
        p = c;
      } else if (result > 0) {
        c = c.right;
        p = c;
      } else {
        return;
      }
    }
    BinaryNode<T> newNode = new BinaryNode<T>(null, data, null);
    if (data.compareTo(p.data) > 0) {
      p.right = newNode;
    } else if (data.compareTo(p.data) < 0) {
      p.left = newNode;
    }
  }

  private BinaryNode<T> insert(T data, BinaryNode<T> p) {
    if (p == null) {
      p = new BinaryNode<T>(null, data, null);
      return p;
    }
    int result = data.compareTo(p.data);
    if (result < 0) {
      p.left = this.insert(data, p.left);
    } else if (result > 0) {
      p.right = this.insert(data, p.right);
    } else {
      ;
    }
    return p;
  }

  @Override
  public void remove(T data) {
    // TODO Auto-generated method stub
    this.root = this.remove(data, this.root);
  }

  public void remove2(T data) {
    // TODO Auto-generated method stub
    if (this.root == null) {
      return;
    }
    BinaryNode<T> p = this.root;
    while (p != null) {
      int result = data.compareTo(p.data);
      if (result < 0) {
        p = p.left;
      } else if (result > 0) {
        p = p.right;
      } else if (p.left != null && p.right != null) {
        BinaryNode<T> l = p.right;
        while (l.left != null) {
          l = l.left;
        }
        p.data = l.data;
      } else {
        p = (p.left != null) ? p.left : p.right;
      }
    }
  }

  public BinaryNode<T> remove(T data, BinaryNode<T> p) {
    if (p == null) {
      return p;
    }
    int result = data.compareTo(p.data);
    if (result < 0) {
      p.left = this.remove(data, p.left);
    } else if (result > 0) {
      p.right = this.remove(data, p.right);
    } else if (p.left != null && p.right != null) {
      p.data = this.findMin(p.right).data;
      p.right = this.remove(p.data, p.right);
    } else {
      p = (p.left != null) ? p.left : p.right;
    }
    return p;
  }

  public BinaryNode<T> findMin(BinaryNode<T> p) {
    if (p == null) {
      return null;
    } else if (p.left == null) {
      return p;
    }
    return this.findMin(p);
  }

  public BinaryNode<T> findMax(BinaryNode<T> p) {
    if (p == null) {
      return null;
    } else if (p.right == null) {
      return p;
    }
    return this.findMax(p);
  }

  @Override
  public String preOrder() {
    // TODO Auto-generated method stub
    return this.preOrder(this.root);
  }

  public String preOrder(BinaryNode<T> p) {
    if (p == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(p.data + ",");
    sb.append(this.preOrder(p.left));
    sb.append(this.preOrder(p.right));
    return sb.toString();
  }

  @Override
  public String inOrder() {
    // TODO Auto-generated method stub
    return this.inOrder(this.root);
  }

  public String inOrder(BinaryNode<T> p) {
    if (p == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(this.inOrder(p.left));
    sb.append(p.data + ",");
    sb.append(this.inOrder(p.right));
    return sb.toString();
  }

  @Override
  public String postOrder() {
    // TODO Auto-generated method stub
    return this.postOrder(this.root);
  }

  public String postOrder(BinaryNode<T> p) {
    if (p == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(this.inOrder(p.left));
    sb.append(this.inOrder(p.right));
    sb.append(p.data + ",");
    return sb.toString();
  }

  @Override
  public String levelOrder() {
    BinaryNode<T> p = this.root;
    Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
    StringBuilder sb = new StringBuilder();
    while (p != null) {
      sb.append(p.data);
      if (p.left != null) {
        queue.add(p.left);
      }
      if (p.right != null) {
        queue.add(p.right);
      }
      p = queue.poll();
    }
    return sb.toString();
  }

  @Override
  public T findMax() {
    return this.findMax(this.root).data;
  }

  @Override
  public T findMin() {
    return this.findMin(this.root).data;
  }

  @Override
  public BinaryNode<T> findNode(T data) {
    // TODO Auto-generated method stub
    return this.findNode2(data, this.root);
  }

  public BinaryNode<T> findNode2(T data, BinaryNode<T> p) {
    if (p == null) {
      return null;
    }
    int result = data.compareTo(p.data);
    if (result < 0) {
      return this.findNode2(data, p.left);
    } else if (result > 0) {
      return this.findNode2(data, p.right);
    }
    return p;
  }

  @Override
  public boolean constans(T data) {
    // TODO Auto-generated method stub
    return this.findNode(data) != null;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    this.clear(this.root);
  }

  public void clear(BinaryNode<T> p) {
    if (p != null) {
      this.clear(p.left);
      this.clear(p.right);
      p = null;
    }
  }

}
