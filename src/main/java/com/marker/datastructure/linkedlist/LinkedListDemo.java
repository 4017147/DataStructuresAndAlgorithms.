package com.marker.datastructure.linkedlist;

import java.util.LinkedList;

public class LinkedListDemo<E> extends AbstractList<E> {

//  private LinkedList<E> es;

  private Node<E> first;

  private Node<E> last;


  @Override
  public void clear() {
    for (Node<E> x = this.first; x != null;) {
      Node<E> next = x.next;
      x.element = null;
      x.next = null;
      x.prev = null;
      x = next;
    }
    this.first = this.last = null;
    this.size = 0;
  }

  private void linkFirst(E e) {
    Node<E> f = this.first;
    Node<E> newNode = new Node<E>(null, e, f);
    this.first = newNode;
    if (f == null) {
      this.last = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }

  private void linkLast(E e) {
    Node<E> l = this.last;
    Node<E> newNode = new Node<E>(l, e, null);
    this.last = newNode;
    if (l == null) {
      this.first = newNode;
    } else {
      l.next = newNode;
    }
    size++;
  }

  @Override
  public E get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E set(int index, E element) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(E element) {

  }


  @Override
  public void add(int index, E element) {
    this.rangeCheckOfAdd(index);
    if (index == this.size) {
      Node<E> oldLast = this.last;
      this.last = new Node<E>(oldLast, element, this.first);
      if (oldLast == null) {
        this.first = this.last;
        this.first.next = this.last;
        this.first.prev = this.last;
        this.last.prev = this.first;
      } else {
        oldLast.next = this.last;
        this.first.prev = this.last;
      }
    } else {
      Node<E> node = this.node(index);
      Node<E> prev = node.prev;
      Node<E> next = node.next;
      Node<E> newNode = new Node<E>(prev, element, next);
      prev.next = newNode;
      next.prev = newNode;
    }
    size++;
  }

  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int indexOf(E element) {
    // TODO Auto-generated method stub
    return 0;
  }

  private Node<E> node(int index) {
    this.rangeCheck(index);
    if (index < this.size >> 1) {
      Node<E> node = this.first;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      return node;
    } else {
      Node<E> node = this.last;
      for (int i = size - 1; i > index; i--) {
        node = node.prev;
      }
      return node;
    }
  }


  private static class Node<E> {
    private Node<E> prev;
    private E element;
    private Node<E> next;


    public Node(Node<E> prev, E element, Node<E> next) {
      super();
      this.prev = prev;
      this.element = element;
      this.next = next;
    }


    @Override
    public String toString() {
      return "Node [prev=" + prev + ", element=" + element + ", next=" + next + "]";
    }

  }

}
