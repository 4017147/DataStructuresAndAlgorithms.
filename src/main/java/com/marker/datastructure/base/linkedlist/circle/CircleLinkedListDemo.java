package com.marker.datastructure.base.linkedlist.circle;

import java.util.Objects;

import com.marker.datastructure.base.linkedlist.AbstractList;

public class CircleLinkedListDemo<E> extends AbstractList<E> {

  private Node<E> first;

  private Node<E> last;

  private Node<E> current;

  @Override
  public void clear() {
    first = null;
    last = null;
    this.size = 0;
  }

  public void reset() {
    current = first;
  }

  public E next() {
    if (current == null) return null;
    current = current.next;
    return current.element;
  }

  public E remove() {
    if (this.current == null) return null;
    Node<E> next = current.next;
    E element = this.remove(current);
    if (size == 0) {
      current = null;
    } else {
      current = next;
    }
    return element;
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
    super.rangeCheckOfAdd(index);
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
      Node<E> newNode = new Node<E>(prev, element, node);
      prev.next = node;
      newNode.next = node;
    }
    this.size++;
  }

  @Override
  public E remove(int index) {
    this.rangeCheck(index);
    Node<E> node = this.node(index);
    return this.remove(node);
  }

  private E remove(Node<E> node) {
    if (this.size == 1) {
      this.first = null;
      this.last = null;
    } else {
      Node<E> prev = node.prev;
      Node<E> next = node.next;
      prev.next = next;
      next.prev = prev;
      if (node == this.first) {
        this.first = next;
      }
      if (node == this.last) {
        this.last = prev;
      }
    }
    size--;
    return node.element;
  }

  @Override
  public int indexOf(E element) {
    if (element == null) {
      Node<E> node = this.first;
      for (int i = 0; i < size; i++) {
        if (node.element == null) return i;
        node = node.next;
      }
    } else {
      Node<E> node = this.first;
      for (int i = 0; i < size; i++) {
        if (Objects.equals(element, node.element)) return i;
        node = node.next;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  public Node<E> node(int index) {
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
      return "Node [element=" + element + ", prev=" + prev + ", next=" + next + "]";
    }


  }

}
