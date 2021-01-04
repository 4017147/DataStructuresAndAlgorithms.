package com.marker.datastructure.stack;

import java.util.Arrays;

/**
 * 顺序栈-数组作为底层实现
 * 
 * @describe
 * @author marker.li lyl
 * @date 2021/01/04
 */
public class SeqStack<E> {

  private Object[] stack;

  private int top;

  private int capacity;

  public SeqStack() {
    this(10);
  }

  public SeqStack(int capacity) {
    this.stack = new Object[capacity];
    this.top = -1;
    this.capacity = capacity;
  }

  public E pop() {
    if (this.top == -1) {
      return null;
    }
    E e = (E) this.stack[top];
    this.stack[top--] = null;
    return e;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public void push(E e) {
    if (this.top == this.capacity - 1) {
      return;
    } else {
      this.stack[++this.top] = e;
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(stack);
  }

  public static void main(String[] args) {
    SeqStack<String> stack = new SeqStack<String>();
    stack.push("marker");
    stack.push("marker2");
    stack.push("marker3");
    stack.push("marker4");
    System.out.println(stack.toString());
    String e = stack.pop();
    String e2 = stack.pop();
    String e3 = stack.pop();
    System.out.println(e);
    System.out.println(e2);
    System.out.println(e3);
    System.out.println(stack.toString());
  }
}
