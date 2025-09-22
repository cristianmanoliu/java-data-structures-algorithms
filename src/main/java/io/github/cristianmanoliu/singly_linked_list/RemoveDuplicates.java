package io.github.cristianmanoliu.singly_linked_list;

import io.github.cristianmanoliu.singly_linked_list.LinkedList.Node;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

  public static void removeDuplicates(LinkedList linkedList) {
    if (linkedList == null || linkedList.getHead() == null) {
      return;
    }

    Set<Integer> seenValues = new HashSet<>();

    Node current = linkedList.getHead();
    Node previous = null;

    while (current != null) {
      if (seenValues.contains(current.getValue())) {
        // Duplicate: remove current by linking previous to next
        previous.setNext(current.getNext());
      } else {
        // New value: add to set and update previous
        seenValues.add(current.getValue());
        previous = current;
      }
      current = current.getNext();
    }
  }
}
