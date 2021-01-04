package com.marker.datastructure.linkedlist;

/**
 * 
 * @describe 单向循环链表
 * @author marker.li lyl
 * @date 2021/01/04
 */
public class CycleLinkedList {

  public Node head;

  private int size;

  /**
   * 链表添加结点: 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
   * 
   * @param data
   */
  public boolean add(int e) {
    Node node = new Node(e);
    if (head == null) {
      head = node;
      head.next = node;
      node.next = head;
      size++;
      return true;
    }
    Node pred = this.head;
    while (pred.next != head) {
      pred = pred.next;
    }
    pred.next = node;
    node.next = head;
    size++;
    return true;
  }

  /**
   * 链表删除结点: 把要删除结点的前结点指向要删除结点的后结点，即直接跳过待删除结点
   * 
   * @param index
   * @return
   */
  public boolean delete(int index) {
    if (index < 0 || index > size + 1) {
      return false;
    }
    if (index == 0) {
      Node node = this.head.next;
      Node temp = this.head;
      while (temp.next != this.head) {
        temp = temp.next;
      }
      this.head = node;
      temp.next = node;
      return true;
    }
    int count = 0;
    Node node = this.head;
    while (count != index - 1) {
      node = node.next;
      count++;
    }
    node.next = node.next.next;
    return true;
  }

  /**
   * 链表添加结点: 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
   * 
   * @param data
   */
  public int length() {
    int length = 1;
    Node curNode = head;
    while (curNode.next != this.head) {
      length++;
      curNode = curNode.next;
    }
    return length;
  }



  /**
   * 查找正数第k个元素
   */
  public Node findNode(int k) {
    if (k < 1 || k > this.length()) {// 不合法的k
      return null;
    }
    Node temp = head;
    for (int i = 0; i < k - 1; i++) {
      temp = temp.next;
    }
    return temp;
  }

  class Node {
    Node next = null;

    int e;

    public Node(int e) {
      super();
      this.e = e;
    }

    @Override
    public String toString() {
      return "Node [next=" + next + ", e=" + e + "]";
    }

  }


  @Override
  public String toString() {
    return "SingleLinkedList [head=" + head + "]";
  }



}
