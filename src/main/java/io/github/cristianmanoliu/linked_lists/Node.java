package io.github.cristianmanoliu.linked_lists;

public class Node {

  private int value;
  private Node next;

  public Node(int value) {
    this.value = value;
    this.next = null;
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Node{" + "value=" + value + ", next=" + next + '}';
  }
}