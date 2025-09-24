package io.github.cristianmanoliu.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMiddleNodeTest {

  @Test
  @DisplayName("Empty list → returns null")
  void emptyList_returnsNull() {
    LinkedList linkedList = new LinkedList();
    assertNull(FindMiddleNode.findMiddleNode(linkedList));
  }

  @Test
  @DisplayName("Single element → returns head")
  void singleElement_returnsHead() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    assertSame(1, FindMiddleNode.findMiddleNode(linkedList).getValue());
  }

  @Test
  @DisplayName("Odd length (5) → returns middle (index 2, zero-based)")
  void oddLength_returnsMiddle() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    linkedList.append(5);
    // expected middle is value 3 (third node, zero-based index 2)
    assertSame(3, FindMiddleNode.findMiddleNode(linkedList).getValue());
  }

  @Test
  @DisplayName("Even length (4) → returns SECOND middle (index 2, zero-based)")
  void evenLength_returnsSecondMiddle() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    linkedList.append(4);
    // SECOND middle should be value 3 (zero-based index 2)
    assertSame(3, FindMiddleNode.findMiddleNode(linkedList).getValue());
  }
}