package io.github.cristianmanoliu.linked_lists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

  public static void removeDuplicates(LinkedList list) {
    if (list == null || list.getHead() == null) {
      return;
    }

    Set<Integer> seenValues = new HashSet<>();

    Node current = list.getHead();
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
