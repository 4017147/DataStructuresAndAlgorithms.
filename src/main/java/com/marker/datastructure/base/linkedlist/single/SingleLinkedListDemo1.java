package com.marker.datastructure.base.linkedlist.single;

import java.util.Objects;

import com.marker.datastructure.base.linkedlist.AbstractList;

/**
 * 
 * @describe 单相链表
 * @author marker.li lyl
 * @date 2020/03/17
 */
public class SingleLinkedListDemo1<E> extends AbstractList<E> {

  private Node<E> first;

  @Override
  public void clear() {
    this.size = 0;
    first = null;
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
    if (index == 0) {
      this.first = new Node<E>(element, this.first);
    } else {
      Node<E> prev = this.node(index - 1);
      prev.next = new Node<E>(element, prev.next);
    }
    this.size++;
  }

  @Override
  public E remove(int index) {
    Node<E> node = this.first;
    if (index == 0) {
      this.first = node.next;
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
    Node<E> node = this.first;
    if (element == null) {
      for (int i = 0; i < size; i++) {
        if (node.element == null) return i;
        node = node.next;
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (Objects.equals(node.element, element)) return i;
        node = node.next;
      }
    }
    return ELEMENT_NOT_FOUND;
  }

  public Node<E> node(int index) {
    this.rangeCheck(index);
    Node<E> node = this.first;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
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

  @Override
  public String toString() {
    return "SingleLinkedListDemo1 [first=" + first + "]";
  }


}
