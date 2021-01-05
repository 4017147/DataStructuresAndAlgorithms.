package com.marker.datastructure.queue;

/**
 * Title: 基于链表的队列实现
 * 
 * @describe 含头结点(头结点不存储值,添加操作O(1))，尾指针(删除操作O(1))
 * @author marker.li lyl
 * @date 2021/01/05
 */
public class LinkedQueue<E> {

  private Node<E> head;

  private Node<E> near;

  private int size;

  public LinkedQueue() {
    this.head = this.near = new Node<E>(null);
  }

  public void put(E e) {
    Node<E> node = new Node<E>(e);
    near.next = node;
    near = node;
    this.size++;
  }

  public E peek() {
    if (!this.isEmpty()) {
      return this.head.next.data;
    }
    return null;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public E pop() {
    if (!this.isEmpty()) {
      E e = null;
      Node<E> node = head.next;
      head.next = node.next;
      e = node.data;
      node.data = null;
      node.next = null;
      size--;
      return e;
    }
    return null;
  }

  @Override
  public String toString() {
    Node<E> cur = head.next;
    StringBuilder sb = new StringBuilder();
    while (cur != null) {
      sb.append(cur.data).append(" ");
      cur = cur.next;
    }
    return sb.toString();
  }


  public static void main(String[] args) {
    LinkedQueue<String> queue = new LinkedQueue<>();
    queue.put("marker");
    queue.put("marker2");
    queue.put("marker3");
    queue.put("marker4");
    System.out.println(queue.peek());
    System.out.println(queue.size);
    String e = queue.pop();
    System.out.println(e);
    String e2 = queue.pop();
    System.out.println(e2);
    System.out.println(queue.toString());
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
