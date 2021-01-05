package com.marker.datastructure.stack;

import java.util.LinkedList;

public class LinkedListStack<E> {

  private LinkedList<E> stack;

  public LinkedListStack() {
    super();
    this.stack = new LinkedList<>();
  }

  public boolean isEmpty() {
    return this.stack.isEmpty();
  }

  public void push(E e) {
    this.stack.addFirst(e);
  }

  public E pop() throws Exception {
    if (stack.isEmpty()) {
      throw new Exception("栈已满...");
    }
    return this.stack.pop();
  }

  @Override
  public String toString() {
    return stack.toString();
  }

  public static void main(String[] args) throws Exception {
    LinkedListStack<String> stack = new LinkedListStack<>();
    stack.push("Rico");
    stack.push("TJU");
    stack.push("Livia");
    stack.push("NEU");

    System.out.println(stack);

    stack.pop();
    System.out.println(stack);
  }

}
