package io.github.cristianmanoliu.linked_lists;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HasLoopTest {

  @Test
  @DisplayName("Returns false for an empty list")
  void returnsFalseForEmptyList() {
    LinkedList linkedList = new LinkedList();
    assertFalse(HasLoop.hasLoop(linkedList));
  }

  @Test
  @DisplayName("Returns false for a single node without a loop")
  void returnsFalseForSingleNodeNoLoop() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    assertFalse(HasLoop.hasLoop(linkedList));
  }

  @Test
  @DisplayName("Returns false for a multi-node list with no loop")
  void returnsFalseForMultiNodeNoLoop() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(2);
    assertFalse(HasLoop.hasLoop(linkedList));
  }

  @Test
  @DisplayName("Returns true for a multi-node list with a loop at the end")
  void returnsTrueForMultiNodeLoopAtEnd() {
    LinkedList linkedList = new LinkedList();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    // The tail points to the head, creating a loop
    linkedList.getTail().setNext(linkedList.getHead());

    assertTrue(HasLoop.hasLoop(linkedList));
  }
}