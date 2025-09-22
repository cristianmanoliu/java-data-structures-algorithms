package io.github.cristianmanoliu.double_linked_list;

import java.util.List;

public class DoubleLinkedList {

  private Node head;
  private Node tail;
  private int length;

  public DoubleLinkedList() {
    head = null;
    tail = null;
    length = 0;
  }

  public DoubleLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public DoubleLinkedList(List<Integer> values) {
    for (int value : values) {
      append(value);
    }
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
    }
    tail = newNode;
    length++;
  }

  public int getLength() {
    return length;
  }

  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }

  public List<Integer> toList() {
    Node current = head;
    List<Integer> result = new java.util.ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      result.add(current.value);
      current = current.next;
    }
    return result;
  }

  class Node {

    int value;
    Node next;
    Node prev;

    Node(int value) {
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }

}
