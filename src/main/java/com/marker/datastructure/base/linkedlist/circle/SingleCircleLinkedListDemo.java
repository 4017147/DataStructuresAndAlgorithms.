package com.marker.datastructure.base.linkedlist.circle;

import com.marker.datastructure.base.linkedlist.AbstractList;

public class SingleCircleLinkedListDemo<E> extends AbstractList<E> {

  private Node<E> first;

  @Override
  public void clear() {
    this.size = 0;
    this.first = null;
  }

  @Override
  public E get(int index) {
    // TODO Auto-generated method stub
    return this.node(index).element;
  }

  @Override
  public E set(int index, E element) {
    // TODO Auto-generated method stub
    Node<E> node = this.node(index);
    E old = node.element;
    node.element = element;
    return old;
  }

  @Override
  public void add(int index, E element) {
    // TODO Auto-generated method stub
    this.rangeCheckOfAdd(index);
    if (index == 0) {
      Node<E> newNode = new Node<E>(element, this.first);
      Node<E> last = (size == 0) ? newNode : this.node(this.size - 1);
      last.next = newNode;
      this.first = newNode;
    } else {
      Node<E> prev = this.node(index - 1);
      prev.next = new Node<E>(element, prev.next);
    }
    this.size++;
  }

  @Override
  public E remove(int index) {
    this.rangeCheck(index);
    Node<E> node = this.first;
    if (index == 0) {
      if (this.size == 1) {
        this.first = null;
      } else {
        Node<E> last = this.node(size - 1);
        this.first = node.next;
        last.next = this.first;
      }
    } else {
      Node<E> prev = this.node(index - 1);
      node = prev.next;
      prev.next = node.next;
    }
    this.size--;
    return node.element;
  }

  @Override
  public int indexOf(E element) {
    if (element == null) {
      Node<E> node = first;
      for (int i = 0; i < size; i++) {
        if (node.element == null) return i;
        node = node.next;
      }
    } else {
      Node<E> node = first;
      for (int i = 0; i < size; i++) {
        if (element.equals(node.element)) return i;

        node = node.next;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  private static class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E element, Node<E> next) {
      super();
      this.element = element;
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node [element=" + element + ", next=" + next + "]";
    }
  }

  private Node<E> node(int index) {
    this.rangeCheck(index);
    Node<E> node = this.first;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

}
