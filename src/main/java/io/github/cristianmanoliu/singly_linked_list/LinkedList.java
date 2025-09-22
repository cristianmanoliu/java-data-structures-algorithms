package io.github.cristianmanoliu.singly_linked_list;

import java.util.List;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;
  public LinkedList(List<Integer> values) {
    if (values == null || values.isEmpty()) {
      head = null;
      tail = null;
      length = 0;
      return;
    }

    Node newNode = new Node(values.get(0));
    head = newNode;
    tail = newNode;
    length = 1;

    for (int i = 1; i < values.size(); i++) {
      append(values.get(i));
    }
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public LinkedList() {
    head = null;
    tail = null;
    length = 0;
  }

  public boolean set(int index, int value) {
    // This can leverage get method
    if (index < 0 || index >= length) {
      return false;
    }

    Node tmpNode = head;
    for (int i = 0; i < index; i++) {
      tmpNode = tmpNode.getNext();
    }

    tmpNode.setValue(value);
    return true;
  }

  public Node get(int index) {
    Node foundNode = null;
    if (index < length && index >= 0) {
      foundNode = head;
      for (int i = 0; i < index; i++) {
        foundNode = foundNode.getNext();
      }
    }
    return foundNode;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    Node temp = null;
    if (length == 1) {
      temp = head;
      head = null;
      tail = null;
      length--;
    } else if (length > 1) {
      temp = head;
      head = head.getNext();
      length--;
    }
    return temp;
  }

  public Node removeLast() {
    Node removedNode = null;
    if (length == 1) {
      removedNode = head;
      head = null;
      tail = null;
      length--;
    } else if (length > 1) {
      Node tmp = head;
      while (tmp.getNext() != tail) {
        tmp = tmp.getNext();
      }
      tmp.setNext(null);
      removedNode = tail;
      tail = tmp;
      length--;
    }
    return removedNode;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
    } else {
      tail.setNext(newNode);
    }
    tail = newNode;
    length++;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value);
      return true;
    }

    if (index == length) {
      append(value);
    }

    Node prev = get(index - 1);
    Node toBeShifted = prev.getNext();
    Node newNode = new Node(value);

    prev.setNext(newNode);
    newNode.setNext(toBeShifted);
    length++;

    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node removedNode;
    if (index == 0) {
      removedNode = removeFirst();
    } else if (index == length - 1) {
      removedNode = removeLast();
    } else {
      Node prevNode = get(index - 1);
      removedNode = prevNode.getNext();
      prevNode.setNext(removedNode.getNext());
      length--;
    }
    return removedNode;
  }

  public void reverse() {
    Node tmpNode = head;
    head = tail;
    tail = tmpNode;
    Node beforeTargetNode = null;
    Node afterTargetNode;
    for (int i = 0; i < length; i++) {
      afterTargetNode = tmpNode.getNext();
      tmpNode.setNext(beforeTargetNode);
      beforeTargetNode = tmpNode;
      tmpNode = afterTargetNode;
    }
  }

  public int getLength() {
    return length;
  }

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public List<Integer> toList() {
    List<Integer> list = new java.util.ArrayList<>();
    Node tmp = head;
    while (tmp != null) {
      list.add(tmp.getValue());
      tmp = tmp.getNext();
    }
    return list;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void resetFromHead(Node newHead) {
    this.head = newHead;
    // Recompute tail and length
    Node t = newHead, last = null;
    int len = 0;
    while (t != null) {
      last = t;
      len++;
      t = t.getNext();
    }
    this.tail = last;
    this.length = len;
  }

  static class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
      this.next = null;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public String toString() {
      return "Node{" + "value=" + value + ", next=" + next + '}';
    }
  }
}

