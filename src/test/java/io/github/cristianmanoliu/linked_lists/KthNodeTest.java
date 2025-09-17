package io.github.cristianmanoliu.linked_lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KthNodeTest {

  @Test
  @DisplayName("Returns null for an empty list")
  void returnsNullForEmptyList() {
    LinkedList linkedList = new LinkedList();
    assertNull(KthNode.findKthNode(linkedList, 1));
  }

  @Test
  @DisplayName("Returns the only node for k=1 in a single-node list")
  void returnsOnlyNodeForSingleNodeList() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    assertEquals(1, KthNode.findKthNode(linkedList, 1).getValue());
  }

  @Test
  @DisplayName("Returns null for k greater than the list size")
  void returnsNullForKGreaterThanListSize() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    assertNull(KthNode.findKthNode(linkedList, 3));
  }

  @Test
  @DisplayName("Returns the kth node for a valid k in a multi-node list")
  void returnsKthNodeForValidK() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    Node kthNode = KthNode.findKthNode(linkedList, 2);
    assertEquals(2, kthNode.getValue());
  }

  @Test
  @DisplayName("Returns null for k=0")
  void returnsNullForKEqualToZero() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    assertNull(KthNode.findKthNode(linkedList, 0));
  }

  @Test
  @DisplayName("Returns the last node for k equal to the list size")
  void returnsLastNodeForKEqualToListSize() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    Node kthNode = KthNode.findKthNode(linkedList, 3);
    assertEquals(1, kthNode.getValue());
  }

}