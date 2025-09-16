package io.github.cristianmanoliu.linked_lists;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

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
    if (index < 0 || index > length) {
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

  public int getLength() {
    return length;
  }

  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }
}

