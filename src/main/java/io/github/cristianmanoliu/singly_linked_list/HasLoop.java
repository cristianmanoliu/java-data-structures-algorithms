package io.github.cristianmanoliu.singly_linked_list;

import io.github.cristianmanoliu.singly_linked_list.LinkedList.Node;

public class HasLoop {

  public static boolean hasLoop(LinkedList linkedList) {
    if (linkedList.getHead() == null) {
      return false;
    }

    Node slowPointer = linkedList.getHead();
    Node fastPointer = linkedList.getHead();

    while (fastPointer != null && fastPointer.getNext() != null) {
      // move slow pointer one step
      slowPointer = slowPointer.getNext();
      // move fast pointer two steps
      fastPointer = fastPointer.getNext().getNext();

      // if they meet, there is a loop
      if (slowPointer == fastPointer) {
        return true;
      }
    }

    // if we reach the end, there is no loop
    return false;
  }

}
