package com.marker.datastructure.stack;

public class LinkedStack<E> {

  private Node<E> top;

  private int size;


  public void push(E e) {
    Node<E> element = new Node<E>(e);
    element.next = this.top;
    top = element;
    size++;
  }

  public Node<E> pop() {
    Node<E> node = this.top;
    this.top = this.top.next;
    this.size--;
    node.next = null;
    return node;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * @description 打印栈
   * @author rico
   */
  public void print() {
    Node<E> index = top;
    while (index != null) {
      System.out.print(index.data + " ");
      index = index.next;
    }
    System.out.println();
  }

  public Node<E> peek() {
    if (this.isEmpty()) {
      return null;
    }
    Node<E> node = this.top;
    return node;
  }

  public int size() {
    return this.size;
  }

  public static void main(String[] args) {
    LinkedStack<String> stack = new LinkedStack<String>();
    stack.push("marker");
    stack.push("marker2");
    stack.push("marker3");
    stack.push("marker4");
    System.out.println(stack.toString());
    String e = stack.peek().data;
    String e2 = stack.pop().data;
    String e3 = stack.peek().data;
    System.out.println(e);
    System.out.println(e2);
    System.out.println(e3);
    System.out.println("sss:" + stack.toString());
  }

  public static class Node<T> {
    // 包可见性
    Node<T> next;

    T data;

    public Node(T data) {
      super();
      this.data = data;
    }

    public T data() {
      return this.data;
    }

    @Override
    public String toString() {
      return "Node [next=" + next + ", data=" + data + "]";
    }
  }

  @Override
  public String toString() {
    Node<E> index = top;
    StringBuilder sb = new StringBuilder();
    while (index != null) {
      sb.append(index.data).append(" ");
      index = index.next;
    }
    return sb.toString();
  }

}
