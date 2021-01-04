package com.marker.datastructure.linkedlist;

import java.util.Hashtable;

/**
 * 
 * @describe 单链表
 * @author marker.li lyl
 * @date 2021/01/04
 */
public class SingleLinkedList {

  public Node head;

  /**
   * 链表添加结点: 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
   * 
   * @param data
   */
  public void add(int e) {
    Node node = new Node(e);
    if (head == null) {
      this.head = node;
      return;
    }
    Node temp = this.head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = node;
  }

  /**
   * 链表删除结点: 把要删除结点的前结点指向要删除结点的后结点，即直接跳过待删除结点
   * 
   * @param index
   * @return
   */
  public boolean delete(int index) {
    if (index < 1 || index > length()) {
      return false;
    }
    if (index == 1) {
      this.head = this.head.next;
      return true;
    }
    int i = 1;
    Node pred = this.head;
    Node curr = pred.next;
    while (curr != null) {
      i++;
      if (i == index) {
        pred.next = curr.next;
        return true;
      }
      pred = pred.next;
      curr = curr.next;
    }
    return true;
  }

  /**
   * 链表添加结点: 找到链表的末尾结点，把新添加的数据作为末尾结点的后续结点
   * 
   * @param data
   */
  public int length() {
    int length = 0;
    Node curNode = head;
    while (curNode != null) {
      length++;
      curNode = curNode.next;
    }
    return length;
  }

  /**
   * 链表结点排序,并返回排序后的头结点: 选择排序算法,即每次都选出未排序结点中最小的结点，与第一个未排序结点交换
   * 
   * @return
   */
  public Node sort() {
    Node curr = this.head;
    while (curr != null) {
      Node next = curr.next;
      while (next != null) {
        if (curr.e > next.e) {
          int temp = curr.e;
          curr.e = next.e;
          next.e = temp;
        }
        next = next.next;
      }
      curr = curr.next;
    }
    return head;
  }

  /**
   * 去掉重复元素: 需要额外的存储空间hashtable，调用hashtable.containsKey()来判断重复结点
   */
  public void distinct() {
    Node curr = this.head;
    Node pre = null;
    Hashtable<Integer, Integer> h = new Hashtable<>();
    while (curr != null) {
      if (h.containsKey(curr.e)) {
        pre.next = curr.next;
      } else {
        h.put(curr.e, 1);
        pre = curr;
      }
      curr = curr.next;
    }
  }

  /**
   * 反转链表，在反转指针钱一定要保存下个结点的指针
   */
  public void reserveLink() {
    Node curr = this.head;
    Node head = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = head;
      head = curr;
      curr = next;
    }
    this.head = head;
  }

  /**
   * 反向输出链表，三种方式： 方法一、先反转链表，再输出链表，需要链表遍历两次 方法二、把链表中的数字放入栈中再输出，需要维护额外的栈空间
   * 方法三、依据方法2中栈的思想，通过递归来实现，递归起始就是将先执行的数据压入栈中，再一次出栈
   */
  public void reservePrint(Node e) {
    if (e != null) {
      this.reservePrint(e.next);
      System.out.println(e.e);
    }
  }

  public Node findMiddleNode() {
    Node quick = this.head;
    Node slow = this.head;

    while (quick.next != null && quick.next.next != null) {
      slow = slow.next;
      quick = quick.next.next;
    }
    return slow;
  }

  /**
   * 打印结点
   */
  public void printLink() {
    Node curNode = head;
    while (curNode != null) {
      System.out.print(curNode.e + " ");
      curNode = curNode.next;
    }
    System.out.println();
  }

  /**
   * 判断链表是否有环： 设置快指针和慢指针，慢指针每次走一步，快指针每次走两步 当快指针与慢指针相等时，就说明该链表有环
   */
  public boolean isRinged() {
    if (head == null) return false;
    Node slow = this.head;
    Node fast = this.head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /**
   * 返回链表的最后一个结点
   */
  public Node lastNode() {
    return this.lastNodeByNode(this.head);
  }

  /**
   * 返回链表指定节点的最后一个节点
   */
  public Node lastNodeByNode(Node node) {
    Node last = node;
    while (last.next != null) {
      last = last.next;
    }
    return last;
  }

  /**
   * 判断两个链表是否相交： 两个链表相交，则它们的尾结点一定相同，比较两个链表的尾结点是否相同即可
   */
  public boolean isCross(Node head1, Node head2) {
    Node l1 = this.lastNodeByNode(head1);
    Node l2 = this.lastNodeByNode(head2);
    if (l1 == l2) return true;
    return false;
  }

  /**
   * 如果链表相交，求链表相交的起始点： 1、首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义 2、求出两个链表长度之差：len=length1-length2
   * 3、让较长的链表先走len步 4、然后两个链表同步向前移动，没移动一次就比较它们的结点是否相等，第一个相等的结点即为它们的第一个相交点
   */
  public Node findCorssPoing(SingleLinkedList linked1, SingleLinkedList linked2) {
    Node first1 = linked1.head;
    Node first2 = linked2.head;
    if (this.isCross(linked1.head, linked2.head)) {
      int len1 = linked1.length();
      int len2 = linked2.length();
      int len = len1 - len2;
      if (len > 0) {
        for (int i = len; i >= 0; i--) {
          first1 = first1.next;
        }
      } else if (len < 0) {
        for (int i = len; i >= 0; i--) {
          first2 = first2.next;
        }
      }
      while (first1 != first2) {
        first1 = first1.next;
        first2 = first2.next;
      }
      return first1;
    }
    return null;
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
