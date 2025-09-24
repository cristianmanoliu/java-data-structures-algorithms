package io.github.cristianmanoliu.datastructures.linkedlist;

import io.github.cristianmanoliu.datastructures.linkedlist.LinkedList.Node;

// Not allowed to count the length of the linked list
// No access to length property
public class FindMiddleNode {

  public static Node findMiddleNode(LinkedList linkedList) {
    if (linkedList.getHead() == null) {
      return null;
    }

    Node slowPointer = linkedList.getHead();
    Node fastPointer = linkedList.getHead();

    while (fastPointer != null && fastPointer.getNext() != null) {
      // move slow pointer one step
      slowPointer = slowPointer.getNext();
      // move fast pointer two steps
      fastPointer = fastPointer.getNext().getNext();
    }

    // when fastPointer reaches the end, slowPointer will be at the middle
    return slowPointer;
  }
}
