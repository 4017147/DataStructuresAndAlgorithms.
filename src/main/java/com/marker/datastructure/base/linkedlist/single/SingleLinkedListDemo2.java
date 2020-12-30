package com.marker.datastructure.base.linkedlist.single;

import java.util.Objects;

import com.marker.datastructure.base.linkedlist.AbstractList;

public class SingleLinkedListDemo2<E> extends AbstractList<E> {

  private Node<E> frist;

  public SingleLinkedListDemo2() {
    super();
    this.frist = new Node<E>(null, null);
  }

  @Override
  public void clear() {
    this.size = 0;
    this.frist = new Node<E>(null, null);
  }

  @Override
  public E get(int index) {
    return this.node(index).element;
  }

  @Override
  public E set(int index, E element) {
    Node<E> node = this.node(index);
    E old = node.element;
    node.element = element;
    return old;
  }

  @Override
  public void add(int index, E element) {
    this.rangeCheckOfAdd(index);
    Node<E> prev = index == 0 ? this.frist : this.node(index - 1);
    prev.next = new Node<E>(prev.next, element);
    this.size++;
  }

  @Override
  public E remove(int index) {
    this.rangeCheck(index);
    Node<E> prev = index == 0 ? this.frist : this.node(index - 1);
    Node<E> node = prev.next;
    prev.next = node.next;
    this.size--;
    return node.element;
  }

  @Override
  public int indexOf(E element) {
    Node<E> node = this.frist;
    if (element == null) {
      for (int i = 0; i < this.size; i++) {
        if (node.element == null) return i;
        node = node.next;
      }
    } else {
      for (int i = 0; i < this.size; i++) {
        if (Objects.equals(node.element, element)) return i;
        node = node.next;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  private Node<E> node(int index) {
    this.rangeCheck(index);
    Node<E> node = this.frist.next;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  private static class Node<E> {
    private E element;
    private Node<E> next;


    public Node(Node<E> next, E element) {
      super();
      this.next = next;
      this.element = element;
    }


    @Override
    public String toString() {
      return "Node [element=" + element + ", next=" + next + "]";
    }

  }

  @Override
  public String toString() {
    return "SingleLinkedListDemo2 [frist=" + frist + "]";
  }



}
