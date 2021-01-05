package com.marker.datastructure.queue;

import java.util.Arrays;

public class SeqQueue<E> {

  private Object[] queue;

  private int size;

  private int capacity;


  public SeqQueue() {
    this(10);
  }

  public SeqQueue(int capacity) {
    super();
    this.queue = new Object[capacity];
    this.capacity = capacity;
  }


  public E pop() {
    if (this.isEmpty()) {
      return null;
    }
    E e = (E) this.queue[0];
    System.arraycopy(this.queue, 1, this.queue, 0, size - 1);
    queue[size - 1] = null;
    this.size--;
    return e;
  }

  public void put(E data) {
    if (!this.isFull()) {
      this.queue[this.size++] = data;
    }
  }

  public boolean isFull() {
    return this.size >= this.capacity;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public E peek() {
    if (this.isEmpty()) {
      return null;
    }
    return (E) queue[0];
  }

  @Override
  public String toString() {
    return "SeqQueue [queue=" + Arrays.toString(queue) + ", size=" + size + ", capacity=" + capacity
        + "]";
  }


  public static void main(String[] args) {
    SeqQueue<String> queue = new SeqQueue<>();
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


}
