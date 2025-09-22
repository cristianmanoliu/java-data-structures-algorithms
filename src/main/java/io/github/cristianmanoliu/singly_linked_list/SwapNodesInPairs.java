package io.github.cristianmanoliu.singly_linked_list;

import io.github.cristianmanoliu.singly_linked_list.LinkedList.Node;

public class SwapNodesInPairs {

  public static void swapPairs(LinkedList linkedList) {
    if (linkedList == null || linkedList.getHead() == null || linkedList.getHead().getNext() == null) {
      return; // No need to swap if the list is empty or has only one node
    }

    Node dummy = new Node(0); // Create a dummy node to simplify edge cases
    dummy.setNext(linkedList.getHead());
    Node prev = dummy;
    Node current = linkedList.getHead();

    while (current != null && current.getNext() != null) {
      Node first = current;
      Node second = current.getNext();

      // Swapping
      first.setNext(second.getNext());
      second.setNext(first);
      prev.setNext(second);

      // Re-positioning prev and current for the next pair
      prev = first;
      current = first.getNext();
    }

    // Update the head of the linked list
    linkedList.resetFromHead(dummy.getNext());
  }

}
