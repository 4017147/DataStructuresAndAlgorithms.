package com.marker.datastructure.linkedlist;

import java.util.Objects;

/**
 * Title: 链表的Java实现 Description: 链表结构包含两个要素： 头结点head + 链表大小size，操作包括： 链表的增删 链表是否为空 链表的大小 链表的打印输出
 * 删除链表重复节点 链表倒数第K个元素 链表的反转 链表的倒序输出 链表的中间节点 链表是否有环 链表节点的删除(不知道头结点的情况下) 链表是否相交 链表的交点
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/01/05
 */
public class LinkedList<E> {

  private Node<E> head;

  private int size;

  public LinkedList() {
    super();
    this.head = new Node<E>(null);
  }

  /**
   * @description 向链表中指定位置的元素(0 - size),返回新节点
   * @author marker.li lyl
   * @param data
   * @param index
   * @throws Exception
   */
  public Node<E> add(E data, int index) throws Exception {
    if (index < 0 || index > this.size) {
      throw new IllegalArgumentException("index out of ...");
    }
    Node<E> cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    Node<E> e = new Node<E>(data);
    cur.next = e;
    this.size++;
    return e;
  }

  /**
   * @description 向链表末尾添加元素,返回新节点
   * @author marker.li lyl
   * @param data
   * @throws Exception
   */
  public Node<E> add(E data) throws Exception {
    return this.add(data, this.size);
  }

  /**
   * @description 向链表尾部添加新节点
   * @author marker.li lyl
   * @param node
   */
  public void add(Node<E> node) {
    Node<E> curr = this.head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = node;
    while (node != null) {
      this.size++;
      node = node.next;
    }
  }

  /**
   * @description 删除链表中指定位置的元素(0 ~ size-1)
   * @author marker.li lyl
   * @param index
   * @return
   * @throws Exception
   */
  public E remove(int index) throws Exception {
    if (index < 0 || index > this.size - 1) {
      throw new IllegalArgumentException("index out of ...");
    }
    Node<E> curr = this.head;
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }
    Node<E> temp = curr.next;
    curr.next = temp.next;
    temp.next = null;
    this.size--;
    return temp.data;
  }

  /**
   * @description 向链表末尾删除元素
   * @author marker.li lyl
   * @return
   * @throws Exception
   */
  public E remove() throws Exception {
    return this.remove(this.size - 1);
  }

  /**
   * @description 删除链表中的重复元素(外循环 + 内循环)
   * @author rico 时间复杂度：O(n^2)
   */
  public void removeDuplicateNodes() {
    Node<E> curr = this.head;
    while (curr != null) {
      Node<E> ne = curr.next;
      while (ne != null && ne.next != null) {
        if (Objects.equals(ne.data, ne.next.data)) {
          Node<E> de = ne.next;
          ne.next = de.next;
          de.next = null;
          this.size--;
        }
        ne = ne.next;
      }
      curr = curr.next;
    }
  }

  /**
   * @description 找出单链表中倒数第K个元素(双指针法,相差K-1步)
   * @author marker.li lyl
   * @param k
   * @return 时间复杂度：O(n)
   */
  public Node<E> getEndK(int k) {
    if (k > this.size) {
      throw new IllegalArgumentException("index out of ...");
    }
    Node<E> quick1 = this.head;
    Node<E> quick2 = this.head;
    for (int i = 0; i < k; i++) {
      quick1 = quick1.next;
    }
    while (quick1 != null && quick1.next != null) {
      quick1 = quick1.next;
      quick2 = quick2.next;
    }
    return quick2;
  }

  /**
   * @description 反转链表
   * @author marker.li lyl
   */
  public void reverseLinkedList() {
    Node<E> curr = this.head.next;
    Node<E> pred = null;
    while (curr != null) {
      Node<E> next = curr.next;
      curr.next = pred;
      pred = curr;
      curr = next;
    }
    this.head.next = pred;
  }

  /**
   * @description 判断单链表是否为空
   * @author marker.li lyl
   * @return
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * @description 打印输出单链表
   * @author marker.li lyl
   */
  public void print() {
    Node<E> curr = this.head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
  }

  /**
   * @description 从尾到头输出单链表(递归法)
   * @author rico
   * @param head
   */
  public void reversePrint(Node<E> head) {
    if (head != null) {
      this.reversePrint(head.next);
      System.out.print(head.next.data + " "); // "归来"开始打印
    }

  }

  /**
   * @description 寻找单链表中的中间节点(双指针法)
   * @author marker.li lyl
   */
  public void printMiddleNodes() {
    Node<E> quick = this.head;
    Node<E> slow = this.head;
    while (quick != null && quick.next != null && quick.next.next != null) {
      quick = slow.next.next;
      slow = slow.next;
    }
    System.out.print(slow.data);
    if (quick.next != null) {// 当链表长度为偶数时，打印第二个中间节点
      System.out.println(slow.next.data);
    }
  }

  /**
   * @description 判断单链表是否有环(双指针法)
   * @author marker.li lyl
   * @return
   */
  public boolean hasLoop() {
    Node<E> quick = this.head;
    Node<E> slow = this.head;
    while (quick != null && quick.next != null && quick.next.next != null) {
      quick = slow.next.next;
      slow = slow.next;
      if (quick == slow) {
        return true;
      }
    }
    return false;
  }

  /**
   * @description 在不知道头结点的前提下，删除指定节点
   * @author marker.li lyl
   * @param node
   * @return
   */
  public boolean deleteNodeWithoutHead(Node<E> node) {
    if (node == null || node.next == null) {
      return false;
    }
    Node<E> n = node.next;
    node.data = n.data;
    node.next = n.next;
    n.next = null;
    n.data = null;
    return true;
  }

  /**
   * @description 判断当前链表与目标链表是否相交(相交与否取决于尾节点是否相同)
   * @author marker.li lyl
   * @param head
   * @return
   */
  public boolean isIntersect(LinkedList<E> list2) {
    Node<E> p = this.head;
    Node<E> p2 = list2.head;
    if (p.next == null || p2.next == null) {
      return false;
    }
    while (p.next != null) {
      p = p.next;
    }
    while (p2.next != null) {
      p2 = p2.next;
    }
    return p == p2;
  }

  /**
   * @description 返回两链表的交点(若不相交，返回null)
   * @author marker.li lyl
   * @param head
   * @return
   */
  public Node<E> getIntersectionPoint(LinkedList<E> list2) {
    Node<E> p = this.head.next;
    Node<E> p2 = list2.head.next;
    if (this.isIntersect(list2)) {
      int length1 = this.size;
      int length2 = list2.size;
      int length = length1 - length2;
      if (length > 0) {
        for (int i = 0; i < length; i++) {
          p = p.next;
        }
      } else {
        for (int i = 0; i < length; i++) {
          p2 = p2.next;
        }
      }
      while (p != p2) {
        p = p.next;
        p2 = p2.next;
      }
    }
    return p;
  }

  /**
   * @description 返回链表的长度
   * @author marker.li lyl
   * @return
   */
  public int size() {
    return size;
  }

  public class Node<T> {

    Node<T> next;

    T data;

    public Node(T data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

}
