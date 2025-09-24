package io.github.cristianmanoliu.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

  @Test
  public void initWithValue() {
    LinkedList linkedList = new LinkedList(1);
    assertEquals(1, linkedList.getHead().getValue());
    assertEquals(1, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());
  }

  @Test
  public void initWithoutValue() {
    LinkedList linkedList = new LinkedList();
    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());
  }

  @Test
  public void append() {
    LinkedList linkedList = new LinkedList();
    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());

    linkedList.append(2);
    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());

    linkedList.append(3);
    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(3, linkedList.getTail().getValue());
    assertEquals(2, linkedList.getLength());
  }

  @Test
  public void removeLast() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(3, linkedList.getTail().getValue());
    assertEquals(3, linkedList.getLength());

    assertEquals(3, linkedList.removeLast().getValue());

    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(1, linkedList.getTail().getValue());
    assertEquals(2, linkedList.getLength());

    assertEquals(1, linkedList.removeLast().getValue());

    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());

    assertEquals(2, linkedList.removeLast().getValue());

    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());

    assertNull(linkedList.removeLast());

    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());
  }

  @Test
  public void prepend() {
    LinkedList linkedList = new LinkedList();
    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());

    linkedList.prepend(2);
    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());

    linkedList.prepend(3);
    assertEquals(3, linkedList.getHead().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(2, linkedList.getLength());

    linkedList.prepend(1);
    assertEquals(1, linkedList.getHead().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(3, linkedList.getLength());
  }

  @Test
  public void removeFirst() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);

    assertEquals(1, linkedList.getHead().getValue());
    assertEquals(3, linkedList.getTail().getValue());
    assertEquals(3, linkedList.getLength());

    assertEquals(1, linkedList.removeFirst().getValue());

    assertEquals(2, linkedList.getHead().getValue());
    assertEquals(3, linkedList.getTail().getValue());
    assertEquals(2, linkedList.getLength());

    assertEquals(2, linkedList.removeFirst().getValue());

    assertEquals(3, linkedList.getHead().getValue());
    assertEquals(3, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());

    assertEquals(3, linkedList.removeFirst().getValue());

    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());

    assertNull(linkedList.removeFirst());

    assertNull(linkedList.getHead());
    assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());
  }

  @Test
  public void get() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    assertNull(linkedList.get(-1));
    assertNull(linkedList.get(4));
    assertEquals(2, linkedList.get(0).getValue());
    assertEquals(1, linkedList.get(1).getValue());
    assertEquals(3, linkedList.get(2).getValue());
  }

  @Test
  public void set() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    assertFalse(linkedList.set(-1, 0));
    assertFalse(linkedList.set(3, 0));

    assertTrue(linkedList.set(0, 20));
    assertEquals(20, linkedList.get(0).getValue());

    assertEquals(20, linkedList.getHead().getValue());
    assertEquals(1, linkedList.getHead().getNext().getValue());
    assertEquals(3, linkedList.getTail().getValue());
    assertEquals(3, linkedList.getLength());
  }

  @Test
  public void insert() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    assertFalse(linkedList.insert(-1, 0));

    assertTrue(linkedList.insert(3, 0));
    assertEquals(2, linkedList.get(0).getValue());
    assertEquals(1, linkedList.get(1).getValue());
    assertEquals(3, linkedList.get(2).getValue());
    assertEquals(0, linkedList.get(3).getValue());

    assertTrue(linkedList.insert(0, 4));

    assertEquals(4, linkedList.get(0).getValue());
    assertEquals(2, linkedList.get(1).getValue());
    assertEquals(1, linkedList.get(2).getValue());
    assertEquals(3, linkedList.get(3).getValue());
    assertEquals(0, linkedList.get(4).getValue());

    assertTrue(linkedList.insert(1, 5));

    assertEquals(4, linkedList.get(0).getValue());
    assertEquals(5, linkedList.get(1).getValue());
    assertEquals(2, linkedList.get(2).getValue());
    assertEquals(1, linkedList.get(3).getValue());
    assertEquals(3, linkedList.get(4).getValue());
    assertEquals(0, linkedList.get(5).getValue());
  }

  @Test
  public void remove() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    assertNull(linkedList.remove(-1));
    assertNull(linkedList.remove(3));

    assertEquals(1, linkedList.remove(1).getValue());

    assertEquals(2, linkedList.get(0).getValue());
    assertEquals(3, linkedList.get(1).getValue());

    assertEquals(2, linkedList.remove(0).getValue());

    assertEquals(3, linkedList.get(0).getValue());

    assertEquals(3, linkedList.remove(0).getValue());

    assertNull(linkedList.remove(0));

  }

  @Test
  public void reverse() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    linkedList.reverse();

    assertEquals(3, linkedList.getHead().getValue());
    assertEquals(1, linkedList.getHead().getNext().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(3, linkedList.getLength());
  }
}