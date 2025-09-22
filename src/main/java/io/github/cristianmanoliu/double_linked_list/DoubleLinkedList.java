package io.github.cristianmanoliu.double_linked_list;

public class DoubleLinkedList {

  private Node head;
  private Node tail;
  private int length;

  public DoubleLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
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
