package io.github.cristianmanoliu.double_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {

  @Test
  public void testEmptyConstructor() {
    DoubleLinkedList list = new DoubleLinkedList();

    assertEquals(Collections.emptyList(), list.toList());
  }

  @Test
  public void testSingleValueConstructor() {
    DoubleLinkedList list = new DoubleLinkedList(1);

    assertEquals(List.of(1), list.toList());
  }

  @Test
  public void testListOfValuesConstructor() {
    DoubleLinkedList list = new DoubleLinkedList(List.of(1, 2));

    assertEquals(List.of(1, 2), list.toList());
  }

  @Test
  public void testAppend() {
    DoubleLinkedList list = new DoubleLinkedList();
    list.append(1);
    list.append(2);

    assertEquals(List.of(1, 2), list.toList());
  }

  @Test
  public void testRemoveLast() {
    DoubleLinkedList list = new DoubleLinkedList(List.of(1, 2, 3));
    DoubleLinkedList.Node removedNode = list.removeLast();
    assertEquals(3, removedNode.value);
    assertNull(removedNode.next);
    assertNull(removedNode.prev);
    assertEquals(List.of(1, 2), list.toList());
  }

}